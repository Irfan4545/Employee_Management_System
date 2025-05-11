//package employee.management.app;
//
//import net.proteanit.sql.DbUtils;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.ResultSet;
//
//public class HrViewPanel extends JPanel implements ActionListener {
//    JTable table;
//    JButton Print, Update;
//    int hrId;
//
//    public HrViewPanel(int hrId) {
//        this.hrId = hrId;
//        setLayout(null);
//        setBackground(new Color(255, 131, 122));
//        setPreferredSize(new Dimension(1000, 700));
//
//        Font font1 = new Font("Arial", Font.BOLD, 25);
//
//        JLabel name = new JLabel("HR MANAGER DETAILS");
//        name.setBounds(330, 10, 400, 50); // Centered horizontally
//        name.setFont(font1);
//        name.setForeground(Color.decode("#000000"));
//        add(name);
//
//        // Table Section
//        table = new JTable();
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM hrdata WHERE HR_Id = " + hrId;
//            ResultSet resultSet = c.statement.executeQuery(query);
//            table.setModel(DbUtils.resultSetToTableModel(resultSet));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JScrollPane jp = new JScrollPane(table);
//        jp.setBounds(50, 100, 900, 500);  // Centered horizontally with margin
//        add(jp);
//
//        // Button Section
//        Print = new JButton("Print");
//        Print.setBounds(320, 620, 100, 30);
//        Print.addActionListener(this);
//        add(Print);
//
//        Update = new JButton("Update");
//        Update.setBounds(480, 620, 100, 30);
//        Update.addActionListener(this);
//        add(Update);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == Print) {
//            try {
//                table.print();
//            } catch (Exception E) {
//                E.printStackTrace();
//            }
//        } else if (e.getSource() == Update) {
//            JOptionPane.showMessageDialog(this, "Opening Update HR Panel...");
//            // You can create HrUpdatePanel and load it into Dashboard here
//        }
//    }
//    public static void main (String[]args)
//    {
//        new HrViewPanel(200360);
//    }
//}
