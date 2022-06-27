/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vutha.vyrapol
 */
public class DBCon {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3307/bus_reservation?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "P@ssw0rd";
    
    public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(DB_URL, DBUSER, DBPASSWORD);
		return con;
    }
}
