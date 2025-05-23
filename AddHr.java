package employee.management.app;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHr extends JFrame implements ActionListener {
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation,thrid,tdepartment;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox Boxeducation;
    JButton add, back;

    AddHr() {
        setTitle("Employee Management System");

        getContentPane().setBackground(new Color(163, 255, 188));

        //---------------add heading-----------------
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        //--------------employee details-------------------
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel education = new JLabel("Higest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177, 252, 197));
        Boxeducation.setBounds(600, 300, 150, 30);
        add(Boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        JLabel empid = new JLabel("HR ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        thrid = new JTextField();
        thrid.setBounds(200, 400, 150, 30);
        thrid.setBackground(new Color(177, 252, 197));
        add(thrid);



        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        JLabel department = new JLabel("Department");
        department.setBounds(400, 400, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(department);

        tdepartment= new JTextField();
        tdepartment.setBounds(600, 400, 150, 30);
        tdepartment.setBackground(new Color(177, 252, 197));
        add(tdepartment);

        //-------------buttons code----------------
        add = new JButton("ADD");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String Name = tname.getText();
            String Fname = tfname.getText();
            String Dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String Salary = tsalary.getText();
            String Address = taddress.getText();
            String Aadhar = taadhar.getText();
            String Phone = tphone.getText();
            String Email = temail.getText();
            String Education = (String) Boxeducation.getSelectedItem();
            String Designation = tdesignation.getText();
            String Department = tdesignation.getText();
//            Integer HR_ID = Integer.valueOf(thrid.getText());
            String HR_ID = thrid.getText();


            if (Name.isEmpty() || Fname.isEmpty() || Dob.isEmpty() || Salary.isEmpty() ||
                    Address.isEmpty() || Aadhar.isEmpty() || Phone.isEmpty() || Email.isEmpty() ||
                    Education.isEmpty() || Designation.isEmpty()||Department.isEmpty()||HR_ID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields before adding the employee.");

            } else {
                try {
                    Conn c = new Conn();
                    String query = "insert into hrdata values("+HR_ID+",'" + Name + "', '" + Fname + "', '" + Dob + "', '" + Salary + "','" + Address + "', '" + Phone + "', '" + Email + "', '" + Education + "', '" + Designation + "','" + Aadhar + "','"+Department+"')";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details added succesfully");
                    setVisible(false);
//                   new Main_class();
                    new Dasboard();


                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        } else {
            setVisible(false);
//            new Main_class();
            new Dasboard();
        }
    }
    public static void main(String[] args)
    {
        new AddHr();

    }
}