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
public class AttendanceClass {
    public static ArrayList<HashMap<String, Object>> getAllAttendance() {
        var attendances = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select attendance.id, first_name, last_name, attendance.status, date from attendance join staff on staff_id = staff.id;";
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
                attendances.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return attendances;
    }
    
    public static HashMap<String, String> AddAttendance(String staffId, String status, String date) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into attendance(staff_id, status, date) values (?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(staffId));
            preparedStatement.setInt(2, Integer.parseInt(status));
            preparedStatement.setDate(3, Date.valueOf(date));
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
