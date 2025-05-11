package employee.management.app;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employeeattendence extends JFrame implements ActionListener {
    Choice choiceEMP;
    JTable table;
    JButton Searchbtn, Print, Update, Back,addatendence;
    JFrame previousDashboard;
    // Store username globally to use in the methods

    Employeeattendence(JFrame previousDashboard) {

        this.previousDashboard = previousDashboard;  // Store the reference

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
            ResultSet resultSet = c.statement.executeQuery("SELECT  * FROM attendence");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("EmpId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //-------------------- Table Section ---------------------
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM  attendence");
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
        Print.setBounds(480, 70, 80, 20);
        Print.addActionListener(this);
        Print.setFont(new Font("Arrial",Font.BOLD,15));
        add(Print);

        Update = new JButton("Update");
        Update.setBounds(610, 70, 100, 20);
        Update.addActionListener(this);
        Update.setFont(new Font("Arrial",Font.BOLD,15));
        add(Update);


        addatendence = new JButton("Add Attendence");
        addatendence.setBounds(750, 70, 200, 20);
        addatendence.addActionListener(this);
        addatendence.setFont(new Font("Arrial",Font.BOLD,15));
        add(addatendence);


        Back = new JButton("Back");
        Back.setBounds(980, 70, 80, 20);
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

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM attendence WHERE EmpId='" + choiceEMP.getSelectedItem() + "'";
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
            new UpdateAttendence(Employeeattendence.this);

        } else if (e.getSource()==addatendence) {
            setVisible(false);
            new AddAtendence(Employeeattendence.this);

        } else {
            setVisible(false);
            previousDashboard.setVisible(true); // Show previous dashboard
        }
    }
    //------------------ Button Action Performed End ------------------

    public static void main(String[] args) {
        new Employeeattendence(new Dasboard());
    }
}
