/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.controllerutility;

import com.ay.isystem.db.DBM;
import com.ay.isystem.db.DbmUtils;
import com.ay.isystem.models.EntityBeans.Account;
import com.ay.isystem.models.EntityBeans.DealDetails;
import com.ay.isystem.models.EntityBeans.Deals;
import com.ay.isystem.models.EntityBeans.PayableReceiveable;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.Users;
import com.ay.isystem.models.EntityBeans.Vendors;
import com.ay.isystem.models.Response;

/**
 *
 * @author Adeel rana
 */
public class InsertUtils {

    DbmUtils dbmUtils = new DbmUtils();

    public Response insertUsers(Users user) {
        if (dbmUtils.isUserExist(user.getName(), 0, false)) {
            return new Response("User Already Exists");
        } else {
            return new Response(DBM.insertRecords(Users.class, user));
        }
    }

    public Response insertProducts(Products product) {
        if (dbmUtils.isProductExist(product)) {
            return new Response("Product Already Exists");
        } else {
            return new Response(DBM.insertRecords(Products.class, (product)));
        }
    }

    public void insertSale(Deals saleBean) {
        Products p;
        Vendors agent;
        Vendors customer;
        double qty;
        double agentsCut = 0;

        saleBean.setPartyType("c");
        customer = DBM.getSingleRecordById(Vendors.class, saleBean.getPartyId());
        customer.setCurrentBalance(customer.getCurrentBalance() + saleBean.getTransactionAmount());
        DBM.updateRecords(Vendors.class, customer);
        DBM.insertRecords(Deals.class, saleBean);

        for (DealDetails dd : saleBean.getDetails()) {
            dd.setDealId(saleBean.getId());
            agentsCut += (dd.getProductInvoiceRate() - dd.getProductSaleRate()) * dd.getProductQty();
            p = DBM.getSingleRecordById(Products.class, dd.getProductId());

            qty = p.getQuantity() - dd.getProductQty();
            p.setSaleRate(dd.getProductSaleRate());
            p.setInvoiceRate(dd.getProductInvoiceRate());
            p.setQuantity(qty);

            DBM.insertRecords(DealDetails.class, dd);
            DBM.updateRecords(Products.class, p);
        }

        if (saleBean.getAgentId() != 0) {
            agent = DBM.getSingleRecordById(Vendors.class, saleBean.getAgentId());
            agent.setCurrentBalance(agent.getCurrentBalance() + agentsCut);
            DBM.updateRecords(Vendors.class, agent);
        }
    }

    public void insertSaleReturn(Deals saleReturn) {

        Products p;
        Vendors agent;
        Vendors customer;
        double qty;
        double revertedBalance = 0;
        double agentBalance = 0;
        for (DealDetails dd : saleReturn.getReturnDetails()) {
            System.out.println("in 4 loop");
            dd.setDealId(saleReturn.getId());
            p = DBM.getSingleRecordById(Products.class, dd.getProductId());

            qty = p.getQuantity() + dd.getProductQty();
            p.setQuantity(qty);

            DBM.insertRecords(DealDetails.class, dd);
            revertedBalance += dd.getProductQty() * dd.getProductInvoiceRate();
            if (saleReturn.getAgentId() != 0) {
                agentBalance += (dd.getProductInvoiceRate() - dd.getProductSaleRate()) * dd.getProductQty();
            }
            DBM.updateRecords(Products.class, p);
        }
        customer = saleReturn.getParty();
        customer.setCurrentBalance(customer.getCurrentBalance() - revertedBalance);
        DBM.updateRecords(Vendors.class, customer);

        if (saleReturn.getAgentId() != 0) {
            agent = DBM.getSingleRecordById(Vendors.class, saleReturn.getAgentId());
            agent.setCurrentBalance(agent.getCurrentBalance() - agentBalance);
            DBM.updateRecords(Vendors.class, agent);
        }
    }

    public void insertPurchase(Deals purchaseBean) {
        Products p;
        Vendors customer;
        double qty;

        customer = DBM.getSingleRecordById(Vendors.class, purchaseBean.getPartyId());
        customer.setCurrentBalance(customer.getCurrentBalance() + purchaseBean.getTransactionAmount());
        DBM.updateRecords(Vendors.class, customer);
        purchaseBean.setPartyType("v");

        DBM.insertRecords(Deals.class, purchaseBean);

        for (DealDetails dd : purchaseBean.getDetails()) {
            dd.setDealId(purchaseBean.getId());
            p = DBM.getSingleRecordById(Products.class, dd.getProductId());

            qty = p.getQuantity() + dd.getProductQty();
            double newPrice;
            if (p.getPrice() == 0) {
                newPrice = ((p.getQuantity() + dd.getProductQty()) * dd.getProductSaleRate()) / (qty);
            } else {
                newPrice = ((p.getQuantity() * p.getPrice()) + (dd.getProductQty() * dd.getProductSaleRate())) / (qty);
            }
            p.setPrice(newPrice);
            p.setQuantity(qty);

            DBM.insertRecords(DealDetails.class, dd);
            DBM.updateRecords(Products.class, p);
        }
    }

    public void insertPurchaseReturns() {

    }

    public Response insertPayable(PayableReceiveable obj) {
        DBM.insertRecords(PayableReceiveable.class, obj);
        Vendors v = obj.getParty();
        Account ac = DBM.getSingleRecordById(Account.class, obj.getAccountId());

        v.setCurrentBalance(v.getCurrentBalance() - obj.getAmount());
        ac.setCurrentBalance(ac.getCurrentBalance() - obj.getAmount());
        DBM.updateRecords(Vendors.class, v);
        DBM.updateRecords(Account.class, ac);

        return new Response(obj);
    }

    public Response insertReceiveable(PayableReceiveable obj) {
        DBM.insertRecords(PayableReceiveable.class, obj);
        Vendors v = obj.getParty();
        Account ac = DBM.getSingleRecordById(Account.class, obj.getAccountId());

        v.setCurrentBalance(v.getCurrentBalance() - obj.getAmount());
        ac.setCurrentBalance(ac.getCurrentBalance() + obj.getAmount());
        DBM.updateRecords(Vendors.class, v);
        DBM.updateRecords(Account.class, ac);
        return new Response(obj);
    }
}
