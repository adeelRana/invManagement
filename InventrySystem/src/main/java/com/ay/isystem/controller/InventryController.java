/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.controller;

import com.ay.isystem.controllerutility.InsertUtils;
import com.ay.isystem.db.DBM;
import com.ay.isystem.db.DbmUtils;
import com.ay.isystem.enums.TransactionType;
import com.ay.isystem.models.EntityBeans.Account;
import com.ay.isystem.models.EntityBeans.DealDetails;
import com.ay.isystem.models.EntityBeans.Deals;
import com.ay.isystem.models.EntityBeans.MasterList;
import com.ay.isystem.models.EntityBeans.PayableReceiveable;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.ProductsVehicles;
import com.ay.isystem.models.EntityBeans.Users;
import com.ay.isystem.models.EntityBeans.Vehicle;
import com.ay.isystem.models.EntityBeans.Vendors;
import com.ay.isystem.models.Login;
import com.ay.isystem.models.Response;
import com.ay.isystem.utililty.Global;
import java.util.HashMap;

/**
 *
 * @author Adeel rana
 */
public class InventryController implements ControllerInterface {

    DbmUtils dbmUtils = new DbmUtils();
    InsertUtils insertUtils = new InsertUtils();

    @Override
    public Response fetch(String param) {
        Response response = new Response();
        switch (param) {
            case "users":
                response.setResponseObject(DBM.getAllRecords(Users.class));
                break;
            case "masterList":
                response.setResponseObject(DBM.getAllRecords(MasterList.class));
                break;
            case "vehicle":
                response.setResponseObject(DBM.getAllRecords(Vehicle.class));
                break;
            case "vendor":
                response.setResponseObject(DBM.getRecordsBy(Vendors.class, "Type", "Vendor"));
                break;
            case "customer":
                response.setResponseObject(DBM.getRecordsBy(Vendors.class, "Type", "Customer"));
                break;
            case "agent":
                response.setResponseObject(DBM.getRecordsBy(Vendors.class, "Type", "Agent"));
                break;
            case "product":
                response.setResponseObject(DBM.getAllRecords(Products.class));
                break;
            case "account":
                response.setResponseObject(DBM.getAllRecords(Account.class));
                break;
            default:
                response.setError(true);
                response.setErrorMsg("Invalid Param");
        }
        return response;
    }

    @Override
    public Response login(Login login) {
        if (dbmUtils.isUserExist(login.getUserName(), 0, false)) {
            if (dbmUtils.islogedIn(login)) {
                Global.LOGGED_USER = (Users) DBM.getRecordsBy(Users.class, "Name", login.getUserName()).get(0);
                Global.LOGGED_USER.setLoggedIn(true);
                return new Response(true, "Login Successful");
            } else {
                return new Response("Incorrect Password");
            }
        } else {
            return new Response("Incorrect User Name");
        }
    }

    @Override
    public Response logout() {
        if (Global.LOGGED_USER.isLoggedIn()) {
            Global.LOGGED_USER = new Users();
            return new Response(true, "Successfully Logged out");
        } else {
            return new Response("You are already Logged out");
        }
    }

    @Override
    public Response insertRecord(Object object, String className) {
        Response response;
        switch (className) {
            case "Users":
                response = insertUtils.insertUsers((Users) object);
                break;
            case "Products":
                response = insertUtils.insertProducts((Products) object);
                break;
            case "ProductsVehicles":
                response = new Response(DBM.insertRecords(ProductsVehicles.class, object));
                break;
            case "Vendors":
                response = new Response(DBM.insertRecords(Vendors.class, object));
                break;
            case "Deals":
                response = new Response(DBM.insertRecords(Deals.class, object));
                break;
            case "Account":
                response = new Response(DBM.insertRecords(Account.class, object));
                break;
            default:
                return new Response("invalid Input");
        }
        return response;
    }

    @Override
    public Response updateRecord(Object object, String className) {
//        if (dbmUtils.isUserExist(user.getName(), user.getId(), true)) {
//            return new Response("User Name Already Exists");
//        } else {
//            return new Response(DBM.updateRecords(Users.class, user));
//        }
        return null;
    }

    @Override
    public Response deleteRecord(long objectId, Class c) {
        return new Response(DBM.deleteRecords(c, objectId), "");
    }

    @Override
    public Response addDeal(Deals dealBean, int transactionType) {
        try {
            if (transactionType == TransactionType.SALE) {
                insertUtils.insertSale(dealBean);
            } else if (transactionType == TransactionType.PURCHASE) {
                insertUtils.insertPurchase(dealBean);
            } else if (transactionType == TransactionType.SALE_RETURN) {
                insertUtils.insertSaleReturn(dealBean);
            } else if (transactionType == TransactionType.PURCHASE_RETURN) {
                insertUtils.insertPurchaseReturns();
            }

        } catch (Exception ex) {
            return new Response("" + ex.getMessage());
        }
        return new Response(dealBean);
    }

