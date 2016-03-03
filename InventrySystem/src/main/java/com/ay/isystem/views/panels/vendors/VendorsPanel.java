/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.views.panels.vendors;

import com.ay.isystem.db.DBM;
import com.ay.isystem.models.EntityBeans.Vendors;
import com.ay.isystem.models.Response;
import com.ay.isystem.utililty.Global;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adeel rana
 */
public class VendorsPanel extends javax.swing.JPanel {

    DefaultTableModel dtm;
    String title;

    /**
     * Creates new form VendorsPanel
     *
     * @param title
     */
    public VendorsPanel(String title) {
        initComponents();
        dtm = (DefaultTableModel) this.tblVendor.getModel();
        this.title = title;
        loadDataToTable(title);
        jLabel1.setText(title + "s");
    }

    public VendorsPanel() {
        initComponents();
        dtm = (DefaultTableModel) this.tblVendor.getModel();
        loadDataToTable("Vendor");
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
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendor = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vendors");

        btnDelete.setText("DELETE");
        btnDelete.setPreferredSize(new java.awt.Dimension(57, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.setPreferredSize(new java.awt.Dimension(57, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("EDIT");
        btnUpdate.setEnabled(false);
        btnUpdate.setPreferredSize(new java.awt.Dimension(57, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblVendor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Opening balance", "Current balance", "Address", "Zip Code", "Telephone", "Email", "Mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVendorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblVendor.getSelectedRowCount() > 0 && tblVendor.getSelectedRowCount() < 2) {
            int row = tblVendor.getSelectedRow();
            Vendors vendor = (Vendors) tblVendor.getValueAt(row, 0);
            Response deleteRecord = Global.CONTROLLER.deleteRecord(vendor.getId(), Vendors.class);
            if (!deleteRecord.isError()) {
                dtm.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, deleteRecord.getErrorMsg());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select One record");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddVendorDialog addVendor = new AddVendorDialog(null, true, title);
        addVendor.setVisible(true);
        loadDataToTable(title);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblVendor.getSelectedRow();
        if (row != -1) {
//            AddVendorDialog updateVendor = new AddVendorDialog(MainFrame.obj,true,vendorsList.get(row),tblVendor);
//            updateVendor.setVisible(true);
        } else {
//            JOptionPane.showMessageDialog(null, "Please select a row to edit");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblVendorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVendorKeyPressed
        if (evt.getKeyCode() == 127) {
//            delete();
        }
    }//GEN-LAST:event_tblVendorKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendor;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable(String type) {
        dtm.setRowCount(0);
        ArrayList<Vendors> li = DBM.getRecordsBy(Vendors.class, "Type", type);
        for (Vendors v : li) {
            dtm.addRow(new Object[]{
                v, v.getOpeningBalance(), v.getCurrentBalance(), v.getAddress(), v.getZipCode(), v.getTelephone(), v.getContactEmail(), v.getContactPhone()
            });
        }
    }
}