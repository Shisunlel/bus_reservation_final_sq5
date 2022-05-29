/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Position;

import Login.DBCon;
import java.sql.SQLException;

/**
 *
 * @author vutha.vyrapol
 */
public class Position {
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
}
