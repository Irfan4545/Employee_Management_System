package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dasboard extends JFrame {

    Dasboard()
    {

        // Set the title of the JFrame
        setTitle("Employee Management System");

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1550,60);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dasboard.jpg.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);


        JLabel heading=new JLabel(" Admin Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Montserrat",Font.BOLD ,30));
        p1.add(heading);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,60,300,800);
        add(p2);

        //------------------------BUTTTON CODING STATART-------------------

        JButton hr=new JButton("Hr Manager Details");
        hr.setBounds(0,0,300,50);
        hr.setForeground(Color.WHITE);
        hr.setBackground(new Color(0,0,102));
        hr.setFont(new Font("Tahoma",Font.BOLD,20));
        hr.setMargin(new Insets(0,0,0,50));
        hr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HrView(200360);


            }
        });
        p2.add(hr);

        JButton add=new JButton("Add Employee Details");
        add.setBounds(0,70,300,50);
        add.setForeground(Color.WHITE);
        add.setBackground(new Color(0,0,102));
        add.setFont(new Font("Tahoma",Font.BOLD,20));
        add.setMargin(new Insets(0,0,0,50));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmployee();

            }
        });
        p2.add(add);


        JButton view=new JButton("View Employee Details");
        view.setBounds(0,140,300,50);
        view.setForeground(Color.WHITE);
        view.setBackground(new Color(0,0,102));
        view.setFont(new Font("Tahoma",Font.BOLD,20));
        view.setMargin(new Insets(0,0,0,40));
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee(Dasboard.this);

            }
        });
        p2.add(view);

        JButton update=new JButton("Update Employee Details");
        update.setBounds(0,210,300,50);
        update.setForeground(Color.WHITE);
        update.setBackground(new Color(0,0,102));
        update.setFont(new Font("Tahoma",Font.BOLD,20));
        update.setMargin(new Insets(0,0,0,30));
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee(Dasboard.this);

            }
        });
        p2.add(update);

        JButton viewleave =new JButton("Leave Requested table");
        viewleave.setBounds(0,280,300,50);
        viewleave.setForeground(Color.WHITE);
        viewleave.setBackground(new Color(0,0,102));
        viewleave.setFont(new Font("Tahoma",Font.BOLD,20));
        viewleave.setMargin(new Insets(0,0,0,30));
        viewleave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new LeaveRequesttable(Dasboard.this);



            }
        });
        p2.add(viewleave);

        JButton attendance =new JButton(" Employee Attendence ");
        attendance.setBounds(0,350,300,50);
        attendance.setForeground(Color.WHITE);
        attendance.setBackground(new Color(0,0,102));
        attendance.setFont(new Font("Tahoma",Font.BOLD,20));
        attendance.setMargin(new Insets(0,0,0,30));
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Employeeattendence(Dasboard.this);


            }
        });
        p2.add(attendance);

        JButton bonus =new JButton(" Pay Employee Salary");
        bonus.setBounds(0,420,300,50);
        bonus.setForeground(Color.WHITE);
        bonus.setBackground(new Color(0,0,102));
        bonus.setFont(new Font("Tahoma",Font.BOLD,20));
        bonus.setMargin(new Insets(0,0,0,30));
        bonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SallaryTable(Dasboard.this);

            }
        });
        p2.add(bonus);

        JButton views =new JButton(" View Employee Salary");
        views.setBounds(0,500,300,50);
        views.setForeground(Color.WHITE);
        views.setBackground(new Color(0,0,102));
        views.setFont(new Font("Tahoma",Font.BOLD,20));
        views.setMargin(new Insets(0,0,0,30));
        views.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new VSallary(Dasboard.this);

            }
        });
        p2.add(views);




        JButton rem =new JButton("Remove Employee");
        rem.setBounds(0,580,300,50);
        rem.setForeground(Color.WHITE);
        rem.setBackground(new Color(0,0,102));
        rem.setFont(new Font("Tahoma",Font.BOLD,20));
        rem.setMargin(new Insets(0,0,0,30));
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee(Dasboard.this);

            }
        });
        p2.add(rem);

        JButton logout =new JButton("Logout");
        logout.setBounds(0,650,300,50);
        logout.setBackground(Color.decode("#E94E77"));
        logout.setForeground(Color.white);
        logout.setFont(new Font("Tahoma",Font.BOLD,20));
        logout.setMargin(new Insets(0,0,0,50));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        p2.add(logout);


        //-------------------------------------BUTTON CODING END----------------------------

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/dasboard.jpg"));
        Image i5=i4.getImage().getScaledInstance(1400,950,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel images=new JLabel(i6);
        images.setBounds(200,10,1550,950);
        add(images);


        setSize(1550,950);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);


    }
    public static void main(String[]args)
    {
        new Dasboard();

    }
}



