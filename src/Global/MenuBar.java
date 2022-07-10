package Global;

import Employee.Account;
import Employee.Attendance;
import Employee.Overtime;
import Employee.Payroll;
import Position.Position;
import Position.Role;
import Vehicle.Vehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
        JPanel mainPanel = Account.firstPanel;

        if (isAdmin || Position.can("read_account") != 0) {
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
                    mainPanel.removeAll();
                    mainPanel.add(new Account());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            attendanceSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Attendance());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            otSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            roleSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Role());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            payrollSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Payroll());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            subMenu.add(accountSub);
            subMenu.add(attendanceSub);
            subMenu.add(otSub);
            subMenu.add(roleSub);
            subMenu.add(payrollSub);

        }
        if (isAdmin || Position.can("read_booking") != 0) {
            var subMenu = new JMenu("Booking");
            menu.add(subMenu);
            var newBookSub = new JMenuItem("New Booking");
            var manageBook = new JMenuItem("Manage Booking");
            var managePass = new JMenuItem("Manage Passenger");
            newBookSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            manageBook.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            managePass.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            subMenu.add(newBookSub);
            subMenu.add(manageBook);
            subMenu.add(managePass);
        }
        if (isAdmin || Position.can("read_vehicle") != 0) {
            var subMenu = new JMenu("Vehicle");
            subMenu.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Vehicle());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                }

                @Override
                public void menuCanceled(MenuEvent e) {
                }
            });
            menu.add(subMenu);
        }
        if (isAdmin || Position.can("read_finance") != 0) {
            var subMenu = new JMenu("Financial Account");
            subMenu.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                }

                @Override
                public void menuCanceled(MenuEvent e) {
                }
                
            });
            menu.add(subMenu);
        }
        if (isAdmin || Position.can("read_trip") != 0) {
            var subMenu = new JMenu("Trip Management");
            menu.add(subMenu);
            var locSub = new JMenuItem("Location");
            var routeSub = new JMenuItem("Route");
            var tripSub = new JMenuItem("Trip");
            locSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            routeSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            tripSub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            subMenu.add(locSub);
            subMenu.add(routeSub);
            subMenu.add(tripSub);
        }
        if (isAdmin || Position.can("read_report") != 0) {
            var subMenu = new JMenu("Reports");
            subMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
                    mainPanel.add(new Overtime());
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            menu.add(subMenu);
        }
        return menu;
    }

}
