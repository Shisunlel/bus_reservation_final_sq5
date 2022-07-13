/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Trip;

import java.sql.*;
import Login.DBCon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author yarith
 */
public class Location extends javax.swing.JPanel {
	Connection conn;

	/**
	 * Creates new form Trip
	 */
	public Location() {
		initComponents();
		try {
			conn = DBCon.getConnection();
		}
		catch (SQLException e){
		}
		rdbtnActive.setActionCommand("Active");
		rdbtnInactive.setActionCommand("Inactive");
		((DefaultTableCellRenderer)jTblLocation.getTableHeader().getDefaultRenderer())
    .setHorizontalAlignment(JLabel.LEFT);
		tableRefresh();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupStatus = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblLocation = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rdbtnActive = new javax.swing.JRadioButton();
        rdbtnInactive = new javax.swing.JRadioButton();

        jTblLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Description", "Status", "Created_at", "Updated_at"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblLocation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTblLocation);
        if (jTblLocation.getColumnModel().getColumnCount() > 0) {
            jTblLocation.getColumnModel().getColumn(0).setMaxWidth(80);
            jTblLocation.getColumnModel().getColumn(3).setMaxWidth(170);
            jTblLocation.getColumnModel().getColumn(4).setMinWidth(100);
            jTblLocation.getColumnModel().getColumn(4).setMaxWidth(250);
            jTblLocation.getColumnModel().getColumn(5).setMinWidth(100);
            jTblLocation.getColumnModel().getColumn(5).setMaxWidth(250);
        }

        btnUpdate.setBackground(new java.awt.Color(35, 175, 121));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 72, 217));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtName)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Description");

        txtDesc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 200, Short.MAX_VALUE))
            .addComponent(txtDesc)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Status");

        radioGroupStatus.add(rdbtnActive);
        rdbtnActive.setText("Active");

        radioGroupStatus.add(rdbtnInactive);
        rdbtnInactive.setText("Inactive");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdbtnActive)
                        .addGap(18, 18, 18)
                        .addComponent(rdbtnInactive)))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnActive)
                    .addComponent(rdbtnInactive))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = jTblLocation.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Please select a row.");
			return;
		}
		Integer id = Integer.parseInt(jTblLocation.getValueAt(row, 0).toString());
		String name = jTblLocation.getValueAt(row, 1).toString();
		String desc = jTblLocation.getValueAt(row, 2).toString();
		String status_txt = jTblLocation.getValueAt(row, 3).toString();
		Integer status = 0;
		if (status_txt.equals("Active")) {
			status = 1;
		}
		new UpdateLocation(this, id, name, desc, status).setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
		if (radioGroupStatus.getSelection() == null) {
			JOptionPane.showMessageDialog(this, "Please Select Status.");
			return;
		}
		if (txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Name can't be empty.");
			return;
		}
		String name = txtName.getText();
		String desc = txtDesc.getText();
		String status_txt = radioGroupStatus.getSelection().getActionCommand();
		Integer status = status_txt.equals("Active") ? 1 : 0;
		rowInsert(name, desc, status);

		txtName.setText("");
		txtDesc.setText("");
		radioGroupStatus.clearSelection();
		tableRefresh();
    }//GEN-LAST:event_btnSaveActionPerformed

	public void tableRefresh(){
		DefaultTableModel tblModel = (DefaultTableModel) jTblLocation.getModel();
		tblModel.setRowCount(0);
		try{
			Statement st = conn.createStatement();
			String query = "SELECT * FROM location";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String desc = rs.getString("description");
				if (desc == null || desc.equals("")) {
					desc = "(no information)";
				}
				Integer status = rs.getInt("status");
				String status_str = status == 1 ? "Active" : "Inactive";
				String created_at  = rs.getDate("created_at").toString();
				String updated_at = rs.getDate("updated_at").toString();
				Object[] row = {id,name, desc, status_str, created_at, updated_at};
				tblModel.addRow(row);
			}
			st.close();
		}
		catch (SQLException e) {
		}
	}
	private void rowInsert(String name, String desc, Integer status) {
		try{
			String query = "INSERT INTO location (name, description, status)"
					+ "VALUES (?, ?, ?)";
			PreparedStatement prepSt = conn.prepareStatement(query);
			prepSt.setString(1,name);
			prepSt.setString(2,desc);
			prepSt.setInt(3, status);
			prepSt.executeUpdate();
		}
		catch (SQLException e) {
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblLocation;
    private javax.swing.ButtonGroup radioGroupStatus;
    private javax.swing.JRadioButton rdbtnActive;
    private javax.swing.JRadioButton rdbtnInactive;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}