//package employee.management.app;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Dasboard extends JFrame {
//
//    JPanel mainPanel;
//
//    public Dasboard() {
//        setTitle("Employee Management System");
//        setLayout(null);
//        setSize(1400, 800);
//        setLocation(50, 10);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Top Header Panel
//        JPanel p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(0, 0, 102));
//        p1.setBounds(0, 0, 1400, 60);
//        add(p1);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dasboard.jpg.png"));
//        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
//        JLabel image = new JLabel(new ImageIcon(i2));
//        image.setBounds(5, 0, 70, 70);
//        p1.add(image);
//
//        JLabel heading = new JLabel(" Admin Dashboard");
//        heading.setBounds(80, 10, 300, 40);
//        heading.setForeground(Color.white);
//        heading.setFont(new Font("Montserrat", Font.BOLD, 30));
//        p1.add(heading);
//
//        // Side Menu Panel
//        JPanel p2 = new JPanel();
//        p2.setLayout(null);
//        p2.setBackground(new Color(0, 0, 102));
//        p2.setBounds(0, 60, 300, 740);
//        add(p2);
//
//        // Main Content Panel (CENTER)
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//        mainPanel.setBounds(300, 60, 1100, 740);
//        add(mainPanel);
//
//        // Load default image in center
//        JLabel defaultImageLabel = new JLabel();
//        defaultImageLabel.setHorizontalAlignment(JLabel.CENTER);
//        defaultImageLabel.setVerticalAlignment(JLabel.CENTER);
//        ImageIcon dashboardImage = new ImageIcon(ClassLoader.getSystemResource("icons/dasboard.jpg"));
//        Image homeImg = dashboardImage.getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
//        defaultImageLabel.setIcon(new ImageIcon(homeImg));
//        mainPanel.add(defaultImageLabel);
//
//        // Hr Manager Details Button
//        JButton hr = new JButton("Hr Manager Details");
//        hr.setBounds(0, 0, 300, 50);
//        styleButton(hr);
//        hr.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainPanel.removeAll();
//                mainPanel.setLayout(new BorderLayout());
//                mainPanel.add(new HrViewPanel(200360)); // Example HR ID
//                mainPanel.revalidate();
//                mainPanel.repaint();
//            }
//        });
//        p2.add(hr);
//
//        // Add Employee Button
//        JButton add = new JButton("Add Employee Details");
//        add.setBounds(0, 70, 300, 50);
//        styleButton(add);
//        add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainPanel.removeAll();
//                mainPanel.setLayout(new BorderLayout());
//                mainPanel.add(new AddEmployeePanel());
//                mainPanel.revalidate();
//                mainPanel.repaint();
//            }
//        });
//        p2.add(add);
//
//        setVisible(true);
//    }
//
//    private void styleButton(JButton btn) {
//        btn.setForeground(Color.WHITE);
//        btn.setBackground(new Color(0, 0, 102));
//        btn.setFont(new Font("Tahoma", Font.BOLD, 20));
//        btn.setMargin(new Insets(0, 0, 0, 50));
//    }
//
//    public static void main(String[] args) {
//        new Dasboard();
//    }
//}
