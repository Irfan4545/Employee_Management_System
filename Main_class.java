package employee.management.app;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class()
    {

        // Set the title of the JFrame
        setTitle("Employee Management System");

        //BACKGROUND IMAG
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel((i3));
        img.setBounds(0,0,1120,630);
        add(img);

        //HEADING
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        //------------------------BUTTTON CODING STATART-------------------
        JButton add=new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmployee();

            }
        });
        img.add(add);



        JButton view=new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee(Main_class.this);

            }
        });
        img.add(view);

        JButton rem =new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee(Main_class.this);

            }
        });
        img.add(rem);
        //-------------------------------------BUTTON CODING END----------------------------

        setSize(1129,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[]args)
    {
        new Main_class();

    }
}
