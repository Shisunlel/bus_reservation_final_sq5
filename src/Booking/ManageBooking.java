/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vutha.vyrapol
 */
public class ManageBooking extends javax.swing.JPanel {

    DefaultTableModel bookTable;
    HashMap<String, Object> booking;

    /**
     * Creates new form ManageBooking
     */
    public ManageBooking() {
        initComponents();
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
        txtBId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Booking ID");
        jPanel4.add(jLabel3);
        jPanel4.add(txtBId);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnSearch.setBackground(new java.awt.Color(35, 83, 143));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel5.add(btnSearch, gridBagConstraints);

        btnPrint.setBackground(new java.awt.Color(255, 255, 255));
        btnPrint.setForeground(new java.awt.Color(51, 51, 51));
        btnPrint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 217), 1, true));
        btnPrint.setLabel("Print Ticket");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel5.add(btnPrint, gridBagConstraints);

        jPanel1.add(jPanel5);

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));
        jPanel1.add(jPanel3);

        jPanel16.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridLayout());

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Vehicle", "Origin", "Destination", "Vehicle Type", "Price", "Seat No"
            }
        ));
        bookingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bookingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookingTable);

        jPanel2.add(jScrollPane2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel16.add(jPanel2, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jPanel6.add(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel16.add(jPanel6, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bookingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingTableMouseClicked
        int row = bookingTable.getSelectedRow();
        jTextArea1.setText("********************\n");
        jTextArea1.setText(jTextArea1.getText() + "*     CIty Bus            *\n");
        jTextArea1.setText(jTextArea1.getText() + "********************\n");
        String date = booking.get("start_date").toString();
        jTextArea1.setText(jTextArea1.getText() + "\n" + date + "\n\n");
        jTextArea1.setText(jTextArea1.getText() + "Ticket No : " + bookingTable.getValueAt(row, 0) + "\n");
        jTextArea1.setText(jTextArea1.getText() + "Vehicle : " + bookingTable.getValueAt(row, 1) + "\n");
        jTextArea1.setText(jTextArea1.getText() + "Ticket Type : " + bookingTable.getValueAt(row, 4) + "\n");
        jTextArea1.setText(jTextArea1.getText() + "Origin : " + bookingTable.getValueAt(row, 2) + "\n");
        jTextArea1.setText(jTextArea1.getText() + "Destination : " + bookingTable.getValueAt(row, 3) + "\n");
        jTextArea1.setText(jTextArea1.getText() + "Price : " + bookingTable.getValueAt(row, 5) + "\n");
        jTextArea1.setText(jTextArea1.getText() + "Seat No : " + bookingTable.getValueAt(row, 6) + "\n");


    }//GEN-LAST:event_bookingTableMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int booking_id = Integer.parseInt(txtBId.getText());
        booking = Booking.findBooking(booking_id);
        bookTable = (DefaultTableModel) bookingTable.getModel();
        bookTable.setRowCount(0);
        String[] splitSeats = booking.get("seat_no").toString().split(",");
        var list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < splitSeats.length; i++) {
            var map = new HashMap();
            map.put("id", booking.get("id").toString());
            map.put("vehicle", booking.get("model").toString());
            map.put("origin", booking.get("origin").toString());
            map.put("destination", booking.get("destination").toString());
            map.put("vehicle_type", booking.get("type").toString());
            map.put("price", booking.get("price").toString());
            map.put("seat_no", splitSeats[i].toString());
            list.add(map);
        }
        for (var book : list) {
            Object[] data = new Object[7];
            data[0] = book.get("id");
            data[1] = book.get("vehicle");
            data[2] = book.get("origin");
            data[3] = book.get("destination");
            data[4] = book.get("vehicle_type");
            data[5] = book.get("price");
            data[6] = book.get("seat_no");
            bookTable.addRow(data);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try {
            jTextArea1.print();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookingTable;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtBId;
    // End of variables declaration//GEN-END:variables
}
