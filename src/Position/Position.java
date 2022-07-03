/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Position;

import Login.DBCon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutha.vyrapol
 */
public class Position {

    static int poss;

    public static Integer can(String position_permission) {
        int can = 0;
        try {
            // read_account
            var pos_per = position_permission.split("_");
            var stmt = DBCon.getConnection().createStatement();
            var query = "select `" + pos_per[0] + "` from permission_position JOIN position on position_id = position.id JOIN permission on permission_id = permission.id WHERE position_id = " + User.User.getCurrentInstance().getPositionId() + " AND permission.name = ?";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setString(1, pos_per[1]);
            var resultSet = preparedStatement.executeQuery();
            can = resultSet.next() ? resultSet.getInt(pos_per[0]) : 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return can;
    }

    public static ArrayList<HashMap<String, Object>> getAllPositions() {
        var positions = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select * from position where id != 6";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            var resultSet = preparedStatement.executeQuery();
            var meta = resultSet.getMetaData();
            var cols = new ArrayList<String>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                cols.add(meta.getColumnName(i));
            }
            while (resultSet.next()) {
                var row = new HashMap<String, Object>();
                for (String colName : cols) {
                    var val = resultSet.getObject(colName);
                    row.put(colName, val);
                }
                positions.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return positions;
    }

    public static ArrayList<HashMap<String, Object>> getAllPermissions() {
        var permissions = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select * from permission";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            var resultSet = preparedStatement.executeQuery();
            var meta = resultSet.getMetaData();
            var cols = new ArrayList<String>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                cols.add(meta.getColumnName(i));
            }
            while (resultSet.next()) {
                var row = new HashMap<String, Object>();
                for (String colName : cols) {
                    var val = resultSet.getObject(colName);
                    row.put(colName, val);
                }
                permissions.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return permissions;
    }
    
    public static ArrayList<HashMap<String, Object>> getAllPermissionPosition() {
        var permissionPositions = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select permission_id, permission.name permission_name, position_id, position.name position_name from permission_position join permission on permission_id = permission.id join position on position_id = position.id";
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
                permissionPositions.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return permissionPositions;
    }

    public static HashMap<String, String> AddPosition(String name, String details) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into position(name, details) values (?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, details);
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
    
    public static HashMap<String, String> AddPermissionPosition(Integer permission_id, Integer position_id) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "insert into permission_position values (?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, permission_id);
            preparedStatement.setInt(2, position_id);
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

    public static HashMap<String, String> UpdatePosition(String id, String name, String details) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update position set name = ?, details = ? where id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, details);
            preparedStatement.setInt(3, Integer.parseInt(id));
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

    public static HashMap<String, String> UpdatePermission(Integer id, Integer read, Integer create, Integer update, Integer delete) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update permission set read = ?, create = ?, update = ?, delete = ? where id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, read);
            preparedStatement.setInt(2, create);
            preparedStatement.setInt(3, update);
            preparedStatement.setInt(4, delete);
            preparedStatement.setInt(5, id);
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
    
    public static HashMap<String, String> UpdatePermissionPosition(Integer oPermission, Integer oPosition, Integer nPermission, Integer nPosition) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "update permission_position set permission_id = ?, position_id = ? where permission_id = ? and position_id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, nPermission);
            preparedStatement.setInt(2, nPosition);
            preparedStatement.setInt(3, oPermission);
            preparedStatement.setInt(4, oPosition);
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
