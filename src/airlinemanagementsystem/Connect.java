package airlinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    Connection c;
    Statement s;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Corrected class name
            
            // Corrected connection URL
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "Papamuma@13");
            s = c.createStatement();
        } catch (Exception e) {
            // Log the exception message
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}

