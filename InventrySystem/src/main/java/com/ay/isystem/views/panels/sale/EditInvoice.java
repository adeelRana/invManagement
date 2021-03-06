/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.views.panels.sale;

import com.ay.isystem.db.DBM;
import com.ay.isystem.models.EntityBeans.DealDetails;
import com.ay.isystem.models.EntityBeans.Deals;
import com.ay.isystem.models.EntityBeans.Products;
import com.ay.isystem.models.EntityBeans.Vendors;
import com.ay.isystem.utililty.Global;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Adeel rana
 */
public class EditInvoice extends javax.swing.JPanel {

    private final Deals DEAL;
    private DefaultTableModel dtmSales;
    private DefaultTableModel dtmReturn;
    private DealDetails selectedSale;
    private DealDetails selectedReturn;

    /**
     * Creates new form EditInvoice
     *
     * @param deal
     */
    public EditInvoice(Deals deal) {
        initComponents();
        this.DEAL = deal;
        dtmSales = (DefaultTableModel) salesTable.getModel();
        dtmReturn = (DefaultTableModel) returnTable.getModel();
        returnPanel.setVisible(!DEAL.getReturnDetails().isEmpty());
        initComponentsData();
        loadDataToTables(deal);
    }

    private EditInvoice() {
        this.DEAL = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboAgent = new javax.swing.JComboBox();
        txtAgent = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboCustomerNamesAuto = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        productCombo = new javax.swing.JComboBox();
        txtInvoiceTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalSale = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAgentsCut = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSaleQty = new javax.swing.JTextField();
        txtSaleSRate = new javax.swing.JTextField();
        txtSaleIRate = new javax.swing.JTextField();
        btnSaleSave = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnSaleDel = new javax.swing.JButton();
        btnSaleAdd = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        returnPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        productCombo1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtReturnQty = new javax.swing.JTextField();
        btnReturnDel = new javax.swing.JButton();
        btnReturnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        returnTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Sale");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboAgent.setEnabled(false);

        txtAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAgent.setText("Agent");

        txtInvoice.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Select Date");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Customers Names");

        comboCustomerNamesAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCustomerNamesAutoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Invoice");

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        productCombo.setToolTipText("");
        productCombo.setEnabled(false);

        jLabel6.setText("Invoice Total");

        jLabel7.setText("Total Sale");

        jLabel8.setText("Agents Cut");

        jLabel9.setText("Product");

        jLabel10.setText("Quantity");

        jLabel11.setText("Sale Rate");

        jLabel12.setText("Invoice Rate");

        txtSaleQty.setEnabled(false);

        txtSaleSRate.setEnabled(false);

        txtSaleIRate.setEnabled(false);

