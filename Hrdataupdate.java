package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Hrdataupdate extends JFrame implements ActionListener {
    JTextField teducation, tfname, taddress, tphone, temail, tsalary, tdesignation, tdepartment;
    JLabel tempidLabel;
    JButton add, back;

    Hrdataupdate(int update) {
        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update HR Detail");
        heading.setBounds(650, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        //------------------------- Employee details coding start -----------------------
        JLabel name = new JLabel("Name");
        name.setBounds(400, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(550, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        tname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(800, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(1000, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(550, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(800, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(1000, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(400, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(550, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(800, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(1000, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(400, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(550, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(800, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(1000, 300, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(800, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(1000, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        taadhar.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(taadhar);

        JLabel empid = new JLabel("HR ID");
        empid.setBounds(400, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempidLabel = new JLabel();
        tempidLabel.setBounds(550, 400, 150, 30);
        tempidLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempidLabel.setForeground(Color.RED);
        add(tempidLabel);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(550, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        JLabel department = new JLabel("Department");
        department.setBounds(800, 400, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(department);

        tdepartment = new JTextField();
        tdepartment.setBounds(1000, 400, 150, 30);
        tdepartment.setBackground(new Color(177, 252, 197));
        add(tdepartment);

        // Fetch data from the database and populate fields
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM hrdata WHERE HR_Id = " + update;  // Use the passed HR_ID
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("Name"));
                tfname.setText(resultSet.getString("Fname"));
                tdob.setText(resultSet.getString("Dob"));
                taddress.setText(resultSet.getString("Adddress"));
                tsalary.setText(resultSet.getString("Salary"));
                tphone.setText(resultSet.getString("Phone"));
                temail.setText(resultSet.getString("Email_ID"));
                teducation.setText(resultSet.getString("Education"));
                taadhar.setText(resultSet.getString("Addhar"));
                tempidLabel.setText(resultSet.getString("HR_Id"));
                tdesignation.setText(resultSet.getString("Designation"));
                tdepartment.setText(resultSet.getString("Department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //------------------- Buttons start -----------------
        add = new JButton("UPDATE");
        add.setBounds(800, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(600, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        //--------------------- Buttons end ---------------------

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            // Get updated data from fields
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String adddress = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();
            String department = tdepartment.getText();

            try {
                Conn c = new Conn();
                // Update query based on HR_ID (ensure proper column names in the table)
                String query = "UPDATE hrdata SET Fname = '" + fname + "', Salary = '" + salary + "', Adddress = '" + adddress + "', Phone = '" + phone + "', Email_ID = '" + email + "', Education = '" + education + "', Designation = '" + designation + "', Department = '" + department + "' WHERE HR_Id = " + tempidLabel.getText();
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new Dasboard();  // Go back to the dashboard
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            // Back to the dashboard
            setVisible(false);
            new Dasboard();  // Go back to the dashboard
        }
    }

    public static void main(String[] args) {
        // Pass an HR_ID to update (e.g., 200360)
        new Hrdataupdate(200360);  // HR_ID as argument
    }
}
