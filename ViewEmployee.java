package employee.management.app;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    Choice choiceEMP;
    JTable table;
    JButton Searchbtn, Print, Update, Back;
    JFrame previousDashboard;

    // Constructor that takes the previous dashboard as a parameter
    ViewEmployee(JFrame previousDashboard) {
        this.previousDashboard = previousDashboard;

        // Set the title of the JFrame
        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(255, 131, 122));

        //------------------- Search Section ----------------------
        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(400, 20, 250, 20);
        search.setFont(new Font("Arrial",Font.BOLD,17));
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(650, 20, 150, 20);
        add(choiceEMP);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("EmpId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //------------------- Search Section End -------------------

        //-------------------- Table Section ---------------------
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(350, 100, 900, 600);
        add(jp);
        //-------------------- Table Section End -------------------

        //-------------------- Button Section --------------------
        Searchbtn = new JButton("Search");
        Searchbtn.setBounds(350, 70, 100, 20);
        Searchbtn.addActionListener(this);
        Searchbtn.setFont(new Font("Arrial",Font.BOLD,15));
        add(Searchbtn);

        Print = new JButton("Print");
        Print.setBounds(500, 70, 80, 20);
        Print.addActionListener(this);
        Print.setFont(new Font("Arrial",Font.BOLD,15));
        add(Print);

        Update = new JButton("Update");
        Update.setBounds(640, 70, 100, 20);
        Update.addActionListener(this);
        Update.setFont(new Font("Arrial",Font.BOLD,15));
        add(Update);

        Back = new JButton("Back");
        Back.setBounds(800, 70, 80, 20);
        Back.addActionListener(this);
        Back.setFont(new Font("Arrial",Font.BOLD,15));
        add(Back);
        //-------------------- Button Section End ------------------

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    //------------------ Button Action Performed ----------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Searchbtn) {
            String query = "SELECT * FROM employee WHERE EmpId='" + choiceEMP.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == Print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == Update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem(), previousDashboard); // Pass employee ID and previous screen reference
        } else {
            setVisible(false);
            previousDashboard.setVisible(true); // Show previous dashboard
        }
    }
    //------------------ Button Action Performed End ------------------

    // Main method to run the application
    public static void main(String[] args) {
        new ViewEmployee(new Dasboard()); // Passing the Dashboard reference
    }
}


