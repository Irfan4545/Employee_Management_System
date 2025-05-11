package employee.management.app;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewLeave extends JFrame implements ActionListener {
    JButton Print, Back;
    JTable table;
    String empId ; // Store EmpID globally to use in the methods
    ViewLeave(String empId)
    {
        this.empId = empId; // Save the EmpId to be used later
        setTitle("Personal Details of Employee");
        getContentPane().setBackground(new Color(255, 131, 122));

        // Label to show employee details title
        JLabel title = new JLabel("Leave Tracking");
        title.setBounds(700, 70, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        Print = new JButton("Print");
        Print.setBounds(400, 120, 80, 20);
        Print.addActionListener(this);
        Print.setFont(new Font("Arrial",Font.BOLD,15));
        add(Print);

        Back = new JButton("Back");
        Back.setBounds(550, 120, 80, 20);
        Back.addActionListener(this);
        Back.setFont(new Font("Arrial",Font.BOLD,15));
        add(Back);

        // JTable to display employee details in a table format
        table = new JTable();
        table.setBounds(50, 100, 800, 500);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(350, 150, 900, 500);
        add(scrollPane);

        // Fetch and display employee data based on the EmpId
        loadEmployeeData();

        setSize(1550, 950);
        setLocation(0, 0);
        setLayout(null);
        setVisible(true);

    }

    // Method to load employee data from the database based on EmpId
    private void loadEmployeeData() {
        try {
            // Query to fetch the details of the logged-in employee using EmpId
            Conn conn = new Conn();
            String query = "SELECT * FROM leaving WHERE EmpID='" + empId + "'"; // Query for employee based on EmpId
            ResultSet rs = conn.statement.executeQuery(query);

            // Set the result set data into the table using DbUtils
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Print) {
            try {
                // Try to print the table data
                boolean printed = table.print(JTable.PrintMode.FIT_WIDTH, null, null);

                // If print was successful
                if (printed) {
                    JOptionPane.showMessageDialog(this, "Print successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Print cancelled.");
                }

            } catch (Exception ex) {
                // Handle exception during the print process
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while printing.");
            }
        } else if (e.getSource() == Back) {
            setVisible(false); // Hide the current vp window
            new EmployeeDasboard(empId); // Pass the same EmpId to the EmployeeDashboard
        }
    }
    public static void main(String[]args)
    {
        new ViewLeave("E12345");

    }
}
