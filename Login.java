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
        // Set background and layout
        getContentPane().setBackground(Color.WHITE);  
        setLayout(null);

        // Welcome message
        JLabel welcome = new JLabel("Welcome to Air India!");
        welcome.setFont(new Font("Serif", Font.BOLD, 26));
        welcome.setForeground(new Color(70,130,180));  
        welcome.setBounds(85, 10, 280, 30);
        add(welcome);

        JLabel instruction = new JLabel("Please Login:");
        instruction.setFont(new Font("SansSerif", Font.PLAIN, 18));
        instruction.setForeground(new Color(0x333333));  
        instruction.setBounds(150, 45, 120, 20);
        add(instruction);

        // Username label
        JLabel lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblusername.setBounds(20, 90, 120, 20);
        add(lblusername);

        // Username text field
        tfusername = new JTextField();
        tfusername.setBounds(130, 90, 220, 25);
        tfusername.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(tfusername);

        // Password label
        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblpassword.setBounds(20, 130, 120, 20);
        add(lblpassword);

        // Password field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 130, 220, 25);
        tfpassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(tfpassword);

        // Reset button
        reset = new JButton("RESET");
        reset.setBounds(30, 190, 100, 30);
        reset.setBackground(new Color(70, 130, 180));
        reset.setForeground(Color.WHITE);
        reset.setFocusPainted(false);  // Remove focus border
        reset.setFont(new Font("SansSerif", Font.BOLD, 14));
        reset.addActionListener(this);
        add(reset);

        // Close button
        close = new JButton("CLOSE");
        close.setBounds(150, 190, 100, 30);
        close.setBackground(new Color(70, 130, 180));
        close.setForeground(Color.WHITE);
        close.setFocusPainted(false);
        close.setFont(new Font("SansSerif", Font.BOLD, 14));
        close.addActionListener(this);
        add(close);

        // Submit button
        submit = new JButton("SUBMIT");
        submit.setBounds(270, 190, 100, 30);
        submit.setBackground(new Color(70, 130, 180)); 
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.setFont(new Font("SansSerif", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        // Frame settings
        setSize(420, 300);
        setLocation(600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                    setVisible(true);  // Keep window visible after invalid login
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
