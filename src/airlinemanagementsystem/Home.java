package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        // Set layout manager to null
        setLayout(null);
        
        // Load the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image); 

        // Create and customize the heading label
        JLabel heading = new JLabel("Welcome to AIR INDIA");
        heading.setBounds(50, 20, 400, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();

        // Create the details menu
        JMenu detailsMenu = new JMenu("Details");

        // Create and add menu items
        JMenuItem item2 = new JMenuItem("Add Customer Details");
        item2.addActionListener(this);
        detailsMenu.add(item2);
         JMenuItem item1 = new JMenuItem("Flights Information");
        item1.addActionListener(this);
        detailsMenu.add(item1);
 

        JMenuItem item4 = new JMenuItem("Book Flights");
        item4.addActionListener(this);
        detailsMenu.add(item4);

        JMenuItem item5 = new JMenuItem("Journey Details");
        item5.addActionListener(this);
        detailsMenu.add(item5);

        // Add the details menu to the menu bar
        menubar.add(detailsMenu);

        // Create the Ticket menu
        JMenu ticketMenu = new JMenu("Ticket");
        JMenuItem item7 = new JMenuItem("Boarding Pass");
        item7.addActionListener(this);
        ticketMenu.add(item7);
        
        // Add the ticket menu to the menu bar
        menubar.add(ticketMenu);

        // Set the menu bar for the frame
        setJMenuBar(menubar);
        
        // Set the frame to maximized state
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        // Make the frame visible
        setVisible(true);
    }

    /**
     * Handle action events
     * @param ae ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        // Correctly handle menu item actions
        if(text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if(text.equals("Book Flights")) {
            new BookFlight();
        } else if(text.equals("Flights Information")) {
            new FlightInfo();
        }
        else if(text.equals("Journey Details")) {
            new JourneyDetails();
        } else if(text.equals("Boarding Pass")) {
            new BoardingPass();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
