package Global;

import Employee.Account;
import Employee.Attendance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vutha.vyrapol
 */
public class MenuBar {

    public static JMenuBar createMenu(String role) {
        var isAdmin = "admin".equals(role);
        var menu = new JMenuBar();

        if (isAdmin || Position.Position.can("read_account") != 0) {
            var subMenu = new JMenu("Employee");
            menu.add(subMenu);
            var accountSub = new JMenuItem("Account");
            var attendanceSub = new JMenuItem("Attendance");
            var otSub = new JMenuItem("Overtime");
            var roleSub = new JMenuItem("Role And Permission");
            var payrollSub = new JMenuItem("Payroll");
            accountSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Account.firstPanel.remove(Account.secondPanel);
                    Account.firstPanel.add(new Account());
                }
            });
            attendanceSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Account.firstPanel.remove(Account.secondPanel);
                    Account.firstPanel.add(new Attendance());
                }
            });
            subMenu.add(accountSub);
            subMenu.add(attendanceSub);
            subMenu.add(otSub);
            subMenu.add(roleSub);
            subMenu.add(payrollSub);

        }
        if (isAdmin || Position.Position.can("read_booking") != 0) {
            var subMenu = new JMenu("Booking");
            menu.add(subMenu);
            var newBookSub = new JMenuItem("New Booking");
            var manageBook = new JMenuItem("Manage Booking");
            var managePass = new JMenuItem("Manage Passenger");
            subMenu.add(newBookSub);
            subMenu.add(manageBook);
            subMenu.add(managePass);
        }
        if (isAdmin || Position.Position.can("read_vehicle") != 0) {
            var subMenu = new JMenu("Vehicle");
            menu.add(subMenu);
        }
        if (isAdmin || Position.Position.can("read_finance") != 0) {
            var subMenu = new JMenu("Financial Account");
            menu.add(subMenu);
        }
        if (isAdmin || Position.Position.can("read_trip") != 0) {
            var subMenu = new JMenu("Trip Management");
            menu.add(subMenu);
            var locSub = new JMenuItem("Location");
            var routeSub = new JMenuItem("Route");
            var tripSub = new JMenuItem("Trip");
            subMenu.add(locSub);
            subMenu.add(routeSub);
            subMenu.add(tripSub);
        }
        if (isAdmin || Position.Position.can("read_report") != 0) {
            var subMenu = new JMenu("Reports");
            menu.add(subMenu);
        }
        return menu;
    }

}
