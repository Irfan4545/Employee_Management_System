//package employee.management.app;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//
//public class Login extends JFrame implements ActionListener {
//    JTextField tusername;
//    JPasswordField tpassword;
//
//    JButton login,back,signup;
//    Login()
//    {
//        // Set the title of the JFrame
//        setTitle("Employee Management System");
//
//        Font font = new Font("Arial", Font.BOLD, 17);
//        Font font1=new Font("Arial",Font.BOLD,30);
//
//        JLabel name=new JLabel("Login Page");
//        name.setBounds(140,20,200,50);
//        name.setFont(font1);
//        name.setForeground(Color.decode("#4A90E2"));  // Set a modern blue color
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
//        login = new JButton("LOGIN");
//        login.setBounds(60,220,120,30);
//        login.setBackground(Color.decode("#4A90E2"));
//        login.setForeground(Color.white);
//        login.setFocusPainted(false);
//        login.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        login.addActionListener(this);
//        add(login);
//
//        back = new JButton("Cancel");
//        back.setBounds(200,220,120,30);
////      back.setBackground(Color.black);
////      back.setForeground(Color.WHITE);
//        back.setBackground(Color.decode("#E94E77"));
//        back.setForeground(Color.white);
//        back.setFocusPainted(false);
//        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        back.addActionListener(this);
//        add(back);
//
//        signup= new JButton("Sign in");
//        signup.setBounds(140,265,120,30);
////      back.setBackground(Color.black);
////      back.setForeground(Color.WHITE);
//        signup.setBackground(Color.decode("#32CD32"));
//        signup.setForeground(Color.white);
//        signup.setFocusPainted(false);
//        signup.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        signup.addActionListener(this);
//        add(signup);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
//        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
//        ImageIcon i33 = new ImageIcon(i22);
//        JLabel imgg = new JLabel(i33);
//        imgg.setBounds(350,40,600,400);
//        add(imgg);
//
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(0,0,600,350);
//        add(img);
//
//        setSize(600,350);
//        setLocation(450,200);
//        setLayout(null);
//        setVisible(true);
//
////
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==login) {
//            //---------------Admin login-----------------------
//
//            try{
//                String username=tusername.getText();
//                String password=tpassword.getText();
//
//                Conn conn=new Conn();
//                //----------------------Admin login--------------------
//                String query="Select * from login where username ='"+ username+"' and password ='"+password+"' ";
//                ResultSet resultSet= conn.statement.executeQuery(query);
//                if(resultSet.next())
//                {
//                    setVisible(false);
////                    new Main_class();
//                    new Dasboard();
//
//                }
//                else{
//                    //------------------------HrManager login----------------------
//                    query="Select * from hrdata where Name ='"+ username+"' and HR_Id ='"+password+"' ";
//                    resultSet= conn.statement.executeQuery(query);
//
//                    if(resultSet.next())
//                    {
//                        setVisible(false);
////                    new Main_class();
//                        new HrDasboard();
//
//                    }
//                    else{
//                        JOptionPane.showMessageDialog(null,"Invalid username or password");
//                    }
//                }
//            }
//            catch (Exception E){
//                E.printStackTrace();
//            }
//
//
//        } else if (e.getSource()==signup) {
//            setVisible(false);
//            new Employee_signin();
//
//        } else if (e.getSource()==back) {
//            System.exit(60);
//
//        }
//
//    }
//
//    public static void main(String[]args)
//    {
//        new Login();
//
//    }
//}




package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;

    JButton login,back,signup;
    Login()
    {

        // Set the title of the JFrame
        setTitle("Employee Management System");

        // Set background color for the frame
        getContentPane().setBackground(Color.decode("#F0F0F0"));


        Font font = new Font("Arial", Font.BOLD, 25);
        Font font1=new Font("Arial",Font.BOLD,30);

        JLabel name=new JLabel("LOGIN FORM");
        name.setBounds(650,170,200,50);
        name.setFont(font1);
        name.setForeground(Color.decode("#4A90E2"));  // Set a modern blue color
        add(name);

        JLabel username=new JLabel("Username:");
        username.setBounds(470,260,200,50);
        username.setFont(font);
        add(username);



        tusername=new JTextField();
        tusername.setBounds(650,270,250,30);
        tusername.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
        add(tusername);

        JLabel password=new JLabel("Password:");
        password.setBounds(470,320,200,50);
        password.setFont(font);
        add(password);

        tpassword=new JPasswordField();
        tpassword.setBounds(650,330,250,30);
        tpassword.setBorder(BorderFactory.createLineBorder(Color.decode("#4A90E2"), 2));
        add(tpassword);

        login=new JButton("LOGIN");
        login.setBounds(700,420,200,30);
        login.setBackground(Color.decode("#4A90E2"));
        login.setForeground(Color.white);
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        login.addActionListener(this);
        login.setFont(new Font("Arrial",Font.BOLD,17));
        add(login);

        back=new JButton("Cancel");
        back.setBounds(570,480,250,30);
        back.setBackground(Color.decode("#E94E77"));
        back.setForeground(Color.white);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        back.addActionListener(this);
        back.setFont(new Font("Arrial",Font.BOLD,17));
        add(back);

        signup= new JButton("Sign in");
        signup.setBounds(470,420,200,30);
//      back.setBackground(Color.black);
//      back.setForeground(Color.WHITE);
        signup.setBackground(Color.decode("#32CD32"));
        signup.setForeground(Color.white);
        signup.setFocusPainted(false);
        signup.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        signup.addActionListener(this);
        signup.setFont(new Font("Arrial",Font.BOLD,17));
        add(signup);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22=i11.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(1000,230,700,500);
        add(imgg);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1600,850);
        add(img);






        setSize(1600,850);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);


//
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login) {
            //---------------Admin login-----------------------

            try{
                String username=tusername.getText();
                String password=tpassword.getText();

                Conn conn=new Conn();
                //----------------------Admin login--------------------
                String query="Select * from login where username ='"+ username+"' and password ='"+password+"' ";
                ResultSet resultSet= conn.statement.executeQuery(query);
                if(resultSet.next())
                {
                    setVisible(false);
//                    new Main_class();
                    new Dasboard();

                }
                else{
                    //------------------------HrManager login----------------------
                    query="Select * from hrdata where Name ='"+ username+"' and HR_Id ='"+password+"' ";
                    resultSet= conn.statement.executeQuery(query);

                    if(resultSet.next())
                    {
                        setVisible(false);
//                    new Main_class();
                        new HrDasboard();

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }


        } else if (e.getSource()==signup) {
            setVisible(false);
            new Employee_signin();

        } else if (e.getSource()==back) {
            System.exit(60);

        }

    }

    public static void main(String[]args)
    {
        new Login();

    }
}

