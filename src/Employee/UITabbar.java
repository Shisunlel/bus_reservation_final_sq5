/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Employee;

import java.sql.*;
import Account.FinancialAccount;
import Login.DBCon;
import Passenger.ManagePassenger;
import Position.Role;
import Trip.*;
import Vehicle.Vehicle;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author yarith
 */
public class UITabbar extends javax.swing.JFrame {

    private final int menuHeight;
//    private final List<String> menuAccount = List.of("Employee", "Account", "Attendance", "Overtime", "Role and Permission", "Payroll");
    private final String[] menuAccount = {"Employee", "Account", "Attendance", "Overtime", "Role and Permission", "Payroll"};
    private final String[] menuBooking = {"Booking", "New Booking", "Manage Booking", "Manage Passenger"};
    private final String[] menuVehicle = {"Vehicle"};
    private final String[] menuFinancialAccount = {"Financial Account"};
    private final String[] menuTrip = {"Trip Management", "Location", "Route", "Trip"};
    private final String[] menuReports = {"Reports"};

    // make sure image names in '/icons/<menu>.png' match to menu name
    private final ImageIcon[] iconsAccount = makeIconsArray(menuAccount);
    private final ImageIcon[] iconsBooking = makeIconsArray(menuBooking);
    private final ImageIcon[] iconsVehicle = makeIconsArray(menuVehicle);
    private final ImageIcon[] iconsFinancialAccount = makeIconsArray(menuFinancialAccount);
    private final ImageIcon[] iconsTrip = makeIconsArray(menuTrip);
    private final ImageIcon[] iconsReports = makeIconsArray(menuReports);

    public UITabbar(String role) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        GradientDropdownMenu menu = new GradientDropdownMenu();
        menuHeight = menu.getMenuHeight();
        initComponents();
        menu.setHeaderGradient(false);
        // menu colors
        menu.setGradientColor(new Color(67, 161, 163), new Color(67, 161, 163));
        menu.setBackground(new Color(52, 119, 120));
        var isAdmin = "admin".equals(role);
        if (isAdmin || Position.Position.can("read_account") != 0) {
            menu.addItem(menuAccount, iconsAccount);
        }
        if (isAdmin || Position.Position.can("read_booking") != 0) {
            menu.addItem(menuBooking, iconsBooking);
        }
        if (isAdmin || Position.Position.can("read_vehicle") != 0) {
            menu.addItem(menuVehicle, iconsVehicle);
        }
        if (isAdmin || Position.Position.can("read_finance") != 0) {
            menu.addItem(menuFinancialAccount, iconsFinancialAccount);
        }
        if (isAdmin || Position.Position.can("read_trip") != 0) {
            menu.addItem(menuTrip, iconsTrip);
        }
        if (isAdmin || Position.Position.can("read_report") != 0) {
            menu.addItem(menuReports, iconsReports);
        }
        menu.applay(this);
        menu.addEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex, boolean menuItem) {
                if (menuItem) {
                    // load JFrame content according to menu name
                    showForm(menu.getMenuNameAt(index, subIndex));
                }
            }
        });
        // welcome label
        String fname = User.User.getCurrentInstance().getFirstName();
        String lname = User.User.getCurrentInstance().getLastName();
        JLabel lbWelcome = new JLabel("Welcome, " + fname + " " + lname + "!", JLabel.CENTER);
        lbWelcome.setFont(new Font("Dialog.bold", Font.PLAIN, 25));
        content.add(lbWelcome);
    }

    void showForm(String str) {
        this.setTitle(str);
        content.removeAll();
        // TODO: remove spaces to match class
        if (str.compareTo("Account") == 0) {
            JFrame window = new Account();
            content.add(window.getContentPane());
            window.setVisible(false);
        } else if (str.compareTo("Attendance") == 0) {
            content.add(new Attendance());
        } else if (str.compareTo("Overtime") == 0) {
            content.add(new Overtime());
        } else if (str.compareTo("Role and Permission") == 0) {
            content.add(new Role());
        } else if (str.compareTo("Payroll") == 0) {
            content.add(new Payroll());
        } else if (str.compareTo("New Booking") == 0) {
            JOptionPane.showMessageDialog(this, str + " content has not added yet.");
            // content.add(new NewBooking());
        } else if (str.compareTo("Manage Booking") == 0) {
            JOptionPane.showMessageDialog(this, str + " content has not added yet.");
            // content.add(new ManageBooking());
        } else if (str.compareTo("Manage Passenger") == 0) {
             content.add(new ManagePassenger());
        } else if (str.compareTo("Vehicle") == 0) {
            content.add(new Vehicle());
        } else if (str.compareTo("Financial Account") == 0) {
            content.add(new FinancialAccount());
        } else if (str.compareTo("Location") == 0) {
            content.add(new Location());
        } else if (str.compareTo("Route") == 0) {
//			JOptionPane.showMessageDialog(this, str+" content has not added yet.");
            content.add(new Route());
        } else if (str.compareTo("Trip") == 0) {
//			JOptionPane.showMessageDialog(this, str+" content has not added yet.");
            content.add(new Trip());
        } else if (str.compareTo("Reports") == 0) {
            JOptionPane.showMessageDialog(this, str + " content has not added yet.");
            // content.add(new Reports());
        } else {
            System.out.println(str + " not found in showForm().");
            JOptionPane.showMessageDialog(this, str + " content is missing or not found.");
        }
        content.repaint();
        content.revalidate();
    }

    ImageIcon[] makeIconsArray(String... menus) {
        ImageIcon[] iconsArr = new ImageIcon[menus.length];
        for (int i = 0; i < menus.length; i++) {
            URL imageUrl = getClass().getResource("/icons/" + menus[i] + ".png");
            if (imageUrl == null) {
                System.out.println("/icons/" + menus[i] + ".png" + " doesn't exist.");
                continue;
            }
            ImageIcon icon = new ImageIcon(imageUrl);
            Image image = icon.getImage();
            int imgH = image.getHeight(this);
            int imgW = image.getWidth(this);
            if (imgH > imgW) {
                image = image.getScaledInstance(25, -1, Image.SCALE_SMOOTH);
            } else {
                image = image.getScaledInstance(-1, 25, Image.SCALE_SMOOTH);
            }
            icon.setImage(image);
            iconsArr[i] = icon;
        }
        return iconsArr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setMinimumSize(new java.awt.Dimension(1337, 658));
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setBorder(new EmptyBorder(menuHeight,0,0,
            0));
    content.setLayout(new java.awt.GridLayout(1, 0));
    getContentPane().add(content);

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UITabbar(User.User.getCurrentInstance().getPosition()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel content;
    // End of variables declaration//GEN-END:variables

}
