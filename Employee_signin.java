//package employee.management.app;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Employee_signin extends JFrame implements ActionListener {
//    JTextField tusername, temail;
//    JPasswordField tpassword;
//    JButton login, back;
//
//    Employee_signin() {
//        getContentPane().setBackground(new Color(255,255,255));
//        // Set the title of the JFrame
//        setTitle("Employee Management System");
//
//        Font font = new Font("Arial", Font.BOLD, 17);
//        Font font1=new Font("Arial",Font.BOLD,30);
//
//        JLabel name=new JLabel("Sign in to System");
//        name.setBounds(140,20,500,50);
//        name.setFont(font1);
//        name.setForeground(Color.decode("#32CD32"));  // Set a modern blue color
//        add(name);
//
//        JLabel username = new JLabel("Username :");
//        username.setBounds(60,100,100,30);
//        username.setFont(font);
//        add(username);
//
//        tusername = new JTextField();
//        tusername.setBounds(170,100,150,30);
//        tusername.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
//        add(tusername);
//
//        JLabel password = new JLabel("Password :");
//        password.setBounds(60,150,100,30);
//        password.setFont(font);
//        add(password);
//
//        tpassword = new JPasswordField();
//        tpassword.setBounds(170,150,150,30);
//        tpassword.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
//        add(tpassword);
//
//        JLabel email = new JLabel("Email Id    :");
//        email.setBounds(60,200,150,30);
//        email.setFont(font);
//        add(email);
//
//        temail= new JTextField();
//        temail.setBounds(170,200,150,30);
//        temail.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
//        add(temail);
//
//        login = new JButton("Sign in");
//        login.setBounds(60,250,120,30);
//        login.setBackground(Color.decode("#32CD32"));
//        login.setForeground(Color.white);
//        login.setFocusPainted(false);
//        login.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        login.addActionListener(this);
//        add(login);
//
//        back = new JButton("Cancel");
//        back.setBounds(200,250,120,30);
////      back.setBackground(Color.black);
////      back.setForeground(Color.WHITE);
//        back.setBackground(Color.decode("#E94E77"));
//        back.setForeground(Color.white);
//        back.setFocusPainted(false);
//        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        back.addActionListener(this);
//        add(back);
//
//
////        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
////        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
////        ImageIcon i3 = new ImageIcon(i2);
////        JLabel img = new JLabel(i3);
////        img.setBounds(0,0,600,400);
////        add(img);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
//        Image i22 = i11.getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT);
//        ImageIcon i33 = new ImageIcon(i22);
//        JLabel imge = new JLabel(i33);
//        imge.setBounds(160,0,600,400);
//        add(imge);
//
//        setSize(600,400);
//        setLayout(null);
//        setLocation(400,200);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == login) {
//            try {
//                String username = tusername.getText();
//                String password = String.valueOf(tpassword.getPassword());
//                String emailid = temail.getText();
//                Conn conn = new Conn();
//                String query = "SELECT * FROM employee WHERE name='" + username + "' AND empId='" + password + "' AND email='" + emailid + "'";
//                ResultSet resultSet = conn.statement.executeQuery(query);
//
//                if (resultSet.next()) {
//                    String empId = resultSet.getString("EmpID");  // Fetch the EmpID from the database
//                    JOptionPane.showMessageDialog(null, "Login successful");
//                    setVisible(false);
//                    new EmployeeDasboard(empId);  // Pass the logged-in employee's username to dashboard
//                } else {
//                    JOptionPane.showMessageDialog(null, "Invalid username or password");
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } else if (e.getSource() == back) {
//            System.exit(0);  // Exit the application (or you can navigate to the main screen)
//        }
//    }
//
//    public static void main(String[] args) {
//        new Employee_signin();  // Show the sign-in screen
//    }
//}


package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_signin extends JFrame implements ActionListener {
    JTextField tusername, temail;
    JPasswordField tpassword;
    JButton login, back;

    Employee_signin() {
        getContentPane().setBackground(new Color(255,255,255));
        // Set the title of the JFrame
        setTitle("Employee Management System");

        Font font = new Font("Arial", Font.BOLD, 22);
        Font font1=new Font("Arial",Font.BOLD,30);

        JLabel name=new JLabel("Sign in to System");
        name.setBounds(600,200,500,50);
        name.setFont(font1);
        name.setForeground(Color.decode("#32CD32"));  // Set a modern blue color
        add(name);

        JLabel username = new JLabel("Username :");
        username.setBounds(550,300,200,30);
        username.setFont(font);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(700,300,200,30);
        tusername.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
        add(tusername);

        JLabel password = new JLabel("Password :");
        password.setBounds(550,350,200,30);
        password.setFont(font);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(700,350,200,30);
        tpassword.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
        add(tpassword);



        login = new JButton("Sign in");
        login.setBounds(550,430,150,30);
        login.setBackground(Color.decode("#32CD32"));
        login.setForeground(Color.white);
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        login.addActionListener(this);
        login.setFont(new Font("Arrial",Font.BOLD,17));
        add(login);

        back = new JButton("Cancel");
        back.setBounds(750,430,150,30);
//      back.setBackground(Color.black);
//      back.setForeground(Color.WHITE);
        back.setBackground(Color.decode("#E94E77"));
        back.setForeground(Color.white);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        back.addActionListener(this);
        back.setFont(new Font("Arrial",Font.BOLD,17));
        add(back);


//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(0,0,600,400);
//        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        Image i22 = i11.getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imge = new JLabel(i33);
        imge.setBounds(200,0,600,400);
        add(imge);

        setSize(1550,950);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = String.valueOf(tpassword.getPassword());
                Conn conn = new Conn();
                String query = "SELECT * FROM employee WHERE name='" + username + "' AND empId='" + password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);

                if (resultSet.next()) {
                    String empId = resultSet.getString("EmpID");  // Fetch the EmpID from the database
                    JOptionPane.showMessageDialog(null, "Login successful");
                    setVisible(false);
                    new EmployeeDasboard(empId);  // Pass the logged-in employee's username to dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            System.exit(0);  // Exit the application (or you can navigate to the main screen)
        }
    }

    public static void main(String[] args) {
        new Employee_signin();  // Show the sign-in screen
    }
}

