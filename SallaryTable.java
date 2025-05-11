package employee.management.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SallaryTable extends JFrame implements ActionListener {
    JTextField troom, tbonous, tovertime, tabsent, tamount, tpf;
    JLabel tempid, tname, tdepartment, tnumber, tsalary, tattendence, tmonth;
    JButton add, back;
    Choice choiceEMPID, monthChoice;
    JFrame previousDashboard;

    SallaryTable(JFrame previousDashboard) {
        this.previousDashboard = previousDashboard;
        setTitle("Employee Management System");
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Employee Salary");
        heading.setBounds(650, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(400, 150, 150, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(550, 150, 150, 30);
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

        JLabel name = new JLabel("Name");
        name.setBounds(400, 200, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(550, 200, 150, 30);
        tname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tname);

        JLabel department = new JLabel("Department");
        department.setBounds(400, 250, 150, 30);
        department.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(department);

        tdepartment = new JLabel();
        tdepartment.setBounds(550, 250, 150, 30);
        add(tdepartment);

        JLabel number = new JLabel("UPI Number");
        number.setBounds(400, 300, 150, 30);
        number.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(number);

        tnumber = new JLabel();
        tnumber.setBounds(550, 300, 150, 30);
        add(tnumber);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 350, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JLabel();
        tsalary.setBounds(550, 350, 150, 30);
        add(tsalary);

        JLabel month = new JLabel("Month");
        month.setBounds(400, 400, 150, 30);
        month.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(month);

        monthChoice = new Choice();
        monthChoice.setBounds(550, 400, 150, 30);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (String m : months) monthChoice.add(m);
        add(monthChoice);

        tmonth = new JLabel();
        tmonth.setBounds(550, 400, 150, 30);
        add(tmonth);

        JLabel room = new JLabel("House Rent");
        room.setBounds(800, 150, 150, 30);
        room.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(room);

        troom = new JTextField();
        troom.setBounds(1000, 150, 150, 30);
        add(troom);

        JLabel overtime = new JLabel("Overtime");
        overtime.setBounds(800, 200, 150, 30);
        overtime.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(overtime);

        tovertime = new JTextField();
        tovertime.setBounds(1000, 200, 150, 30);
        add(tovertime);

        JLabel bonous = new JLabel("Bonus");
        bonous.setBounds(800, 250, 150, 30);
        bonous.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(bonous);

        tbonous = new JTextField();
        tbonous.setBounds(1000, 250, 150, 30);
        add(tbonous);

        JLabel pf = new JLabel("Provident Fund");
        pf.setBounds(800, 300, 180, 30);
        pf.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(pf);

        tpf = new JTextField();
        tpf.setBounds(1000, 300, 150, 30);
        add(tpf);

        JLabel absent = new JLabel("Attendance %");
        absent.setBounds(800, 350, 150, 30);
        absent.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(absent);

        tabsent = new JTextField();
        tabsent.setBounds(1000, 350, 150, 30);
        add(tabsent);

        JLabel amount = new JLabel("Net Salary");
        amount.setBounds(800, 400, 150, 30);
        amount.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(amount);

        tamount = new JTextField();
        tamount.setBounds(1000, 400, 150, 30);
        add(tamount);

        add = new JButton("PAY");
        add.setBounds(600, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(800, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);

        choiceEMPID.addItemListener(e -> updateEmployeeDetails());
        monthChoice.addItemListener(e -> updateEmployeeDetails());
    }

    private void updateEmployeeDetails() {
        try {
            String selectedEmpID = choiceEMPID.getSelectedItem();
            String selectedMonth = monthChoice.getSelectedItem();
            Conn c = new Conn();
            String query = "SELECT e.Name, e.Department, e.Phone, e.Salary, a." + selectedMonth +
                    " FROM employee e JOIN attendence a ON e.EmpID = a.EmpID WHERE e.EmpID = '" + selectedEmpID + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                tname.setText(resultSet.getString("Name"));
                tdepartment.setText(resultSet.getString("Department"));
                tnumber.setText(resultSet.getString("Phone"));
                tsalary.setText(resultSet.getString("Salary"));
                tabsent.setText(resultSet.getString(5));
                tmonth.setText(selectedMonth);
            } else {
                JOptionPane.showMessageDialog(this, "No data found for selected Employee and Month");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            try {
                String empID = choiceEMPID.getSelectedItem();
                String month = monthChoice.getSelectedItem();
                Conn c = new Conn();

                ResultSet rs = c.statement.executeQuery("SELECT * FROM salary WHERE EmpID = '" + empID + "' AND Status = 'Paid' AND Month = '" + month + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Salary already paid for " + month);
                } else {
                    if (tsalary.getText().trim().isEmpty() || tbonous.getText().trim().isEmpty() ||
                            tpf.getText().trim().isEmpty() || tovertime.getText().trim().isEmpty() ||
                            troom.getText().trim().isEmpty() || tabsent.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields before proceeding.");
                        return;
                    }

                    double basicSalary = Double.parseDouble(tsalary.getText().trim());
                    String absentText = tabsent.getText().replace("%", "").trim();
                    int attendancePercentage = Integer.parseInt(absentText);
                    int absent = 30 - (30 * attendancePercentage / 100);

                    double bonus = Double.parseDouble(tbonous.getText().trim());
                    double pf = Double.parseDouble(tpf.getText().trim());
                    double overtime = Double.parseDouble(tovertime.getText().trim());
                    double rent = Double.parseDouble(troom.getText().trim());
                    double perDay = basicSalary / 30;
                    double netSalary = basicSalary + bonus + overtime + rent - pf - (absent * perDay);

                    tamount.setText(String.format("%.2f", netSalary));

                    String insert = "INSERT INTO salary (EmpID, HouseRent, Overtime, Bonous, ProvidentFund, Absent, NetSalary, Salary, Status, Month) VALUES " +
                            "('" + empID + "', '" + rent + "', '" + overtime + "', '" + bonus + "', '" + pf + "', '" + absent + "', '" + netSalary + "', '" + basicSalary + "', 'Paid', '" + month + "')";

                    c.statement.executeUpdate(insert);
                    JOptionPane.showMessageDialog(this, "Salary paid for " + month);
                    setVisible(false);
                    new Dasboard();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Invalid number format in one or more fields. Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            previousDashboard.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SallaryTable(new Dasboard());
    }
}