        btnSaleSave.setText("Save");
        btnSaleSave.setEnabled(false);
        btnSaleSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleSaveActionPerformed(evt);
            }
        });

        jButton3.setText("Back");

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Qty", "Sale Rate", "Invoice Rate", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesTableMouseClicked(evt);
            }
        });
        salesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salesTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(salesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Sales");

        btnSaleDel.setText("Delete");
        btnSaleDel.setEnabled(false);

        btnSaleAdd.setText("Add");

        jButton8.setText("Save");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Return");

        jLabel14.setText("Product");

        productCombo1.setToolTipText("");
        productCombo1.setEnabled(false);

        jLabel15.setText("Quantity");

        txtReturnQty.setEnabled(false);

        btnReturnDel.setText("Delete");
        btnReturnDel.setEnabled(false);

        btnReturnSave.setText("Save");
        btnReturnSave.setEnabled(false);

        returnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        returnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnTableMouseClicked(evt);
            }
        });
        returnTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                returnTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(returnTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout returnPanelLayout = new javax.swing.GroupLayout(returnPanel);
        returnPanel.setLayout(returnPanelLayout);
        returnPanelLayout.setHorizontalGroup(
            returnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(returnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReturnQty, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReturnSave)
                .addContainerGap())
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        returnPanelLayout.setVerticalGroup(
            returnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(returnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(txtReturnQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturnSave)
                    .addComponent(btnReturnDel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(returnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(btnSaleAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaleDel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInvoiceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSale, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAgentsCut, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(txtInvoice))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboCustomerNamesAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtAgent)
                                                .addGap(40, 40, 40)
                                                .addComponent(comboAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton8))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaleQty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaleSRate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaleIRate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSaleSave)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCustomerNamesAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAgent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnSaleDel)
                    .addComponent(btnSaleAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtSaleQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSaleSRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtSaleIRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaleSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(returnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgentsCut, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSale, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInvoiceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboCustomerNamesAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCustomerNamesAutoActionPerformed
        if (comboCustomerNamesAuto.getSelectedItem() != null) {
//            etSaleCurrentBalance.setText(((Vendors) comboCustomerNamesAuto.getSelectedItem()).getCurrentBalance() + "");
        }
    }//GEN-LAST:event_comboCustomerNamesAutoActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        if (jXDatePicker1.getDate() != null) {
//            txtInvoice.setText("" + Utility.getSaleInvoiceNo(jXDatePicker1.getDate()));
        }
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        initComponentsData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salesTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salesTableKeyPressed
        if (evt.getKeyCode() > 36 && evt.getKeyCode() < 41) {
            if (salesTable.getSelectedRowCount() < 2 && salesTable.getSelectedRow() != -1) {
                int row = salesTable.getSelectedRow();
                DealDetails dd = (DealDetails) salesTable.getValueAt(row, 0);
                setSaleActive(true, dd);

            } else {
                setSaleActive(false, null);
            }
        }
    }//GEN-LAST:event_salesTableKeyPressed

    private void salesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesTableMouseClicked
        if (salesTable.getSelectedRowCount() < 2 && salesTable.getSelectedRow() != -1) {
            int row = salesTable.getSelectedRow();
            DealDetails dd = (DealDetails) salesTable.getValueAt(row, 0);
            setSaleActive(true, dd);
        } else {
            setSaleActive(false, null);
        }
    }//GEN-LAST:event_salesTableMouseClicked

    private void returnTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnTableKeyPressed
        if (evt.getKeyCode() > 36 && evt.getKeyCode() < 41) {
            if (returnTable.getSelectedRowCount() < 2 && returnTable.getSelectedRow() != -1) {
                int row = returnTable.getSelectedRow();
                DealDetails dd = (DealDetails) returnTable.getValueAt(row, 0);
                setReturnActive(true, dd);
            } else {
                setReturnActive(false, null);
            }
        }
    }//GEN-LAST:event_returnTableKeyPressed

    private void returnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnTableMouseClicked
        if (returnTable.getSelectedRowCount() < 2 && returnTable.getSelectedRow() != -1) {
            int row = returnTable.getSelectedRow();
            DealDetails dd = (DealDetails) returnTable.getValueAt(row, 0);
            setReturnActive(true, dd);
        } else {
            setReturnActive(false, null);
        }
    }//GEN-LAST:event_returnTableMouseClicked

    private void btnSaleSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleSaveActionPerformed
        try {
            double oldQty = selectedSale.getProductQty();

            selectedSale.setProductId(((Products) productCombo.getSelectedItem()).getId());
            selectedSale.setProductQty(Double.parseDouble(txtSaleQty.getText()));
            selectedSale.setProductInvoiceRate(Double.parseDouble(txtSaleIRate.getText()));
            selectedSale.setProductSaleRate(Double.parseDouble(txtSaleSRate.getText()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSaleSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturnDel;
    private javax.swing.JButton btnReturnSave;
    private javax.swing.JButton btnSaleAdd;
    private javax.swing.JButton btnSaleDel;
    private javax.swing.JButton btnSaleSave;
    private javax.swing.JComboBox comboAgent;
    private javax.swing.JComboBox comboCustomerNamesAuto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JComboBox productCombo;
    private javax.swing.JComboBox productCombo1;
    private javax.swing.JPanel returnPanel;
    private javax.swing.JTable returnTable;
    private javax.swing.JTable salesTable;
    private javax.swing.JLabel txtAgent;
    private javax.swing.JTextField txtAgentsCut;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtInvoiceTotal;
    private javax.swing.JTextField txtReturnQty;
    private javax.swing.JTextField txtSaleIRate;
    private javax.swing.JTextField txtSaleQty;
    private javax.swing.JTextField txtSaleSRate;
    private javax.swing.JTextField txtTotalSale;
    // End of variables declaration//GEN-END:variables

    private void initComponentsData() {
        AutoCompleteDecorator.decorate(comboCustomerNamesAuto);
        AutoCompleteDecorator.decorate(productCombo);
        AutoCompleteDecorator.decorate(comboAgent);
        AutoCompleteDecorator.decorate(productCombo1);

        ArrayList productsList = (ArrayList<Products>) Global.CONTROLLER.fetch("product").getResponseObject();

        Global.addListToCombo(comboCustomerNamesAuto, (ArrayList<Vendors>) Global.CONTROLLER.fetch("customer").getResponseObject());
        Global.addListToCombo(productCombo, productsList);
        Global.addListToCombo(productCombo1, productsList);
        Global.addListToCombo(comboAgent, (ArrayList<Vendors>) Global.CONTROLLER.fetch("agent").getResponseObject());
    }

    private void loadDataToTables(Deals deal) {
        txtInvoice.setText(deal.getInvoiceNo());
        jXDatePicker1.setDate(new Date(deal.getInvoiceDate()));
        comboCustomerNamesAuto.setSelectedItem(deal.getParty());
        comboAgent.setSelectedItem(DBM.getSingleRecordById(Vendors.class, deal.getAgentId()));

        dtmSales.setRowCount(0);
        for (DealDetails dd : deal.getDetails()) {
            dtmSales.addRow(new Object[]{
                dd, dd.getProductQty(), dd.getProductSaleRate(), dd.getProductInvoiceRate(), (dd.getProductInvoiceRate() * dd.getProductQty())
            });
        }
        dtmReturn.setRowCount(0);
        for (DealDetails dd : deal.getReturnDetails()) {
            dtmReturn.addRow(new Object[]{
                dd, dd.getProductQty()
            });
        }
    }

    private void setSaleActive(boolean flag, DealDetails dd) {
        if (flag) {
            selectedSale = dd;
            txtSaleQty.setText(dd.getProductQty() + "");
            txtSaleSRate.setText(dd.getProductSaleRate() + "");
            txtSaleIRate.setText(dd.getProductInvoiceRate() + "");
            productCombo.setSelectedItem(DBM.getSingleRecordById(Products.class, dd.getProductId()));
        }
        btnSaleDel.setEnabled(flag);
        btnSaleDel.setEnabled(flag);
        btnSaleSave.setEnabled(flag);
        txtSaleQty.setEnabled(flag);
        txtSaleSRate.setEnabled(flag);
        txtSaleIRate.setEnabled(flag);
        productCombo.setEnabled(flag);
    }

    private void setReturnActive(boolean flag, DealDetails dd) {
        if (flag) {
            selectedReturn = dd;
            txtReturnQty.setText(dd.getProductQty() + "");
            productCombo1.setSelectedItem(DBM.getSingleRecordById(Products.class, dd.getProductId()));
        }
        btnReturnDel.setEnabled(flag);
        btnReturnSave.setEnabled(flag);
        txtReturnQty.setEnabled(flag);
        productCombo1.setEnabled(flag);
    }

}
