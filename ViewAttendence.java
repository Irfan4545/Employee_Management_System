package employee.management.app;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewAttendence extends JFrame implements ActionListener {
    JButton Print, Back;
    JTable table;
    String empId;  // Store the EmpId

    ViewAttendence(String empId) {
        this.empId = empId;  // Save the EmpId to be used later
        setTitle("Attendance Details of Employee");
        getContentPane().setBackground(new Color(255, 131, 122));

        JLabel title = new JLabel("Attendance Details");
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

        // JTable to display employee attendance
        table = new JTable();
        table.setBounds(50, 100, 800, 500);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(350, 150, 900, 500);
        add(scrollPane);

        // Fetch and display attendance data based on EmpId
        loadAttendanceData();

        setSize(1550, 950);
        setLocation(0, 0);
        setLayout(null);
        setVisible(true);
    }

    private void loadAttendanceData() {
        try {
            // Establish connection to the database
            Conn conn = new Conn();

            // SQL query to fetch attendance details for the employee by EmpId
            String query = "SELECT * FROM attendence WHERE EmpId = '" + empId + "'";

            // Execute the query
            ResultSet rs = conn.statement.executeQuery(query);

            // Set the result set data into the JTable using DbUtils
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while loading attendance data.");
        }
    }

    @Override
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
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while printing.");
            }
        } else if (e.getSource() == Back) {
            setVisible(false);
            new EmployeeDasboard(empId);  // Navigate back to the Employee Dashboard
        }
    }

    public static void main(String[] args) {
        new ViewAttendence("E12345");  // Example EmpId
    }
}