    @Override
    public Response deleteDeal(Number dealId, long vendorID, long agentId, int transactionType) {
        try {
            double revertedBalance = 0;
            Products p;
            double qty;

            if (transactionType == TransactionType.SALE) {
                Vendors customer = DBM.getSingleRecordById(Vendors.class, vendorID);
                Vendors agent;
                double agentBalance = 0;

                boolean isDeleted = DBM.deleteRecords(Deals.class, (long) dealId);
                if (isDeleted) {
                    for (Object obj : DBM.getRecordsBy(DealDetails.class, "DealId", dealId)) {
                        DealDetails dd = (DealDetails) obj;
                        p = DBM.getSingleRecordById(Products.class, dd.getProductId());

                        if (dd.getTransactionTypeId() == TransactionType.SALE) {
                            qty = p.getQuantity() + dd.getProductQty();
                            p.setQuantity(qty);
                            revertedBalance += dd.getProductQty() * dd.getProductInvoiceRate();
                            if (agentId != 0) {
                                agentBalance += (dd.getProductInvoiceRate() - dd.getProductSaleRate()) * dd.getProductQty();
                            }
                            DBM.updateRecords(Products.class, p);
                        } else if (dd.getTransactionTypeId() == TransactionType.SALE_RETURN) {
                            qty = p.getQuantity() - dd.getProductQty();
                            p.setQuantity(qty);
                            revertedBalance -= dd.getProductQty() * dd.getProductInvoiceRate();
                            if (agentId != 0) {
                                agentBalance -= (dd.getProductInvoiceRate() - dd.getProductSaleRate()) * dd.getProductQty();
                            }
                            DBM.updateRecords(Products.class, p);
                        }

                    }
                    customer.setCurrentBalance(customer.getCurrentBalance() - revertedBalance);
                    DBM.updateRecords(Vendors.class, customer);

                    if (agentId != 0) {
                        agent = DBM.getSingleRecordById(Vendors.class, agentId);
                        agent.setCurrentBalance(agent.getCurrentBalance() - agentBalance);
                        DBM.updateRecords(Vendors.class, agent);
                    }
                    HashMap hm = new HashMap();
                    hm.put("dealId", dealId);
                    DBM.deleteRecordsBy(DealDetails.class, hm);
                }
            } else if (transactionType == TransactionType.SALE_RETURN) {
                // to dp code here
            } else if (transactionType == TransactionType.PURCHASE) {
                Vendors vendor = DBM.getSingleRecordById(Vendors.class, vendorID);
                double newPrice = 0;
                boolean isDeleted = DBM.deleteRecords(Deals.class, (long) dealId);
                if (isDeleted) {
                    for (Object obj : DBM.getRecordsBy(DealDetails.class, "DealId", dealId)) {
                        DealDetails dd = (DealDetails) obj;

                        p = DBM.getSingleRecordById(Products.class, dd.getProductId());
                        qty = p.getQuantity() - dd.getProductQty();
                        newPrice = ((p.getQuantity() * p.getPrice()) - (dd.getProductQty() * dd.getProductSaleRate())) / (qty);

                        p.setQuantity(qty);
                        p.setPrice(newPrice);

                        revertedBalance += dd.getProductQty() * dd.getProductSaleRate();

                        DBM.updateRecords(Products.class, p);
                    }
                    vendor.setCurrentBalance(vendor.getCurrentBalance() - revertedBalance);
                    DBM.updateRecords(Vendors.class, vendor);

                    HashMap hm = new HashMap();
                    hm.put("dealId", dealId);
                    DBM.deleteRecordsBy(DealDetails.class, hm);
                }
            } else if (transactionType == TransactionType.PURCHASE_RETURN) {

            } else {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        } catch (Exception ex) {
            return new Response(ex.getLocalizedMessage());
        }
        return new Response(true, "Record Deleted Successfully");
    }

    @Override
    public Response BackUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response Restore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public List<Products> addProductsFromExcel(File f) {
//        List li = excelParser.readFromExcelFile(f);
//        ArrayList listOfProducts = (ArrayList) excelParser.getProductsFromFileData(li);
//
//        Products oldProduct;
//        for (Object pr : listOfProducts) {
//            if (dbmUtils.isProductExist((Products) pr)) {
//                oldProduct = dbmUtils.getProduct((Products) pr);
//                oldProduct.setQuantity(oldProduct.getQuantity() + ((Products) pr).getQuantity());
//                DBM.updateRecords(Products.class, oldProduct);
//            } else {
//                DbmUtils.addProduct((Products) pr);
//            }
//        }
//        return DBM.getAllRecords(Products.class);
//    }
    @Override
    public Response addPayableReceiveable(PayableReceiveable tran) {
        if (tran.getPartyType().equalsIgnoreCase("Vendor")) {
            return insertUtils.insertPayable(tran);
        } else {
            return insertUtils.insertReceiveable(tran);
        }
    }

    @Override
    public Response deletePayableReceiveable(long id, Class className) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
