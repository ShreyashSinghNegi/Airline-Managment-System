package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {
       
        setTitle("Flight Information");
        
        getContentPane().setBackground(Color.PINK);
        setLayout(new BorderLayout()); // Use BorderLayout for better component management

        JTable table = new JTable();
        try {
            Connect conn = new Connect();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");

            table.setModel(DbUtils.resultSetToTableModel(rs));

            // Add JScrollPane for the JTable
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
            JOptionPane.showMessageDialog(null, "Error retrieving flight information.");
        }

        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new FlightInfo());
    }
}
 
    
    

