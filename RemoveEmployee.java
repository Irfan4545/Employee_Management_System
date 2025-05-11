package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
//
public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete, back;
    JFrame previousDashboard;  // To store the reference of the previous dashboard

    // Modify the constructor to accept the dashboard instance
    RemoveEmployee(JFrame previousDashboard) {
        this.previousDashboard = previousDashboard;  // Store the reference

        // Set the title of the JFrame
        setTitle("Employee Management System");

        //--------------------employee id search coding start----------------------

        JLabel heading = new JLabel("Remove Employee");
        heading.setBounds(350,100,300,40);
        heading.setFont(new Font("Arrial",Font.BOLD,25));
        add(heading);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(300,200,100,30);
        label.setFont(new Font("Arrial",Font.BOLD,17));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(450,200,200,30);
        choiceEMPID.setFont(new Font("Arrial",Font.BOLD,13));
        add(choiceEMPID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from employee");
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------Employee id search coding end--------------------------

        //----------------------- Get Employee information coding start------------------------
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(300,250,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        labelName.setFont(new Font("Arrial",Font.BOLD,17));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(450,250,200,30);
        textName.setFont(new Font("Arrial",Font.BOLD,15));
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(300,300,100,30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,17));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(450,300,100,30);
        textPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textPhone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(300,350,100,30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD,17));
        add(labelemail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(450,350,200,30);
        textEmail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textEmail);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from employee where empId='"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("Select * from employee where empId='"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //------------------------Button coding start----------------------------

        delete = new JButton("Delete");
        delete.setBounds(300,450,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        delete.setFont(new Font("Tahoma", Font.BOLD,14));
        add(delete);

        back = new JButton("Back");
        back.setBounds(450,450,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD,14));
        add(back);

        //-------------------Button coding end----------------------

        //--------------------------Image coding start-------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(950,150,500,500);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1550,950,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,1550,950);
        add(image);

        //-----------------------Image coding end----------------------

        setSize(1550,950);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }

    //---------------Button Action performed coding start--------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                Conn c = new Conn();
                // First delete related attendance records
                String deleteAttendanceQuery = "DELETE FROM leaving  WHERE EmpID = '" + choiceEMPID.getSelectedItem() + "'";
                c.statement.executeUpdate(deleteAttendanceQuery);

                String query = "delete from employee where empId='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee deleted successfully");
                setVisible(false);
                previousDashboard.setVisible(true);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            // Go back to the appropriate dashboard
            setVisible(false);
            previousDashboard.setVisible(true);  // Show the previous dashboard (Admin or HR)
        }
    }

    //---------------Button Action performed coding end--------------------------

    public static void main(String[] args) {
        new RemoveEmployee(new Dasboard());  // Pass the dashboard instance to RemoveEmployee
    }
}

