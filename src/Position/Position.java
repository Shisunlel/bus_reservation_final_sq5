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
            var query = "select * from position";
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
}
