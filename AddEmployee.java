package employee.management.app;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tname, tfname, taddress,tphone, taadhar, temail, tsalary,tdesignation,tdepartment;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox Boxeducation;
    JButton add,back;
    AddEmployee()
    {
        Random ran=new Random();
        int number=ran.nextInt(9999);

        // Set the title of the JFrame
        setTitle("Employee Management System");

        getContentPane().setBackground(new Color(163,255,188));

        //---------------add heading-----------------
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(650,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        //--------------employee details-------------------
        JLabel name=new JLabel("Name");
        name.setBounds(400,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(550,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(800,150,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(1000,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(550,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(800,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(1000,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(400,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(550,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(800,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(1000,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(400,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(email);

        temail= new JTextField();
        temail.setBounds(550,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education = new JLabel("Higest Education");
        education.setBounds(800,300,150,30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(education);

        String items[] = {"BBA","B.Tech","BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(1000,300,150,30);
        add(Boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(800,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(aadhar);

        taadhar= new JTextField();
        taadhar.setBounds(1000,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(400,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel(""+number);
        tempid.setBounds(550,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(400,350,150,30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(550,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);


        JLabel department = new JLabel("Department");
        department.setBounds(800, 400, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(department);

        tdepartment= new JTextField();
        tdepartment.setBounds(1000, 400, 150, 30);
        tdepartment.setBackground(new Color(177, 252, 197));
        add(tdepartment);


        //-------------buttons code----------------
        add = new JButton("ADD");
        add.setBounds(600,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(800,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setSize(1550,950);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add)
        {
            String Name=tname.getText();
            String Fname= tfname.getText();
            String Dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String Salary = tsalary.getText();
            String Address = taddress.getText();
            String Aadhar = taadhar.getText();
            String Phone = tphone.getText();
            String Email = temail.getText();
            String Education = (String) Boxeducation.getSelectedItem();
            String Designation = tdesignation.getText();
            String Department = tdesignation.getText();
            String EmpID = tempid.getText();

            if (Name.isEmpty() || Fname.isEmpty() || Dob.isEmpty() || Salary.isEmpty() ||
                    Address.isEmpty() || Aadhar.isEmpty() || Phone.isEmpty() || Email.isEmpty() ||
                    Education.isEmpty() || Designation.isEmpty()||Department.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill in all fields before adding the employee.");

            }
            else{
                try{
                    Conn c=new Conn();
                    String query = "insert into employee values('"+Name+"', '"+Fname+"', '"+Dob+"', '"+Salary+"','"+Address+"', '"+Phone+"', '"+Email+"', '"+Education+"', '"+Designation+"','"+Department+"','"+Aadhar+"', '"+EmpID+"')";
                    c.statement.executeUpdate(query);JOptionPane.showMessageDialog(null,"Details added succesfully");
                    setVisible(false);
//                   new Main_class();
                    new Dasboard();



                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }

        }
        else{
            setVisible(false);
//            new Main_class();
            new Dasboard();
        }
    }

    public static void main(String[] args)
    {
        new AddEmployee();

    }
}




