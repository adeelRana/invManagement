/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.views.panels.purchase;

import com.ay.isystem.db.DBM;
import com.ay.isystem.enums.TransactionType;
import com.ay.isystem.models.EntityBeans.Deals;
import com.ay.isystem.models.Response;
import com.ay.isystem.utililty.Global;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author java
 */
public class ShowPurchase extends javax.swing.JPanel {

    DefaultTableModel dtm;

    /**
     * Creates new form ShowSalesPanle
     */
    public ShowPurchase() {
        initComponents();
        dtm = (DefaultTableModel) this.tblShowSales.getModel();
        loadDataToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowSales = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 375));

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exitBtn.setText("Details");
        exitBtn.setEnabled(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchases");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.setEnabled(false);

        tblShowSales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 180, 169)));
        tblShowSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Invoice No", "Date", "Vendors Name", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShowSales.setRowHeight(25);
        tblShowSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowSalesMouseClicked(evt);
            }
        });
        tblShowSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblShowSalesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblShowSales);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
    }//GEN-LAST:event_exitBtnActionPerformed

    private void tblShowSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowSalesMouseClicked
//        tblShowSales = (JTable) evt.getSource();
//        int row = tblShowSales.getSelectedRow();
//        int col = tblShowSales.getSelectedColumn();
//        if (col == 5) {
//            int saleId = Integer.parseInt(tblShowSales.getValueAt(row, 0).toString());
//            String invoiceNum = "";
//            invoiceNum = tblShowSales.getValueAt(row, 1).toString();
//            SaleDetailDialog salesDetails = new SaleDetailDialog(MainFrame.obj, true, saleId, invoiceNum);
//            salesDetails.setVisible(true);
//        }
    }//GEN-LAST:event_tblShowSalesMouseClicked

    private void tblShowSalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblShowSalesKeyPressed
        if (evt.getKeyCode() == 127) {
            delete();
        }
    }//GEN-LAST:event_tblShowSalesKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Global.addPanel(AddPurchase.class, (JPanel) this.getParent());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tblShowSales.getSelectedRowCount() > 0 && tblShowSales.getSelectedRowCount() < 2) {
            int row = tblShowSales.getSelectedRow();
            Deals deal = (Deals) tblShowSales.getValueAt(row, 0);
            Response deleteRecord = Global.CONTROLLER.deleteDeal(deal.getId(), deal.getPartyId(), 0, TransactionType.PURCHASE);
            if (!deleteRecord.isError()) {
                dtm.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, deleteRecord.getErrorMsg());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select One record");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblShowSales;
    // End of variables declaration//GEN-END:variables

    public void delete() {
//        int numOfRows = this.tblShowSales.getSelectedRowCount();
//        String type;
//        if (numOfRows != 0) {
//            if (JOptionPane.showConfirmDialog(MainFrame.obj, "Are you sure You Want to Delete Record / Records ?") == JOptionPane.YES_OPTION) {
//                int[] selectedRows = this.tblShowSales.getSelectedRows();
//                int id = -1;
//                for (int i = 0; i < numOfRows; i++) {
//                    int customerId = Integer.parseInt(tblShowSales.getValueAt(selectedRows[i], 6).toString());
//                    type = (String) tblShowSales.getValueAt(selectedRows[i], 7);
//                    if ("cash".equalsIgnoreCase(type)) {
//                        DBManager.updateOurBalance(DBManager.getCashId(true).intValue(), Double.parseDouble(tblShowSales.getValueAt(selectedRows[i], 4).toString()), 2);
//                    } else {
//                        DBManager.updateCustomerBalance(customerId, Double.parseDouble(tblShowSales.getValueAt(selectedRows[i], 4).toString()), false);
//                    }
//
//                    id = Integer.parseInt(tblShowSales.getValueAt(selectedRows[i], 0).toString());
//                    Sale.deleteSale(tblShowSales, id);
//                    
//                }
//                Sale.showSales(tblShowSales);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Please select a row to delete");
//        }
    }

    private void loadDataToTable() {
        dtm.setRowCount(0);
        ArrayList<Deals> li = DBM.getRecordsBy(Deals.class, "TransactionTypeId", 6);
        for (Deals d : li) {
            dtm.addRow(new Object[]{
                d,
                Global.DATE_FORMAT.format(new Date(d.getInvoiceDate())),
                d.getParty(),
                d.getTransactionAmount()
            });
        }
    }
}
