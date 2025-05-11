package employee.management.app;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class HrView extends JFrame implements ActionListener {
    JTable table;
    JButton Print, Update, Back;

    // Constructor
    HrView(int hrId) // Pass HR_ID as an argument
    {

        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(255, 131, 122));
        Font font1=new Font("Arial",Font.BOLD,25);

        JLabel name=new JLabel("HR MANAGER DETAILS");
        name.setBounds(600,10,400,50);
        name.setFont(font1);
        name.setForeground(Color.decode("#ffffff"));
        add(name);


        //------------------- Table Section -------------------
        table = new JTable();
        try {
            // Query to fetch data for a specific HR_ID
            Conn c = new Conn();
            String query = "SELECT * FROM hrdata WHERE HR_Id = " + hrId;  // Direct query using HR_ID
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(350, 120, 900, 600);
        add(jp);
        //------------------- Table Section End -------------------

        //------------------- Button Section --------------------
        Print = new JButton("Print");
        Print.setBounds(350, 70, 100, 30);
        Print.addActionListener(this);
        Print.setFont(new Font("Arrial",Font.BOLD,15));
        add(Print);

        Update = new JButton("Update");
        Update.setBounds(470, 70, 100, 30);
        Update.addActionListener(this);
        Update.setFont(new Font("Arrial",Font.BOLD,15));
        add(Update);

        Back = new JButton("Back");
        Back.setBounds(590, 70, 100, 30);
        Back.addActionListener(this);
        Back.setFont(new Font("Arrial",Font.BOLD,15));
        add(Back);
        //------------------- Button Section End ------------------

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    // Action handler
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == Update) {
            setVisible(false);
            new Hrdataupdate(200360);
        }  else {
            setVisible(false);
            new Dasboard();
        }
    }
    public static void main(String[] args) {
        // Assuming HR_ID = 1 for example, modify it based on your need
        new HrView(200360); // You can change this ID based on which HR data you want to show
    }
}
