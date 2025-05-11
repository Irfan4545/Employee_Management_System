package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddAtendence extends JFrame implements ActionListener {
    JTextField tjan, tfeb, tmar, tapr, tmay, tjun, tjul, taug, tsep, toct, tnov, tdec;
    JLabel tname, tdepartment;
    JButton add, back;
    Choice choiceEMPID;
    JFrame previousDashboard;

    AddAtendence(JFrame previousDashboard) {
        this.previousDashboard = previousDashboard;
        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(163, 255, 188));

        // Use GridBagLayout to center contentPanel
        setLayout(new GridBagLayout());

        // contentPanel with null layout (same as before)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(1000, 700)); // Increase width/height
        contentPanel.setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Attendance");
        heading.setBounds(350, 0, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        contentPanel.add(heading);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 100, 150, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPanel.add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 100, 150, 30);
        contentPanel.add(choiceEMPID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery(
                    "SELECT empId FROM employee WHERE empId NOT IN (SELECT EmpID FROM attendence)"
            );
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        contentPanel.add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPanel.add(tname);

        JLabel department = new JLabel("Department");
        department.setBounds(50, 200, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        contentPanel.add(department);

        tdepartment = new JLabel();
        tdepartment.setBounds(200, 200, 150, 30);
        contentPanel.add(tdepartment);

        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        JTextField[] monthFields = {
                tjan = new JTextField(), tfeb = new JTextField(), tmar = new JTextField(), tapr = new JTextField(),
                tmay = new JTextField(), tjun = new JTextField(), tjul = new JTextField(), taug = new JTextField(),
                tsep = new JTextField(), toct = new JTextField(), tnov = new JTextField(), tdec = new JTextField()
        };

        int x1 = 50, x2 = 500;
        int y1 = 260;
        for (int i = 0; i < 6; i++) {
            JLabel mLabel = new JLabel(months[i]);
            mLabel.setBounds(x1, y1 + (i * 50), 150, 30);
            mLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
            contentPanel.add(mLabel);

            monthFields[i].setBounds(x1 + 150, y1 + (i * 50), 150, 30);
            monthFields[i].setBackground(new Color(177, 252, 197));
            contentPanel.add(monthFields[i]);

            JLabel mLabel2 = new JLabel(months[i + 6]);
            mLabel2.setBounds(x2, y1 + (i * 50), 150, 30);
            mLabel2.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
            contentPanel.add(mLabel2);

            monthFields[i + 6].setBounds(x2 + 150, y1 + (i * 50), 150, 30);
            monthFields[i + 6].setBackground(new Color(177, 252, 197));
            contentPanel.add(monthFields[i + 6]);
        }

        loadEmployeeDetails(choiceEMPID.getSelectedItem());

        choiceEMPID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                loadEmployeeDetails(choiceEMPID.getSelectedItem());
            }
        });

        add = new JButton("ADD");
        add.setBounds(300, 580, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        contentPanel.add(add);

        back = new JButton("BACK");
        back.setBounds(500, 580, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        contentPanel.add(back);

        add(contentPanel); // Add panel to center of frame

        setSize(1550, 950);
        setLocationRelativeTo(null); // center frame on screen
        setVisible(true);
    }

    private void loadEmployeeDetails(String empId) {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee WHERE EmpId='" + empId + "'");
            if (resultSet.next()) {
                tname.setText(resultSet.getString("Name"));
                tdepartment.setText(resultSet.getString("Department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String[] data = {
                    tjan.getText(), tfeb.getText(), tmar.getText(), tapr.getText(), tmay.getText(), tjun.getText(),
                    tjul.getText(), taug.getText(), tsep.getText(), toct.getText(), tnov.getText(), tdec.getText()
            };

            for (String val : data) {
                if (val.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields before adding the attendance.");
                    return;
                }
            }

            String EmpId = choiceEMPID.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO attendence (EmpID, January, February, March, April, May, June, July, August, September, October, November, December) " +
                        "VALUES ('" + EmpId + "', '" + String.join("', '", data) + "')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Attendance added successfully");

                setVisible(false);
                new AddAtendence(previousDashboard);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            setVisible(false);
            previousDashboard.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddAtendence(new Dasboard());
    }
}
