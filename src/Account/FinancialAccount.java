/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Account;

import Employee.UITabbar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vutha.vyrapol
 */
public class FinancialAccount extends javax.swing.JPanel {

    DefaultTableModel fTable;
    int id;
    
    private void refreshTable() {
        var accounts = Finance.getFinancialAccount();
        fTable = (DefaultTableModel) accountTable.getModel();
        fTable.setRowCount(0);
        for (var account : accounts) {
            Object[] data = new Object[3];
            data[0] = account.get("id");
            data[1] = account.get("name");
            data[2] = account.get("type").equals(1) ? "Income" : "Expense";
            fTable.addRow(data);
        }
    }

    /**
     * Creates new form FinancialAccount
     */
    public FinancialAccount() {
        initComponents();
        refreshTable();
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
        txtName = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnTrans = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setText("Name");
        jPanel4.add(jLabel3);

        txtName.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        txtName.setText("Electricity");
        jPanel4.add(txtName);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel4.setText("Type");
        jPanel5.add(jLabel4);

        cbType.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Income" }));
        jPanel5.add(cbType);

        jPanel1.add(jPanel5);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnTrans.setBackground(new java.awt.Color(35, 83, 143));
        btnTrans.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        btnTrans.setForeground(new java.awt.Color(255, 255, 255));
        btnTrans.setText("Add Transaction");
        btnTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransActionPerformed(evt);
            }
        });
        jPanel3.add(btnTrans, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel3);

        jPanel15.setLayout(new java.awt.GridBagLayout());

        jPanel19.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnSave.setBackground(new java.awt.Color(0, 72, 217));
        btnSave.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel19.add(btnSave);

        btnUpdate.setBackground(new java.awt.Color(35, 175, 121));
        btnUpdate.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
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

        accountTable.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Name", "Type"
            }
        ));
        accountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(accountTable);

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
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransActionPerformed
        // TODO add your handling code here:
        UITabbar.content.removeAll();
        UITabbar.content.add(new Transaction());
        UITabbar.content.repaint();
        UITabbar.content.revalidate();
//        Employee.Account.firstPanel.removeAll();
//        Employee.Account.firstPanel.add(new Transaction());
    }//GEN-LAST:event_btnTransActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();
        int type = cbType.getSelectedIndex();
        HashMap<String, String> message = Finance.AddAccount(name, type);
        JOptionPane.showMessageDialog(this, message.get("message"));
        if ("1".equals(message.get("code"))) {
            refreshTable();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = txtName.getText();
        int type = cbType.getSelectedIndex();
        HashMap<String, String> message = Finance.UpdateAccount(id, name, type);
        JOptionPane.showMessageDialog(this, message.get("message"));
        if ("1".equals(message.get("code"))) {
            refreshTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
        int row = accountTable.getSelectedRow();
        id = Integer.parseInt(fTable.getValueAt(row, 0).toString());
        txtName.setText(fTable.getValueAt(row, 1).toString());
        String type = fTable.getValueAt(row, 2).toString();
        cbType.setSelectedIndex(type == "Expense" ? 0 : 1);
    }//GEN-LAST:event_accountTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTrans;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbType;
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
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
