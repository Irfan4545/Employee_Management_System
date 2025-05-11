////package employee.management.app;
////
////import com.toedter.calendar.JDateChooser;
////
////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.*;
////import java.util.Random;
////
////public class AddEmployeePanel extends JPanel implements ActionListener {
////
////    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation, tdepartment;
////    JLabel tempid;
////    JDateChooser tdob;
////    JComboBox<String> Boxeducation;
////    JButton add;
////
////    public AddEmployeePanel() {
////        setLayout(null);
////        setBackground(new Color(163, 255, 188));
////        setPreferredSize(new Dimension(1000, 700));
////
////        Random ran = new Random();
////        int number = ran.nextInt(9999);
////
////        JLabel heading = new JLabel("Add Employee Details");
////        heading.setBounds(320, 30, 500, 50);
////        heading.setFont(new Font("serif", Font.BOLD, 25));
////        add(heading);
////
////        // Labels and Fields
////        addLabel("Name", 50, 150);
////        tname = addTextField(200, 150);
////
////        addLabel("Father's Name", 400, 150);
////        tfname = addTextField(600, 150);
////
////        addLabel("Date Of Birth", 50, 200);
////        tdob = new JDateChooser();
////        tdob.setBounds(200, 200, 150, 30);
////        tdob.setBackground(new Color(177, 252, 197));
////        add(tdob);
////
////        addLabel("Salary", 400, 200);
////        tsalary = addTextField(600, 200);
////
////        addLabel("Address", 50, 250);
////        taddress = addTextField(200, 250);
////
////        addLabel("Phone", 400, 250);
////        tphone = addTextField(600, 250);
////
////        addLabel("Email", 50, 300);
////        temail = addTextField(200, 300);
////
////        addLabel("Higest Education", 400, 300);
////        String[] items = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
////        Boxeducation = new JComboBox<>(items);
////        Boxeducation.setBackground(new Color(177, 252, 197));
////        Boxeducation.setBounds(600, 300, 150, 30);
////        add(Boxeducation);
////
////        addLabel("Designation", 50, 350);
////        tdesignation = addTextField(200, 350);
////
////        addLabel("Aadhar Number", 400, 350);
////        taadhar = addTextField(600, 350);
////
////        addLabel("Employee ID", 50, 400);
////        tempid = new JLabel("" + number);
////        tempid.setBounds(200, 400, 150, 30);
////        tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
////        tempid.setForeground(Color.RED);
////        add(tempid);
////
////        addLabel("Department", 400, 400);
////        tdepartment = addTextField(600, 400);
////
////        add = new JButton("ADD");
////        add.setBounds(350, 500, 150, 40);
////        add.setBackground(Color.black);
////        add.setForeground(Color.WHITE);
////        add.addActionListener(this);
////        add(add);
////    }
////
////    private void addLabel(String text, int x, int y) {
////        JLabel lbl = new JLabel(text);
////        lbl.setBounds(x, y, 150, 30);
////        lbl.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
////        add(lbl);
////    }
////
////    private JTextField addTextField(int x, int y) {
////        JTextField tf = new JTextField();
////        tf.setBounds(x, y, 150, 30);
////        tf.setBackground(new Color(177, 252, 197));
////        add(tf);
////        return tf;
////    }
////
////    @Override
////    public void actionPerformed(ActionEvent e) {
////        String Name = tname.getText();
////        String Fname = tfname.getText();
////        String Dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
////        String Salary = tsalary.getText();
////        String Address = taddress.getText();
////        String Aadhar = taadhar.getText();
////        String Phone = tphone.getText();
////        String Email = temail.getText();
////        String Education = (String) Boxeducation.getSelectedItem();
////        String Designation = tdesignation.getText();
////        String Department = tdepartment.getText();
////        String EmpID = tempid.getText();
////
////        if (Name.isEmpty() || Fname.isEmpty() || Dob.isEmpty() || Salary.isEmpty() ||
////                Address.isEmpty() || Aadhar.isEmpty() || Phone.isEmpty() || Email.isEmpty() ||
////                Education.isEmpty() || Designation.isEmpty() || Department.isEmpty()) {
////            JOptionPane.showMessageDialog(null, "Please fill in all fields before adding the employee.");
////        } else {
////            try {
////                Conn c = new Conn();
////                String query = "INSERT INTO employee VALUES('" + Name + "', '" + Fname + "', '" + Dob + "', '" + Salary + "', '" + Address + "', '" + Phone + "', '" + Email + "', '" + Education + "', '" + Designation + "', '" + Department + "', '" + Aadhar + "', '" + EmpID + "')";
////                c.statement.executeUpdate(query);
////                JOptionPane.showMessageDialog(null, "Employee added successfully.");
////            } catch (Exception ex) {
////                ex.printStackTrace();
////            }
////        }
////    }
////    public static void main (String[]args)
////    {
////        new AddEmployeePanel();
////    }
////}
//
//package employee.management.app;
//
//import com.toedter.calendar.JDateChooser;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Random;
//
//public class AddEmployeePanel extends JPanel implements ActionListener {
//
//    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation, tdepartment;
//    JLabel tempid;
//    JDateChooser tdob;
//    JComboBox<String> Boxeducation;
//    JButton add;
//
//    public AddEmployeePanel() {
//        setLayout(null);
//        setBackground(new Color(163, 255, 188));
//        setPreferredSize(new Dimension(1000, 700));
//
//        Random ran = new Random();
//        int number = ran.nextInt(9999);
//
//        JLabel heading = new JLabel("Add Employee Details");
//        heading.setBounds(350, 30, 500, 50);
//        heading.setFont(new Font("serif", Font.BOLD, 25));
//        add(heading);
//
//        // Labels and Fields
//        addLabel("Name", 150, 150);
//        tname = addTextField(300, 150);
//
//        addLabel("Father's Name", 500, 150);
//        tfname = addTextField(700, 150);
//
//        addLabel("Date Of Birth", 150, 200);
//        tdob = new JDateChooser();
//        tdob.setBounds(300, 200, 150, 30);
//        tdob.setBackground(new Color(177, 252, 197));
//        add(tdob);
//
//        addLabel("Salary", 500, 200);
//        tsalary = addTextField(700, 200);
//
//        addLabel("Address", 150, 250);
//        taddress = addTextField(300, 250);
//
//        addLabel("Phone", 500, 250);
//        tphone = addTextField(700, 250);
//
//        addLabel("Email", 150, 300);
//        temail = addTextField(300, 300);
//
//        addLabel("Higest Education", 500, 300);
//        String[] items = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
//        Boxeducation = new JComboBox<>(items);
//        Boxeducation.setBackground(new Color(177, 252, 197));
//        Boxeducation.setBounds(700, 300, 150, 30);
//        add(Boxeducation);
//
//        addLabel("Designation", 150, 350);
//        tdesignation = addTextField(300, 350);
//
//        addLabel("Aadhar Number", 500, 350);
//        taadhar = addTextField(700, 350);
//
//        addLabel("Employee ID", 150, 400);
//        tempid = new JLabel("" + number);
//        tempid.setBounds(300, 400, 150, 30);
//        tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
//        tempid.setForeground(Color.RED);
//        add(tempid);
//
//        addLabel("Department", 500, 400);
//        tdepartment = addTextField(700, 400);
//
//        add = new JButton("ADD");
//        add.setBounds(425, 500, 150, 40);
//        add.setBackground(Color.black);
//        add.setForeground(Color.WHITE);
//        add.addActionListener(this);
//        add(add);
//    }
//
//    private void addLabel(String text, int x, int y) {
//        JLabel lbl = new JLabel(text);
//        lbl.setBounds(x, y, 150, 30);
//        lbl.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
//        add(lbl);
//    }
//
//    private JTextField addTextField(int x, int y) {
//        JTextField tf = new JTextField();
//        tf.setBounds(x, y, 150, 30);
//        tf.setBackground(new Color(177, 252, 197));
//        add(tf);
//        return tf;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String Name = tname.getText();
//        String Fname = tfname.getText();
//        String Dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
//        String Salary = tsalary.getText();
//        String Address = taddress.getText();
//        String Aadhar = taadhar.getText();
//        String Phone = tphone.getText();
//        String Email = temail.getText();
//        String Education = (String) Boxeducation.getSelectedItem();
//        String Designation = tdesignation.getText();
//        String Department = tdepartment.getText();
//        String EmpID = tempid.getText();
//
//        if (Name.isEmpty() || Fname.isEmpty() || Dob.isEmpty() || Salary.isEmpty() ||
//                Address.isEmpty() || Aadhar.isEmpty() || Phone.isEmpty() || Email.isEmpty() ||
//                Education.isEmpty() || Designation.isEmpty() || Department.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill in all fields before adding the employee.");
//        } else {
//            try {
//                Conn c = new Conn();
//                String query = "INSERT INTO employee VALUES('" + Name + "', '" + Fname + "', '" + Dob + "', '" + Salary + "', '" + Address + "', '" + Phone + "', '" + Email + "', '" + Education + "', '" + Designation + "', '" + Department + "', '" + Aadhar + "', '" + EmpID + "')";
//                c.statement.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Employee added successfully.");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.add(new AddEmployeePanel());
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//}
