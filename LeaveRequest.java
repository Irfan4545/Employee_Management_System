package employee.management.app;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LeaveRequest extends JFrame implements ActionListener {
    JTextArea ttext;
    JLabel tname, tempid, tdepartment;
    JButton add, back;
    JDateChooser tdob, tjoin;
    JComboBox<String> Boxeducation;
    String empId;

    // Constructor now takes empId directly (signed-in employee)
    LeaveRequest(String empId) {
        this.empId = empId;
        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Leave Request");
        heading.setBounds(650, 50, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Employee details label
        JLabel label = new JLabel("Employee ID");
        label.setBounds(400,150,150,30);
        label.setFont(new Font("Tahoma", Font.BOLD,20));
        add(label);

        tempid = new JLabel();
        tempid .setBounds(550, 150, 150, 30);
        tempid .setBackground(new Color(177, 252, 197));
        tempid .setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tempid );

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

        JLabel jan = new JLabel("Leave Request:");
        jan.setBounds(400, 300, 300, 30);
        jan.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(jan);

        // Change JTextField to JTextArea for multi-line input
        ttext = new JTextArea();
        ttext.setBounds(400, 330, 650, 200);
        ttext.setBackground(new Color(177, 252, 197));
        ttext.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ttext.setLineWrap(true);  // Enable line wrapping
        ttext.setWrapStyleWord(true);  // Wrap at word boundaries
        ttext.setCaretPosition(0);  // Set initial caret position to top

        // Add a JScrollPane to make the JTextArea scrollable
        JScrollPane scrollPane = new JScrollPane(ttext);
        scrollPane.setBounds(400, 330, 650, 200);  // Same size as the JTextArea
        add(scrollPane);

        JLabel dob = new JLabel("Leaving Date");
        dob.setBounds(800, 150, 300, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(1000, 150, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel join = new JLabel("Joining Date");
        join.setBounds(800, 200, 300, 30);
        join.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(join);

        tjoin = new JDateChooser();
        tjoin.setBounds(1000, 200, 150, 30);
        tjoin.setBackground(new Color(177, 252, 197));
        add(tjoin);

        JLabel education = new JLabel("Leave Types");
        education.setBounds(800, 250, 300, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = {"Casual Leave", "Sick Leave", "Earned Leave", "Maternity Leave", "Paternity Leave", "Compensatory Off", "Bereavement Leave", "Sabbatical Leave", "Loss of Pay/Unpaid Leave", "Festival Leave"};
        Boxeducation = new JComboBox<>(items);
        Boxeducation.setBackground(new Color(177, 252, 197));
        Boxeducation.setBounds(1000, 250, 150, 30);
        add(Boxeducation);

        // Fetch the employee details for the signed-in employee
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee WHERE EmpId='" + empId + "'");
            if (resultSet.next()) {
                tempid.setText(resultSet.getString("EmpId"));
                tname.setText(resultSet.getString("Name"));
                tdepartment.setText(resultSet.getString("Department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add the "ADD" button
        add = new JButton("Send");
        add.setBounds(600,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // Back button
        back = new JButton("BACK");
        back.setBounds(800,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String Leavingdate = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String Joiningdate = ((JTextField) tjoin.getDateEditor().getUiComponent()).getText();
            String Leavetype = (String) Boxeducation.getSelectedItem();
            String Leavingrequest = ttext.getText();
            String EmpID = tempid.getText();


            // Check if any field is empty
            if (Leavingdate.isEmpty() || Joiningdate.isEmpty() || Leavetype.isEmpty() || Leavingrequest.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields before adding the attendance.");
            } else {
                try {
                    // Connection to database
                    Conn c = new Conn();

                    // SQL query to insert attendance data
                    String query = "INSERT INTO leaving (EmpID, Leavingdate, Joiningdate, Leavetype, Leavingrequest, status) " +
                            "VALUES ('" + EmpID + "', '" + Leavingdate + "', '" + Joiningdate + "', '" + Leavetype + "', '" + Leavingrequest + "', 'Pending')";


                    // Execute the query
                    c.statement.executeUpdate(query);

                    // Success message
                    JOptionPane.showMessageDialog(null, "Request send successfully");

                    // Hide the current frame and open the Dashboard
                    setVisible(false);
                    new EmployeeDasboard(empId);  // Assuming 'Dashboard' is the next window
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        }
        else{
            setVisible(false);
            new EmployeeDasboard(empId);
        }

    }
    public static void main (String[]args){
        new LeaveRequest("E12345");  // Pass the empId of the signed-in employee
    }

}
