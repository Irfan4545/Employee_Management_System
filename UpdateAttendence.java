//package employee.management.app;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class UpdateAttendence extends JFrame implements ActionListener {
//    JTextField tjan, tfeb, tmar, tapr, tmay, tjun, tjul, taug, tsep, toct, tnov, tdec;
//    JLabel tname, tdepartment;
//    JButton add, back;
//    Choice choiceEMPID;
//    JFrame previousDashboard;
//
//    UpdateAttendence(JFrame previousDashboard) {
//
//        this.previousDashboard = previousDashboard;
//        // JFrame setup and design
//        setTitle("Employee Management System");
//        getContentPane().setBackground(new Color(163, 255, 188));
//
//        JLabel heading = new JLabel("Update Employee Attendance");
//        heading.setBounds(320, 30, 500, 50);
//        heading.setFont(new Font("serif", Font.BOLD, 25));
//        add(heading);
//
//        // Employee details
//        JLabel empid = new JLabel("Employee ID");
//        empid.setBounds(50, 150, 150, 30);
//        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(empid);
//
//        choiceEMPID = new Choice();
//        choiceEMPID.setBounds(200, 150, 150, 30);
//        add(choiceEMPID);
//
//        // Populate Employee IDs
//        try {
//            Conn c = new Conn();
//            ResultSet resultSet = c.statement.executeQuery("Select * from employee");
//            while (resultSet.next()) {
//                choiceEMPID.add(resultSet.getString("empId"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Employee Info: Name, Department
//        JLabel name = new JLabel("Name");
//        name.setBounds(50, 200, 150, 30);
//        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(name);
//
//        tname = new JLabel();
//        tname.setBounds(200, 200, 150, 30);
//        tname.setBackground(new Color(177, 252, 197));
//        tname.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(tname);
//
//        JLabel department = new JLabel("Department");
//        department.setBounds(50, 250, 150, 30);
//        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(department);
//
//        tdepartment = new JLabel();
//        tdepartment.setBounds(200, 250, 150, 30);
//        tdepartment.setBackground(new Color(177, 252, 197));
//        add(tdepartment);
//
//        // Attendance fields for each month (Jan-Dec)
//        JLabel jan = new JLabel("January");
//        jan.setBounds(50, 300, 150, 30);
//        jan.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(jan);
//
//        tjan = new JTextField();
//        tjan.setBounds(200, 300, 150, 30);
//        tjan.setBackground(new Color(177, 252, 197));
//        add(tjan);
//
//        JLabel feb = new JLabel("February");
//        feb .setBounds(50, 350, 150, 30);
//        feb .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(feb);
//
//        tfeb= new JTextField();
//        tfeb.setBounds(200, 350, 150, 30);
//        tfeb.setBackground(new Color(177, 252, 197));
//        add(tfeb);
//
//        JLabel mar = new JLabel("March");
//        mar .setBounds(50, 400, 150, 30);
//        mar .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(mar);
//
//        tmar= new JTextField();
//        tmar.setBounds(200, 400, 150, 30);
//        tmar.setBackground(new Color(177, 252, 197));
//        add(tmar);
//
//        JLabel apr = new JLabel("April");
//        apr .setBounds(50, 450, 150, 30);
//        apr .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(apr);
//
//        tapr= new JTextField();
//        tapr.setBounds(200, 450, 150, 30);
//        tapr.setBackground(new Color(177, 252, 197));
//        add(tapr);
//
//        JLabel may = new JLabel("May");
//        may .setBounds(500, 150, 150, 30);
//        may .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(may);
//
//        tmay= new JTextField();
//        tmay.setBounds(650, 150, 150, 30);
//        tmay.setBackground(new Color(177, 252, 197));
//        add(tmay);
//
//        JLabel jun = new JLabel("June");
//        jun .setBounds(500, 200, 150, 30);
//        jun .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(jun);
//
//        tjun= new JTextField();
//        tjun.setBounds(650, 200, 150, 30);
//        tjun.setBackground(new Color(177, 252, 197));
//        add(tjun);
//
//        JLabel jul = new JLabel("July");
//        jul .setBounds(500, 250, 150, 30);
//        jul .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(jul);
//
//        tjul= new JTextField();
//        tjul.setBounds(650, 250, 150, 30);
//        tjul.setBackground(new Color(177, 252, 197));
//        add(tjul);
//
//        JLabel aug = new JLabel("August");
//        aug .setBounds(500, 300, 150, 30);
//        aug .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(aug);
//
//        taug= new JTextField();
//        taug.setBounds(650, 300, 150, 30);
//        taug.setBackground(new Color(177, 252, 197));
//        add(taug);
//
//        JLabel sep = new JLabel("September");
//        sep .setBounds(500, 350, 150, 30);
//        sep .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(sep);
//
//        tsep= new JTextField();
//        tsep.setBounds(650, 350, 150, 30);
//        tsep.setBackground(new Color(177, 252, 197));
//        add(tsep);
//
//        JLabel oct = new JLabel("October");
//        oct .setBounds(500, 400, 150, 30);
//        oct .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(oct);
//
//        toct= new JTextField();
//        toct.setBounds(650, 400, 150, 30);
//        toct.setBackground(new Color(177, 252, 197));
//        add(toct);
//
//        JLabel nov = new JLabel("November");
//        nov .setBounds(500, 450, 150, 30);
//        nov .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(nov);
//
//        tnov= new JTextField();
//        tnov.setBounds(650, 450, 150, 30);
//        tnov.setBackground(new Color(177, 252, 197));
//        add(tnov);
//
//        JLabel dec = new JLabel("December");
//        dec .setBounds(500, 500, 150, 30);
//        dec .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(dec);
//
//        tdec= new JTextField();
//        tdec.setBounds(650, 500, 150, 30);
//        tdec.setBackground(new Color(177, 252, 197));
//        add(tdec);
//
//        // Repeat the pattern for other months (February to December)...
//        // Use similar code for all months like January.
//
//        // Fetch data for selected employee
//        choiceEMPID.addItemListener(e -> {
//            // Clear existing data before fetching new data
//            tname.setText("");
//            tdepartment.setText("");
//            tjan.setText("");
//            tfeb.setText("");
//            tmar.setText("");
//            tapr.setText("");
//            tmay.setText("");
//            tjun.setText("");
//            tjul.setText("");
//            taug.setText("");
//            tsep.setText("");
//            toct.setText("");
//            tnov.setText("");
//            tdec.setText("");
//
//            try {
//                Conn c = new Conn();
//                String selectedEmpId = choiceEMPID.getSelectedItem();
//
//                // Fetch employee details
//                String employeeQuery = "SELECT * FROM employee WHERE empId='" + selectedEmpId + "'";
//                ResultSet employeeResultSet = c.statement.executeQuery(employeeQuery);
//                if (employeeResultSet.next()) {
//                    tname.setText(employeeResultSet.getString("name"));
//                    tdepartment.setText(employeeResultSet.getString("department"));
//                }
//
//                // Fetch attendance details
//                String attendanceQuery = "SELECT * FROM attendence WHERE EmpId='" + selectedEmpId + "'";
//                ResultSet attendanceResultSet = c.statement.executeQuery(attendanceQuery);
//                if (attendanceResultSet.next()) {
//                    tjan.setText(attendanceResultSet.getString("January"));
//                    tfeb.setText(attendanceResultSet.getString("February"));
//                    tmar.setText(attendanceResultSet.getString("March"));
//                    tapr.setText(attendanceResultSet.getString("April"));
//                    tmay.setText(attendanceResultSet.getString("May"));
//                    tjun.setText(attendanceResultSet.getString("June"));
//                    tjul.setText(attendanceResultSet.getString("July"));
//                    taug.setText(attendanceResultSet.getString("August"));
//                    tsep.setText(attendanceResultSet.getString("September"));
//                    toct.setText(attendanceResultSet.getString("October"));
//                    tnov.setText(attendanceResultSet.getString("November"));
//                    tdec.setText(attendanceResultSet.getString("December"));
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        // Pre-load data when UpdateAttendence window opens (for initially selected ID)
//        if (choiceEMPID.getItemCount() > 0) {
//            choiceEMPID.select(0); // Select the first employee ID by default
//            String selectedEmpId = choiceEMPID.getSelectedItem();
//
//            try {
//                Conn c = new Conn();
//
//                // Fetch employee details
//                String employeeQuery = "SELECT * FROM employee WHERE empId='" + selectedEmpId + "'";
//                ResultSet employeeResultSet = c.statement.executeQuery(employeeQuery);
//                if (employeeResultSet.next()) {
//                    tname.setText(employeeResultSet.getString("name"));
//                    tdepartment.setText(employeeResultSet.getString("department"));
//                }
//
//                // Fetch attendance details
//                String attendanceQuery = "SELECT * FROM attendence WHERE EmpId='" + selectedEmpId + "'";
//                ResultSet attendanceResultSet = c.statement.executeQuery(attendanceQuery);
//                if (attendanceResultSet.next()) {
//                    tjan.setText(attendanceResultSet.getString("January"));
//                    tfeb.setText(attendanceResultSet.getString("February"));
//                    tmar.setText(attendanceResultSet.getString("March"));
//                    tapr.setText(attendanceResultSet.getString("April"));
//                    tmay.setText(attendanceResultSet.getString("May"));
//                    tjun.setText(attendanceResultSet.getString("June"));
//                    tjul.setText(attendanceResultSet.getString("July"));
//                    taug.setText(attendanceResultSet.getString("August"));
//                    tsep.setText(attendanceResultSet.getString("September"));
//                    toct.setText(attendanceResultSet.getString("October"));
//                    tnov.setText(attendanceResultSet.getString("November"));
//                    tdec.setText(attendanceResultSet.getString("December"));
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        // Update button
//        add = new JButton("UPDATE");
//        add.setBounds(250, 550, 150, 40);
//        add.setBackground(Color.black);
//        add.setForeground(Color.WHITE);
//        add.addActionListener(this);
//        add(add);
//
//        // Back button
//        back = new JButton("BACK");
//        back.setBounds(450, 550, 150, 40);
//        back.setBackground(Color.black);
//        back.setForeground(Color.WHITE);
//        back.addActionListener(this);
//        add(back);
//
//        setSize(900, 700);
//        setLayout(null);
//        setLocation(300, 50);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == add) {
//            String January = tjan.getText();
//            String February = tfeb.getText();
//            String March = tmar.getText();
//            String April = tapr.getText();
//            String May = tmay.getText();
//            String June = tjun.getText();
//            String July = tjul.getText();
//            String August = taug.getText();
//            String September = tsep.getText();
//            String October = toct.getText();
//            String November = tnov.getText();
//            String December = tdec.getText();
//            String EmpId = choiceEMPID.getSelectedItem();
//
//            try {
//                // Connection to database
//                Conn c = new Conn();
//
//                // SQL query to update attendance data
//                String query = "UPDATE attendence SET " +
//                        "January='" + January + "', " +
//                        "February='" + February + "', " +
//                        "March='" + March + "', " +
//                        "April='" + April + "', " +
//                        "May='" + May + "', " +
//                        "June='" + June + "', " +
//                        "July='" + July + "', " +
//                        "August='" + August + "', " +
//                        "September='" + September + "', " +
//                        "October='" + October + "', " +
//                        "November='" + November + "', " +
//                        "December='" + December + "' " +
//                        "WHERE EmpId='" + EmpId + "'";
//
//                // Execute the query
//                c.statement.executeUpdate(query);
//
//                // Success message
//                JOptionPane.showMessageDialog(null, "Attendance updated successfully");
//
//                // Close current window
//                setVisible(false);
//               new Employeeattendence(new Dasboard());
//
//                // You can show a success message or redirect to another window
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } else if (e.getSource() == back) {
//            setVisible(false);
//            previousDashboard.setVisible(true); // Show previous dashboard
//
//        }
//    }
//
//    public static void main(String[] args) {
//        new UpdateAttendence(new Dasboard());
//    }
//}


package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateAttendence extends JFrame implements ActionListener {
    JTextField tjan, tfeb, tmar, tapr, tmay, tjun, tjul, taug, tsep, toct, tnov, tdec;
    JLabel tname, tdepartment;
    JButton add, back;
    Choice choiceEMPID;
    JFrame previousDashboard;

    UpdateAttendence(JFrame previousDashboard) {

        this.previousDashboard = previousDashboard;
        // JFrame setup and design
        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update Employee Attendance");
        heading.setBounds(650, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Employee details
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(400, 150, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(550, 150, 150, 30);
        add(choiceEMPID);

        // Populate Employee IDs
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from employee");
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Employee Info: Name, Department
        JLabel name = new JLabel("Name");
        name.setBounds(400, 200, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(550, 200, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        tname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tname);

        JLabel department = new JLabel("Department");
        department.setBounds(400, 250, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(department);

        tdepartment = new JLabel();
        tdepartment.setBounds(550, 250, 150, 30);
        tdepartment.setBackground(new Color(177, 252, 197));
        add(tdepartment);

        // Attendance fields for each month (Jan-Dec)
        JLabel jan = new JLabel("January");
        jan.setBounds(400, 300, 150, 30);
        jan.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(jan);

        tjan = new JTextField();
        tjan.setBounds(550, 300, 150, 30);
        tjan.setBackground(new Color(177, 252, 197));
        add(tjan);

        JLabel feb = new JLabel("February");
        feb .setBounds(400, 350, 150, 30);
        feb .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(feb);

        tfeb= new JTextField();
        tfeb.setBounds(550, 350, 150, 30);
        tfeb.setBackground(new Color(177, 252, 197));
        add(tfeb);

        JLabel mar = new JLabel("March");
        mar .setBounds(400, 400, 150, 30);
        mar .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(mar);

        tmar= new JTextField();
        tmar.setBounds(550, 400, 150, 30);
        tmar.setBackground(new Color(177, 252, 197));
        add(tmar);

        JLabel apr = new JLabel("April");
        apr .setBounds(400, 450, 150, 30);
        apr .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(apr);

        tapr= new JTextField();
        tapr.setBounds(550, 450, 150, 30);
        tapr.setBackground(new Color(177, 252, 197));
        add(tapr);

        JLabel may = new JLabel("May");
        may .setBounds(800, 150, 150, 30);
        may .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(may);

        tmay= new JTextField();
        tmay.setBounds(1000, 150, 150, 30);
        tmay.setBackground(new Color(177, 252, 197));
        add(tmay);

        JLabel jun = new JLabel("June");
        jun .setBounds(800, 200, 150, 30);
        jun .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(jun);

        tjun= new JTextField();
        tjun.setBounds(1000, 200, 150, 30);
        tjun.setBackground(new Color(177, 252, 197));
        add(tjun);

        JLabel jul = new JLabel("July");
        jul .setBounds(800, 250, 150, 30);
        jul .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(jul);

        tjul= new JTextField();
        tjul.setBounds(1000, 250, 150, 30);
        tjul.setBackground(new Color(177, 252, 197));
        add(tjul);

        JLabel aug = new JLabel("August");
        aug .setBounds(800, 300, 150, 30);
        aug .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aug);

        taug= new JTextField();
        taug.setBounds(1000, 300, 150, 30);
        taug.setBackground(new Color(177, 252, 197));
        add(taug);

        JLabel sep = new JLabel("September");
        sep .setBounds(800, 350, 150, 30);
        sep .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(sep);

        tsep= new JTextField();
        tsep.setBounds(1000, 350, 150, 30);
        tsep.setBackground(new Color(177, 252, 197));
        add(tsep);

        JLabel oct = new JLabel("October");
        oct .setBounds(800, 400, 150, 30);
        oct .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(oct);

        toct= new JTextField();
        toct.setBounds(1000, 400, 150, 30);
        toct.setBackground(new Color(177, 252, 197));
        add(toct);

        JLabel nov = new JLabel("November");
        nov .setBounds(800, 450, 150, 30);
        nov .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(nov);

        tnov= new JTextField();
        tnov.setBounds(1000, 450, 150, 30);
        tnov.setBackground(new Color(177, 252, 197));
        add(tnov);

        JLabel dec = new JLabel("December");
        dec .setBounds(800, 500, 150, 30);
        dec .setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dec);

        tdec= new JTextField();
        tdec.setBounds(1000, 500, 150, 30);
        tdec.setBackground(new Color(177, 252, 197));
        add(tdec);

        // Repeat the pattern for other months (February to December)...
        // Use similar code for all months like January.

        // Fetch data for selected employee
        choiceEMPID.addItemListener(e -> {
            // Clear existing data before fetching new data
            tname.setText("");
            tdepartment.setText("");
            tjan.setText("");
            tfeb.setText("");
            tmar.setText("");
            tapr.setText("");
            tmay.setText("");
            tjun.setText("");
            tjul.setText("");
            taug.setText("");
            tsep.setText("");
            toct.setText("");
            tnov.setText("");
            tdec.setText("");

            try {
                Conn c = new Conn();
                String selectedEmpId = choiceEMPID.getSelectedItem();

                // Fetch employee details
                String employeeQuery = "SELECT * FROM employee WHERE empId='" + selectedEmpId + "'";
                ResultSet employeeResultSet = c.statement.executeQuery(employeeQuery);
                if (employeeResultSet.next()) {
                    tname.setText(employeeResultSet.getString("name"));
                    tdepartment.setText(employeeResultSet.getString("department"));
                }

                // Fetch attendance details
                String attendanceQuery = "SELECT * FROM attendence WHERE EmpId='" + selectedEmpId + "'";
                ResultSet attendanceResultSet = c.statement.executeQuery(attendanceQuery);
                if (attendanceResultSet.next()) {
                    tjan.setText(attendanceResultSet.getString("January"));
                    tfeb.setText(attendanceResultSet.getString("February"));
                    tmar.setText(attendanceResultSet.getString("March"));
                    tapr.setText(attendanceResultSet.getString("April"));
                    tmay.setText(attendanceResultSet.getString("May"));
                    tjun.setText(attendanceResultSet.getString("June"));
                    tjul.setText(attendanceResultSet.getString("July"));
                    taug.setText(attendanceResultSet.getString("August"));
                    tsep.setText(attendanceResultSet.getString("September"));
                    toct.setText(attendanceResultSet.getString("October"));
                    tnov.setText(attendanceResultSet.getString("November"));
                    tdec.setText(attendanceResultSet.getString("December"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Pre-load data when UpdateAttendence window opens (for initially selected ID)
        if (choiceEMPID.getItemCount() > 0) {
            choiceEMPID.select(0); // Select the first employee ID by default
            String selectedEmpId = choiceEMPID.getSelectedItem();

            try {
                Conn c = new Conn();

                // Fetch employee details
                String employeeQuery = "SELECT * FROM employee WHERE empId='" + selectedEmpId + "'";
                ResultSet employeeResultSet = c.statement.executeQuery(employeeQuery);
                if (employeeResultSet.next()) {
                    tname.setText(employeeResultSet.getString("name"));
                    tdepartment.setText(employeeResultSet.getString("department"));
                }

                // Fetch attendance details
                String attendanceQuery = "SELECT * FROM attendence WHERE EmpId='" + selectedEmpId + "'";
                ResultSet attendanceResultSet = c.statement.executeQuery(attendanceQuery);
                if (attendanceResultSet.next()) {
                    tjan.setText(attendanceResultSet.getString("January"));
                    tfeb.setText(attendanceResultSet.getString("February"));
                    tmar.setText(attendanceResultSet.getString("March"));
                    tapr.setText(attendanceResultSet.getString("April"));
                    tmay.setText(attendanceResultSet.getString("May"));
                    tjun.setText(attendanceResultSet.getString("June"));
                    tjul.setText(attendanceResultSet.getString("July"));
                    taug.setText(attendanceResultSet.getString("August"));
                    tsep.setText(attendanceResultSet.getString("September"));
                    toct.setText(attendanceResultSet.getString("October"));
                    tnov.setText(attendanceResultSet.getString("November"));
                    tdec.setText(attendanceResultSet.getString("December"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Update button
        add = new JButton("UPDATE");
        add.setBounds(600, 600, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // Back button
        back = new JButton("BACK");
        back.setBounds(800, 600, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String January = tjan.getText();
            String February = tfeb.getText();
            String March = tmar.getText();
            String April = tapr.getText();
            String May = tmay.getText();
            String June = tjun.getText();
            String July = tjul.getText();
            String August = taug.getText();
            String September = tsep.getText();
            String October = toct.getText();
            String November = tnov.getText();
            String December = tdec.getText();
            String EmpId = choiceEMPID.getSelectedItem();

            try {
                // Connection to database
                Conn c = new Conn();

                // SQL query to update attendance data
                String query = "UPDATE attendence SET " +
                        "January='" + January + "', " +
                        "February='" + February + "', " +
                        "March='" + March + "', " +
                        "April='" + April + "', " +
                        "May='" + May + "', " +
                        "June='" + June + "', " +
                        "July='" + July + "', " +
                        "August='" + August + "', " +
                        "September='" + September + "', " +
                        "October='" + October + "', " +
                        "November='" + November + "', " +
                        "December='" + December + "' " +
                        "WHERE EmpId='" + EmpId + "'";

                // Execute the query
                c.statement.executeUpdate(query);

                // Success message
                JOptionPane.showMessageDialog(null, "Attendance updated successfully");

                // Close current window
                setVisible(false);
                new Employeeattendence(new Dasboard());

                // You can show a success message or redirect to another window
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            previousDashboard.setVisible(true); // Show previous dashboard

        }
    }

    public static void main(String[] args) {
        new UpdateAttendence(new Dasboard());
    }
}
