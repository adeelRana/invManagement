/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.utililty;

import com.ay.isystem.db.DBM;
import com.ay.isystem.models.EntityBeans.Deals;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Adeel rana
 */
public class Utility {

    public static String getSaleInvoiceNo(Date date) {
        ArrayList<Deals> deals = DBM.getRecordsFromQuery("SELECT d FROM Deals d WHERE d.transactionTypeId = '5' ORDER BY d.id DESC ");
        long n;
        if (deals.isEmpty()) {
            n = 0;
        } else {
            n = deals.get(0).getId();
        }
        return new SimpleDateFormat("YYYY-MM-dd").format(date) + "-7253-" + (n + 1);
    }

    public static String getPurchaseInvoiceNo(Date date) {
        ArrayList<Deals> deals = DBM.getRecordsFromQuery("SELECT d FROM Deals d WHERE d.transactionTypeId = '6' ORDER BY d.id DESC ");
        long n;
        if (deals.isEmpty()) {
            n = 0;
        } else {
            n = deals.get(0).getId();
        }
        return new SimpleDateFormat("yyyy-mm-dd").format(date) + "-7724-" + (n + 1);
    }
}
