/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Passenger;

import Login.DBCon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutha.vyrapol
 */
public class Passenger {
    public static ArrayList<HashMap<String, Object>> getAllPassengers() {
        var passengers = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select * from passenger;";
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
                passengers.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return passengers;
    }
    
    public static HashMap<String, String> AddPassenger(String firstName, String lastName, String mobile) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into passenger(first_name, last_name, mobile) values (?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, mobile);
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
    
    public static HashMap<String, String> UpdatePassenger(int id, String firstName, String lastName, String mobile) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update passenger set first_name = ?, last_name = ?, mobile = ? where id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, mobile);
            preparedStatement.setInt(4, id);
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
