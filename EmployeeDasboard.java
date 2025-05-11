package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeDasboard extends JFrame {
    private String empId;

    // To store the logged-in employee's username

    EmployeeDasboard(String empId ) {
        this.empId = empId;


        // Store the logged-in employee's username

        // Set the title of the JFrame
        setTitle("Employee Management System");

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff"), 2));
        p1.setBounds(0, 0, 1550, 60);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dasboard.jpg.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);

        JLabel heading = new JLabel("EM Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Montserrat", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 60, 300, 800);
        add(p2);

        //------------------------BUTTON CODING START-------------------

        // View Personal Details Button
        JButton view = new JButton("View Personal Details");
        view.setBounds(0, 50, 300, 50);
        view.setForeground(Color.WHITE);
        view.setBackground(new Color(0, 0, 102));
        view.setFont(new Font("Tahoma", Font.BOLD, 20));
        view.setMargin(new Insets(0, 0, 0, 40));
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new vp(empId);  // Show the personal details of the logged-in employee
            }
        });
        p2.add(view);


        JButton leave =new JButton("Leave Request");
        leave.setBounds(0,140,300,50);
        leave.setForeground(Color.WHITE);
        leave.setBackground(new Color(0,0,102));
        leave.setFont(new Font("Tahoma",Font.BOLD,20));
        leave.setMargin(new Insets(0,0,0,30));
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new LeaveRequest(empId);

            }
        });
        p2.add(leave);

        JButton bonus =new JButton(" View Salary");
        bonus.setBounds(0,220,300,50);
        bonus.setForeground(Color.WHITE);
        bonus.setBackground(new Color(0,0,102));
        bonus.setFont(new Font("Tahoma",Font.BOLD,20));
        bonus.setMargin(new Insets(0,0,0,30));
        bonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new VS(empId);

            }
        });
        p2.add(bonus);

        JButton performance =new JButton(" Leave Tracking ");
        performance.setBounds(0,300,300,50);
        performance.setForeground(Color.WHITE);
        performance.setBackground(new Color(0,0,102));
        performance.setFont(new Font("Tahoma",Font.BOLD,20));
        performance.setMargin(new Insets(0,0,0,30));
        performance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewLeave(empId);


            }
        });
        p2.add(performance);

        JButton attendance =new JButton("  View Attendence ");
        attendance.setBounds(0,380,300,50);
        attendance.setForeground(Color.WHITE);
        attendance.setBackground(new Color(0,0,102));
        attendance.setFont(new Font("Tahoma",Font.BOLD,20));
        attendance.setMargin(new Insets(0,0,0,30));
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewAttendence(empId);




            }
        });
        p2.add(attendance);

        // Other buttons remain the same
        // Example: Leave, View Salary, Performance, etc.

        JButton logout = new JButton("Logout");
        logout.setBounds(0, 650, 300, 50);
        logout.setBackground(Color.decode("#E94E77"));
        logout.setForeground(Color.white);
        logout.setFont(new Font("Tahoma", Font.BOLD, 20));
        logout.setMargin(new Insets(0, 0, 0, 50));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // Optionally go back to the login screen (or close the app)
//                new Employee_signin();
            }
        });
        p2.add(logout);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/emp1.jpg"));
        Image i5=i4.getImage().getScaledInstance(1550,900,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel images=new JLabel(i6);
        images.setBounds(200,10,1550,900);
        add(images);

        setSize(1550, 950);
        setLocation(0, 0);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeDasboard("E12345");  // Pass the username of the logged-in employee
    }
}
