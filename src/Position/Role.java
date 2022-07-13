/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Position;

import Employee.Account;
import Employee.UITabbar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vutha.vyrapol
 */
public class Role extends javax.swing.JPanel {

    DefaultTableModel roleTable;
    String id;

    private void refreshTable() {
        var positions = Position.getAllPositions();
        roleTable = (DefaultTableModel) positionTable.getModel();
        roleTable.setRowCount(0);
        for (var position : positions) {
            Object[] data = new Object[3];
            data[0] = position.get("id");
            data[1] = position.get("name");
            data[2] = position.get("details");
            roleTable.addRow(data);
        }
    }

    /**
     * Creates new form Position
     */
    public Role() {
        initComponents();
        refreshTable();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDetails = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAddPermission = new javax.swing.JButton();
        btnAssignPermission = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        positionTable = new javax.swing.JTable();

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Position Name");
        jPanel4.add(jLabel3);

        txtPosition.setText("Staff");
        jPanel4.add(txtPosition);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setText("Details");
        jPanel5.add(jLabel4);

        txtDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetailsActionPerformed(evt);
            }
        });
        jPanel5.add(txtDetails);

        jPanel1.add(jPanel5);

        jPanel3.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        btnAddPermission.setBackground(new java.awt.Color(35, 83, 143));
        btnAddPermission.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPermission.setText("Add Permission");
        btnAddPermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPermissionActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddPermission);

        btnAssignPermission.setBackground(new java.awt.Color(35, 83, 143));
        btnAssignPermission.setForeground(new java.awt.Color(255, 255, 255));
        btnAssignPermission.setText("Assign Permission");
        btnAssignPermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignPermissionActionPerformed(evt);
            }
        });
        jPanel3.add(btnAssignPermission);

        jPanel1.add(jPanel3);

        jPanel15.setLayout(new java.awt.GridBagLayout());

        jPanel19.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnSave.setText("Save");
        btnSave.setBackground(new java.awt.Color(0, 72, 217));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel19.add(btnSave);

        btnUpdate.setBackground(new java.awt.Color(35, 175, 121));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel19.add(btnUpdate);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel15.add(jPanel19, gridBagConstraints);

        jPanel16.setLayout(new java.awt.GridLayout(1, 0));

        positionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Position Name", "Details"
            }
        ));
        positionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        positionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(positionTable);

        jPanel16.add(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetailsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtPosition.getText();
        String details = txtDetails.getText();
        HashMap<String, String> message = Position.AddPosition(name, details);
        JOptionPane.showMessageDialog(this, message.get("message"));
        if ("1".equals(message.get("code"))) {
            refreshTable();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = txtPosition.getText();
        String details = txtDetails.getText();
        HashMap<String, String> message = Position.UpdatePosition(id, name, details);
        JOptionPane.showMessageDialog(this, message.get("message"));
        if ("1".equals(message.get("code"))) {
            refreshTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void positionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionTableMouseClicked
        int row = positionTable.getSelectedRow();
        id = positionTable.getValueAt(row, 0).toString();
        txtPosition.setText(positionTable.getValueAt(row, 1).toString());
        txtDetails.setText(positionTable.getValueAt(row, 2).toString());
    }//GEN-LAST:event_positionTableMouseClicked

    private void btnAddPermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPermissionActionPerformed
        // TODO add your handling code here:
        UITabbar.content.removeAll();
        UITabbar.content.add(new AddPermission());
        UITabbar.content.repaint();
        UITabbar.content.revalidate();
//        Account.firstPanel.removeAll();
//        Account.firstPanel.add(new AddPermission());
    }//GEN-LAST:event_btnAddPermissionActionPerformed

    private void btnAssignPermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignPermissionActionPerformed
        // TODO add your handling code here:
        UITabbar.content.removeAll();
        UITabbar.content.add(new AssignPermission());
        UITabbar.content.repaint();
        UITabbar.content.revalidate();
//        Account.firstPanel.removeAll();
//        Account.firstPanel.add(new AssignPermission());
//        Account.firstPanel.revalidate();
//        Account.firstPanel.repaint();
    }//GEN-LAST:event_btnAssignPermissionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPermission;
    private javax.swing.JButton btnAssignPermission;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable positionTable;
    private javax.swing.JTextField txtDetails;
    private javax.swing.JTextField txtPosition;
    // End of variables declaration//GEN-END:variables
}
