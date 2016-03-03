/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.models.reports;

import com.ay.isystem.db.DBM;
import com.ay.isystem.enums.TransactionType;
import com.ay.isystem.models.EntityBeans.DealDetails;
import com.ay.isystem.models.EntityBeans.Deals;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.Vendors;
import com.ay.isystem.utililty.Global;
import com.ay.isystem.views.dialogs.ReportDialog;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Adeel rana
 */
public class Reports {

    private static ArrayList<InvoiceReportView> getInvoiceReportData(Deals dealBean) {
        ArrayList<InvoiceReportView> reportDataList = new ArrayList<>();
        InvoiceReportView irv;
        ArrayList<DealDetails> data = dealBean.getDetails();
        data.addAll(dealBean.getReturnDetails());
        for (DealDetails db : data) {
            Products p = DBM.getSingleRecordById(Products.class, db.getProductId());
            irv = new InvoiceReportView(dealBean.getInvoiceNo(), dealBean.getInvoiceDate() + "", dealBean.getParty() + "", dealBean.getParty().getContactPhone(), dealBean.getTransactionAmount() + "");
            irv.setCode(p.getCode());
            irv.setDescription(p.getName());
            irv.setQty(db.getProductQty());
            irv.setRate(db.getProductInvoiceRate());
            irv.setSaleRate(db.getProductSaleRate());
            irv.setType(db.getTransactionTypeId() == TransactionType.SALE ? "Sale" : "Sale Return");
            reportDataList.add(irv);
        }
        return reportDataList;
    }

    public static void createSaleInvoice(Deals saleBean, boolean isFull) {
        try {

            ArrayList<InvoiceReportView> invoiceReportData = getInvoiceReportData(saleBean);
            JasperDesign jasperDesign;
            if (isFull) {
                jasperDesign = JRXmlLoader.load(Reports.class.getResourceAsStream("/resources/sale_invoice_full.jrxml"));
            } else {
                jasperDesign = JRXmlLoader.load(Reports.class.getResourceAsStream("/resources/sale_invoice.jrxml"));
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//            JasperDesign SubReportDesign = JRXmlLoader.load(Reports.class.getResourceAsStream("/Reports/Attendance/Student-Attendance-Sub-Report.jrxml"));
//            JasperReport SubReportReport = JasperCompileManager.compileReport(SubReportDesign);

            HashMap hm1 = new HashMap();
            hm1.put("date", Global.DATE_FORMAT.format(new Date(saleBean.getInvoiceDate())));
            hm1.put("invoiceNo", saleBean.getInvoiceNo());
            hm1.put("customerName", saleBean.getParty().getName());
            hm1.put("customerPhone", saleBean.getParty().getContactPhone());
            Vendors agent = DBM.getSingleRecordById(Vendors.class, saleBean.getAgentId());
            hm1.put("agent", null == agent ? "--" : agent.getName());

            Object[] possibilities = {"APPLICATION VIEWER", "PDF", "IMAGE"};

            String s = (String) JOptionPane.showInputDialog(null, "Report Print Type", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, possibilities, "APPLICATION VIEWER");
            if ((s != null) && (s.length() > 0)) {
                if (s.equalsIgnoreCase("PDF")) {
                    ReportDialog.getReport(invoiceReportData, hm1, jasperReport, 2);
                } else if (s.equalsIgnoreCase("IMAGE")) {
                    ReportDialog.getReport(invoiceReportData, hm1, jasperReport, 3);
                } else if (s.equalsIgnoreCase("HTML")) {
                    ReportDialog.getReport(invoiceReportData, hm1, jasperReport, 4);
                } else if (s.equalsIgnoreCase("APPLICATION VIEWER")) {
                    JRViewer viewer = (JRViewer) ReportDialog.getReport(invoiceReportData, hm1, jasperReport, 1);

                    new ReportDialog(viewer).setVisible(true);
                }
            }
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
