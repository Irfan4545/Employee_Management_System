package employee.management.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class LeaveApproval extends JFrame implements ActionListener {
    private static String[][] leaveData; // Static array to store leave requests
    JButton approve, reject, back;
    JTable leaveTable;
    DefaultTableModel tableModel;

    LeaveApproval() {
        setTitle("Leave Request Approval");
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Leave Requests for Approval");
        heading.setBounds(630, 60, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Create table to display leave requests
        String[] columns = {"EmpID", "Leave Type", "Leave Request", "Leaving Date", "Status"};

        // Fetch leave data from database every time you open the LeaveApproval screen
        leaveData = fetchLeaveRequestsFromDatabase();

        // Initialize table model and table
        tableModel = new DefaultTableModel(leaveData, columns);
        leaveTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(leaveTable);
        scrollPane.setBounds(280, 150, 1000, 400);
        add(scrollPane);

        // Approve and Reject buttons
        approve = new JButton("Approve");
        approve.setBounds(500, 600, 150, 40);
        approve.setBackground(Color.green);
        approve.setForeground(Color.WHITE);
        approve.addActionListener(this);
        add(approve);

        reject = new JButton("Reject");
        reject.setBounds(700, 600, 150, 40);
        reject.setBackground(Color.red);
        reject.setForeground(Color.WHITE);
        reject.addActionListener(this);
        add(reject);

        // Back button
        back = new JButton("BACK");
        back.setBounds(900, 600, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1550, 950);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }

    // Fetch leave requests from the database
    private String[][] fetchLeaveRequestsFromDatabase() {
        try {
            Conn c = new Conn();
            Statement stmt = c.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM leaving WHERE status = 'Pending'");

            // Move the cursor to the last row to count the number of rows
            resultSet.last();
            int rowCount = resultSet.getRow();
            String[][] data = new String[rowCount][5];

            resultSet.beforeFirst(); // Reset cursor to the beginning

            int i = 0;
            while (resultSet.next()) {
                data[i][0] = resultSet.getString("EmpID");
                data[i][1] = resultSet.getString("Leavetype");
                data[i][2] = resultSet.getString("Leavingrequest");
                data[i][3] = resultSet.getString("Leavingdate"); // Added Leavingdate column
                data[i][4] = resultSet.getString("status");
                i++;
            }

            c.connection.close(); // Close connection after fetching data
            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[0][0];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If Back button is clicked, open the HR Dashboard without a dialog
        if (e.getSource() == back) {
            setVisible(false);  // Close the current window
            new HrDasboard();  // Open HR Dashboard class (make sure it's named correctly)
            return;  // Stop the method here to prevent further actions
        }

        // If a row is selected for approval or rejection
        int selectedRow = leaveTable.getSelectedRow();
        if (selectedRow != -1) {
            String empId = (String) leaveTable.getValueAt(selectedRow, 0);
            String status = e.getSource() == approve ? "Approved" : "Rejected";

            try {
                Conn c = new Conn();
                String query = "UPDATE leaving SET status='" + status + "' WHERE EmpID='" + empId + "' AND status='Pending'";
                c.statement.executeUpdate(query);

                // After updating the status in the database, update the status in the leaveData array
                leaveData[selectedRow][4] = status;  // Update the status in the table model

                // Update the table model to show the updated data (no need to fetch new data if already done)
                tableModel.setValueAt(status, selectedRow, 4); // Update only the status of the selected row

                // Show message dialog box after approval/rejection
                JOptionPane.showMessageDialog(null, "Request " + status + " successfully!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            // Show a message dialog if no row is selected
            JOptionPane.showMessageDialog(null, "Please select a leave request to approve/reject.");
        }
    }

    public static void main(String[] args) {
        new LeaveApproval();
    }
}

