/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehicle;

import Login.DBCon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutha.vyrapol
 */
public class VehicleClass {

    public static ArrayList<HashMap<String, Object>> getVehicleTypes() {
        var vehicleTypes = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "SELECT * FROM vehicle_type WHERE status = 1;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            var resultSet = preparedStatement.executeQuery();
            var meta = resultSet.getMetaData();
            var cols = new ArrayList<String>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                cols.add(meta.getColumnLabel(i));
            }
            while (resultSet.next()) {
                var row = new HashMap<String, Object>();
                for (String colName : cols) {
                    var val = resultSet.getObject(colName);
                    row.put(colName, val);
                }
                vehicleTypes.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vehicleTypes;
    }

    public static ArrayList<HashMap<String, Object>> getAllVehicles() {
        var vehicles = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "SELECT vehicle.id, plate_no, model, total_seat, is_active, type FROM vehicle JOIN vehicle_type ON vehicle_type_id = vehicle_type.id WHERE is_active = 1;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            var resultSet = preparedStatement.executeQuery();
            var meta = resultSet.getMetaData();
            var cols = new ArrayList<String>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                cols.add(meta.getColumnLabel(i));
            }
            while (resultSet.next()) {
                var row = new HashMap<String, Object>();
                for (String colName : cols) {
                    var val = resultSet.getObject(colName);
                    row.put(colName, val);
                }
                vehicles.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vehicles;
    }

    public static HashMap<String, String> AddVehicle(String typeId, String plate, String model, int seat, String active) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into vehicle(vehicle_type_id, plate_no, model, total_seat, is_active) values (?, ?, ?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(typeId));
            preparedStatement.setString(2, plate);
            preparedStatement.setString(3, model);
            preparedStatement.setInt(4, seat);
            preparedStatement.setInt(5, Integer.parseInt(active));
            preparedStatement.execute();
            stmt.close();
            result.put("code", "1");
            result.put("message", "Insert Successfully");
        } catch (SQLException ex) {
            result.put("code", "0");
            result.put("message", ex.getMessage());
        }
        return result;
    }

    public static HashMap<String, String> UpdateVehicle(int id, String typeId, String plate, String model, int seat, String active) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update vehicle set vehicle_type_id = ?, plate_no = ?, model = ?, total_seat = ?, is_active = ? where id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(typeId));
            preparedStatement.setString(2, plate);
            preparedStatement.setString(3, model);
            preparedStatement.setInt(4, seat);
            preparedStatement.setInt(5, Integer.parseInt(active));
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
            stmt.close();
            result.put("code", "1");
            result.put("message", "Update Successfully");
        } catch (SQLException ex) {
            result.put("code", "0");
            result.put("message", ex.getMessage());
        }
        return result;
    }
}
