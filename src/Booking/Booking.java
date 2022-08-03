/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Booking;

import Login.DBCon;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutha.vyrapol
 */
public class Booking {

    public static ArrayList<HashMap<String, Object>> getTrips() {
        var trips = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "SELECT route_id, name FROM trip join route on route_id = route.id where trip.status = 1 group by route_id;";
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
                trips.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return trips;
    }

    public static ArrayList<HashMap<String, Object>> findTrips(String date, int route) {
        var availableTrips = new ArrayList<HashMap<String, Object>>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select trip.id, model, origin, destination, type, round(price, 2) price, total_seat - sold_ticket as available_seats from trip join vehicle on vehicle_id = vehicle.id join route on route_id = route.id join vehicle_type on route.vehicle_type_id = vehicle_type.id where trip.status = 1 and start_date >= ? and route_id = ?";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, route);
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
                availableTrips.add(row);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return availableTrips;
    }

    public static String getBookedSeats(String trip_id) {
        String seats = "";
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "SELECT GROUP_CONCAT(seat_no separator ',') FROM booking where trip_id = ?;";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(trip_id));
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seats = resultSet.getString(1);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return seats;
    }

    public static HashMap<String, String> AddBooking(int trip_id, int passenger_id, float price, float paid, int total_seat, String seat_no, String date) {
        HashMap<String, String> result = new HashMap<>();
        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "INSERT into booking(trip_id, passenger_id, price, paid, total_seat, status, seat_no, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, trip_id);
            preparedStatement.setInt(2, passenger_id);
            preparedStatement.setFloat(3, price);
            preparedStatement.setFloat(4, paid);
            preparedStatement.setInt(5, total_seat);
            preparedStatement.setString(6, "booked");
            preparedStatement.setString(7, seat_no);
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
}
