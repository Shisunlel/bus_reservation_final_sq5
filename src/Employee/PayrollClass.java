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
public class PayrollClass {

    public static ArrayList<HashMap<String, Object>> getAllPayrolls() {
        var payrolls = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select payroll.id, first_name, last_name, amount, bonus, deduction, exchange_rate, total_usd, total_khr, date from payroll join staff on staff_id = staff.id;";
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
                payrolls.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return payrolls;
    }

    public static HashMap<String, String> AddPayrolls(String staffId, String date, double amount, double bonus, double deduction, int exchange, int total_khr, double total_usd) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into payroll(staff_id, amount, bonus, deduction, exchange_rate, total_usd, total_khr, date) values (?, ?, ?, ?, ?, ?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(staffId));
            preparedStatement.setDouble(2, amount);
            preparedStatement.setDouble(3, bonus);
            preparedStatement.setDouble(4, deduction);
            preparedStatement.setInt(5, exchange);
            preparedStatement.setDouble(6, total_usd);
            preparedStatement.setInt(7, total_khr);
            preparedStatement.setDate(8, Date.valueOf(date));
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

    public static HashMap<String, String> UpdatePayroll(String id, String staffId, String date, double amount, double bonus, double deduction, int exchange, int total_khr, double total_usd) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update payroll set staff_id = ?, amount = ?, bonus = ?, date = ?, deduction = ?, exchange_rate = ?, total_khr = ?, total_usd = ? where id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(staffId));
            preparedStatement.setDouble(2, amount);
            preparedStatement.setDouble(3, bonus);
            preparedStatement.setDate(4, Date.valueOf(date));
            preparedStatement.setDouble(5, deduction);
            preparedStatement.setInt(6, exchange);
            preparedStatement.setInt(7, total_khr);
            preparedStatement.setDouble(8, total_usd);
            preparedStatement.setInt(9, Integer.parseInt(id));
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
