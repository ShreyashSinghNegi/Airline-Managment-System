package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;

    public AddCustomer() {
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 36));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblname.setForeground(Color.BLUE);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblnationality.setForeground(Color.BLUE);
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(200, 130, 150, 25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblaadhar.setForeground(Color.BLUE);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 180, 150, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lbladdress.setForeground(Color.BLUE);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblgender.setForeground(Color.BLUE);
        add(lblgender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        genderGroup.add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        genderGroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblphone.setForeground(Color.BLUE);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 330, 150, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.WHITE);
        save.setForeground(Color.BLUE);
        save.setBounds(200, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = rbmale.isSelected() ? "Male" : "Female";

        try {
            Connect conn = new Connect();
            String query = "INSERT INTO passenger (name, nationality, phone, address, aadhar, gender) VALUES ('" 
                            + name + "', '" + nationality + "', '" + phone + "', '" + address + "', '" + aadhar + "', '" + gender + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Passenger Details Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new AddCustomer();
    }
}
