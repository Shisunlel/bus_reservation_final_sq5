/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import Login.DBCon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutha.vyrapol
 */
public class Employee {
    // meta columnLabel get after rename
    // meta columnName get original name

    public static ArrayList<HashMap<String, Object>> getAllEmployees() {
        var staffs = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "SELECT staff.id, first_name, last_name, position.id position_id, position.name position, email, mobile, address, salary, can_login, is_active  FROM staff join position on position_id = position.id;";
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
                staffs.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return staffs;
    }

    public static HashMap<String, String> AddEmployee(String firstName, String lastName, String position, String email, String password, String mobile, String salary, String address, String can_login, String is_active) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into staff(position_id, first_name, last_name, email, password, mobile, address, salary, is_active, can_login) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(position));
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, mobile);
            preparedStatement.setString(7, address);
            preparedStatement.setFloat(8, Float.parseFloat(salary));
            preparedStatement.setInt(9, Integer.parseInt(is_active));
            preparedStatement.setInt(10, Integer.parseInt(can_login));
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
