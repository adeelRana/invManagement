/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.utililty;

import com.ay.isystem.db.DBM;
import com.ay.isystem.db.DbmUtils;
import com.ay.isystem.models.EntityBeans.Location;
import com.ay.isystem.models.EntityBeans.MasterList;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.Vehicle;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Adeel rana
 */
public class ExcelParser {

    DbmUtils dbmUtils = new DbmUtils();

    public static void main(String[] args) {
        readFromExcelFile(null);
    }

    public static void readFromExcelFile(File f) {
        try {
            int i;
            int j = 0;
            Workbook wb;
            String path = null;
            for (int l = 0; l < 5; l++) {
//            for (int l = 2; l < 4; l++) {
//            for (int l = 0; l < 2; l++) {
                i = 0;
                switch (l) {
                    case 0:
                        j = 6;
                        path = "C:\\Users\\Adeel rana\\Desktop\\MasterList.xlsx";
                        break;
                    case 1:
                        j = 2;
                        path = "C:\\Users\\Adeel rana\\Desktop\\MasterList2.xlsx";
                        break;
                    case 2:
                        j = 1;
                        path = "C:\\Users\\Adeel rana\\Desktop\\MasterList3.xlsx";
                        break;
                    case 3:
                        j = 1;
                        path = "C:\\Users\\Adeel rana\\Desktop\\MasterList4.xlsx";
                        break;
                    case 4:
                        j = 1;
                        path = "C:\\Users\\Adeel rana\\Desktop\\MasterList5.xlsx";
                        break;
                }
                wb = WorkbookFactory.create(new File(path));
                while (i < j) {
                    Sheet sheet = wb.getSheetAt(i++);
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {

                        Row row = rowIterator.next();
                        //For each row, iterate through all the columns
                        Iterator<Cell> cellIterator = row.cellIterator();
                        int column = 0;
                        MasterList masterList = new MasterList();
                        while (cellIterator.hasNext()) {

                            Cell cell = cellIterator.next();
                            //Check the cell type and format accordingly
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    if (column == 0) {
                                        masterList.setProductCode(cell.getStringCellValue());
                                    } else {
                                        masterList.setProductDescription(cell.getStringCellValue());
                                    }
//                                    System.out.print(column + "\t" + cell.getStringCellValue());
                                    column++;
                                    break;
                                default:
                                    if (column == 0) {
                                        masterList.setProductCode(cell.getStringCellValue());
                                    } else {
                                        masterList.setProductDescription(cell.getStringCellValue());
                                    }
//                                    System.out.print(column + "\t->" + cell.getStringCellValue());
                                    column++;
                            }
                        }
                        DBM dbm = new DBM();
                        dbm.insertRecords(MasterList.class, masterList);
//                        System.out.println("");
                    }
                }
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

}
