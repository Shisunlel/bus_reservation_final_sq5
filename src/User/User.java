/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Login.DBCon;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vutha.vyrapol
 */
public class User {

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the positionId
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * @param positionId the positionId to set
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * @return the canLogin
     */
    public Integer getCanLogin() {
        return canLogin;
    }

    /**
     * @param canLogin the canLogin to set
     */
    public void setCanLogin(Integer canLogin) {
        this.canLogin = canLogin;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private static volatile User instance;
    private String firstName;
    private String lastName;
    private String email;
    private Integer positionId;
    private Integer canLogin;
    private String position;

    private User(String firstName, String lastName, String email, Integer positionId, Integer canLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.positionId = positionId;
        this.canLogin = canLogin;

        try {
            var stmt = DBCon.getConnection().createStatement();
            var query = "select name from position where id = ?";
            var preparedStatement = stmt.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, positionId);
            var resultSet = preparedStatement.executeQuery();
            this.position = resultSet.next() ? resultSet.getString("name") : "";
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static User getInstace(String firstName, String lastName, String email, Integer positionId, Integer canLogin) {
        User result = instance;
        if (result == null) {
            synchronized (User.class) {
                result = instance;
                if (result == null) {
                    instance = result = new User(firstName, lastName, email, positionId, canLogin);
                }
            }
        }
        return result;
    }

    public static User getCurrentInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "FirstName " + this.getFirstName() + " LastName " + this.getLastName();
    }

}
