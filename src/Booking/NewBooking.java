/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Booking;

import Global.ComboItem;
import Global.Helper;
import Vehicle.VehicleClass;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vutha.vyrapol
 */
public class NewBooking extends javax.swing.JPanel {

    DefaultTableModel bookTable;
    String trip_id;
    String price;
    String vehicle;
    List<String> selectedSeat = new ArrayList<>();
//    ArrayList<HashMap<String, Object>> staffs;

    /**
     * Creates new form NewBooking
     */
    public NewBooking() {
        initComponents();
        actionPanel.setVisible(false);
        var trips = Booking.getTrips();
        for (var trip : trips) {
            cbTrip.addItem(new ComboItem(trip.get("name").toString(), trip.get("route_id").toString()));
        }
        var passengers = Passenger.Passenger.getAllPassengers();
        for (var passenger : passengers) {
            cbPassenger.addItem(new ComboItem(Helper.toUpperCase(passenger.get("last_name").toString()) + " " + Helper.toUpperCase(passenger.get("first_name").toString()), passenger.get("id").toString()));
        }
        txtTotal.setText("0");
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
        cbTrip = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dDate = new com.github.lgooddatepicker.components.DatePicker();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        seatPanel = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbPassenger = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Trip");
        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jPanel4.add(jLabel3);

        cbTrip.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jPanel4.add(cbTrip);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setText("Date");
        jLabel4.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jPanel5.add(jLabel4);

        dDate.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jPanel5.add(dDate);

        jPanel1.add(jPanel5);

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));
        jPanel3.add(jLabel5);

        btnSearch.setBackground(new java.awt.Color(35, 83, 143));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch);

        jPanel1.add(jPanel3);

        jPanel16.setLayout(new java.awt.GridLayout(1, 0));

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Vehicle", "Origin", "Destination", "Vehicle Type", "Price", "Available Seats"
            }
        ));
        bookingTable.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        bookingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bookingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookingTable);

        jPanel16.add(jScrollPane2);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWeights = new double[] {1.0};
        jPanel2Layout.rowWeights = new double[] {1.0};
        jPanel2.setLayout(jPanel2Layout);

        seatPanel.setBackground(new java.awt.Color(255, 255, 255));
        seatPanel.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        seatPanel.setLayout(new java.awt.GridLayout(2, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(seatPanel, gridBagConstraints);

        actionPanel.setEnabled(false);
        actionPanel.setLayout(new java.awt.GridLayout(3, 0, 0, 20));

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jLabel1.setText("Passenger");
        jLabel1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jPanel6.add(jLabel1);

        cbPassenger.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jPanel6.add(cbPassenger);

        actionPanel.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jLabel2.setText("Total");
        jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jPanel7.add(jLabel2);

        txtTotal.setEditable(false);
        txtTotal.setText("0");
        txtTotal.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jPanel7.add(txtTotal);

        actionPanel.add(jPanel7);

        btnSave.setText("Save");
        btnSave.setBackground(new java.awt.Color(0, 72, 217));
        btnSave.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel8.add(btnSave);

        actionPanel.add(jPanel8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(actionPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        var date = dDate.getDate().toString();
        var route = ((ComboItem) cbTrip.getSelectedItem()).getValue();
        var availTrips = Booking.findTrips(date, Integer.parseInt(route));
        bookTable = (DefaultTableModel) bookingTable.getModel();
        bookTable.setRowCount(0);
        for (var trip : availTrips) {
            Object[] data = new Object[7];
            data[0] = trip.get("id");
            data[1] = trip.get("model");
            data[2] = trip.get("origin");
            data[3] = trip.get("destination");
            data[4] = trip.get("type");
            data[5] = trip.get("price");
            data[6] = trip.get("available_seats");
            bookTable.addRow(data);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void bookingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingTableMouseClicked
        actionPanel.setVisible(true);
        int row = bookingTable.getSelectedRow();
        trip_id = bookingTable.getValueAt(row, 0).toString();
        price = bookingTable.getValueAt(row, 5).toString();
        vehicle = bookingTable.getValueAt(row, 1).toString();
        int totalSeat = VehicleClass.getSeats(vehicle);
        String seats = Booking.getBookedSeats(trip_id);
        String[] splitSeats = {};
        if (!(seats == null || seats.isEmpty())) {
            splitSeats = seats.split(",");
        }
        var list = new ArrayList<HashMap<String, Object>>();
        for (int i = 1; i <= totalSeat; i++) {
            var map = new HashMap();
            map.put("id", i);
            if (Arrays.asList(splitSeats).contains(Integer.toString(i))) {
                map.put("available", false);
            } else {
                map.put("available", true);
            }
            list.add(map);
        }
        GridBagConstraints constraint = new GridBagConstraints();
        int x = 0;
        int y = 0;
        seatPanel.setLayout(new GridBagLayout());
        seatPanel.removeAll();
        for (int i = 1; i <= totalSeat; i++) {
            var currentItem = list.get(i - 1);
            constraint.insets = new Insets(10, 10, 10, 10);
            constraint.weightx = 0.5;
            constraint.fill = GridBagConstraints.HORIZONTAL;
            constraint.gridx = x;
            constraint.gridy = y;
            var toggleButton = new JToggleButton(currentItem.get("id").toString());
            if (currentItem.get("available").equals(false)) {
                toggleButton.setEnabled(false);
                toggleButton.setBackground(new Color(0, 72, 217));
            }
            toggleButton.setPreferredSize(new Dimension(40, 40));
            toggleButton.setFont(new Font("Inter", Font.PLAIN, 16));
            toggleButton.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(0, 72, 217)), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
            toggleButton.addItemListener((e) -> {
                float total = Float.parseFloat(txtTotal.getText());
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    var currentTotal = total + Float.parseFloat(price);
                    selectedSeat.add(((JToggleButton) e.getItem()).getText());
                    txtTotal.setText(Float.toString(currentTotal));
                    toggleButton.setForeground(Color.WHITE);
                    toggleButton.setBackground(new Color(0, 72, 217));
                } else {
                    var currentTotal = total - Float.parseFloat(price);
                    selectedSeat.remove(((JToggleButton) e.getItem()).getText());
                    txtTotal.setText(Float.toString(currentTotal));
                    toggleButton.setForeground(Color.BLACK);
                    toggleButton.setBackground(Color.WHITE);
                }
                toggleButton.repaint();
            });
            seatPanel.add(toggleButton, constraint);
            x++;
            if (i % 4 == 0) {
                y++;
                x = 0;
            }
        }
        seatPanel.revalidate();
    }//GEN-LAST:event_bookingTableMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        var total = Float.parseFloat(txtTotal.getText());
        if (selectedSeat.isEmpty() && total < 0) {
            JOptionPane.showMessageDialog(this, "Please select at least one seat");
            return;
        }
        String passengerId = ((ComboItem) cbPassenger.getSelectedItem()).getValue();
        String date = dDate.getDate().toString();
        HashMap<String, String> message = Booking.AddBooking(Integer.parseInt(trip_id), Integer.parseInt(passengerId), Float.parseFloat(price), total, selectedSeat.size(), String.join(", ", selectedSeat), date);
        JOptionPane.showMessageDialog(this, message.get("message"));
        if ("1".equals(message.get("code"))) {
            this.removeAll();
            this.revalidate();
            this.repaint();
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JTable bookingTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<ComboItem> cbPassenger;
    private javax.swing.JComboBox<ComboItem> cbTrip;
    private com.github.lgooddatepicker.components.DatePicker dDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel seatPanel;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
