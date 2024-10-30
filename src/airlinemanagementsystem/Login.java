/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton submit, reset, close;
    JTextField tfusername;
    JPasswordField tfpassword;

    public Login() {
        setTitle("Login");
        setLayout(null);
        getContentPane().setBackground(Color.PINK);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);

        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(140, 160, 120, 20);
        close.addActionListener(this);
        add(close);

        setSize(600, 250);
        setLocation(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            
            String username = tfusername.getText();
            String password = tfpassword.getText();
            try {
                Connect c = new Connect();
                String query = "select * from login where username = '" +username+"' and password ='"+password+"'  ";
                
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next()) {
                   new Home();
               } else {
                   JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                   setVisible(false); 
                           
               }
            } catch(HeadlessException | SQLException e)
            {
            }
            // Handle lo gin submission here
        } else if (ae.getSource() == close) {
            dispose();
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
