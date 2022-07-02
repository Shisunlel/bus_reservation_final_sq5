/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import Login.DBCon;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutha.vyrapol
 */
public class OvertimeClass {
    public static ArrayList<HashMap<String, Object>> getAllOvertimes() {
        var overtimes = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select overtime.id, first_name, last_name, duration, overtime.status, date from overtime join staff on staff_id = staff.id;";
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
                overtimes.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return overtimes;
    }
    
    public static HashMap<String, String> AddOvertime(String staffId, String duration, String status, String date) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into overtime(staff_id, duration, status, date) values (?, ?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(staffId));
            preparedStatement.setInt(2, Integer.parseInt(duration));
            preparedStatement.setString(3, status);
            preparedStatement.setDate(4, Date.valueOf(date));
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
    
    public static HashMap<String, String> UpdateOvertime(String id, String staffId, String duration, String status, String date) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update overtime set staff_id = ?, duration = ?, status = ?, date = ? where id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(staffId));
            preparedStatement.setInt(2, Integer.parseInt(duration));
            preparedStatement.setString(3, status);
            preparedStatement.setDate(4, Date.valueOf(date));
            preparedStatement.setInt(5, Integer.parseInt(id));
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
}
