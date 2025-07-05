package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfnationality, tfaadhar, tfaddress, tfphone;
    JRadioButton bmale, bfemale, bother;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS:");
        heading.setBounds(280, 5, 500, 45);
        heading.setForeground(new Color(70, 130, 180)); // Steel Blue color
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        // Customer Name
        createLabel("Customer Name:", 50, 65);
        tfname = createTextField(210, 65);

        // Nationality
        createLabel("Nationality:", 50, 120);
        tfnationality = createTextField(210, 120);

        // Aadhar Number
        createLabel("Aadhar Number:", 50, 175);
        tfaadhar = createTextField(210, 175);

        // Address
        createLabel("Address:", 70, 230);
        tfaddress = createTextField(210, 230);

        // Gender
        createLabel("Gender:", 70, 285);
        ButtonGroup gendergroup = new ButtonGroup();
        bmale = createRadioButton("MALE", 210, 285);
        bfemale = createRadioButton("FEMALE", 210, 315); 
        bother = createRadioButton("OTHER", 210, 345); 
        gendergroup.add(bmale);
        gendergroup.add(bfemale);
        gendergroup.add(bother);

        // Contact Number
        createLabel("Contact Number:", 70, 400);
        tfphone = createTextField(210, 400);

        // Save Button
        JButton jsave = new JButton("SAVE DETAILS");
        styleButton(jsave, 150, 470);
        jsave.addActionListener(this);
        add(jsave);

        // Customer Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(520, 120, 250, 400);
        add(lblimage);

        // Frame settings
        setSize(900, 700);
        setLocation(300, 70);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 25);
        label.setForeground(new Color(50, 50, 50)); // Darker color for text
        label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(label);
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 250, 25);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 130, 180), 2), // Outer border
            BorderFactory.createEmptyBorder(5, 5, 5, 5))); 
        textField.setBackground(new Color(245, 245, 245)); 
        add(textField);
        return textField;
    }

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 100, 25);
        radioButton.setForeground(new Color(50, 50, 50));
        radioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(radioButton);
        return radioButton;
    }

    private void styleButton(JButton button, int x, int y) {
        button.setBounds(x, y, 180, 40);
        button.setBackground(new Color(70, 130, 180)); 
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 2)); 
        button.setFocusPainted(false); // No focus rectangle
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor
        add(button);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (bmale.isSelected()) {
            gender = "MALE";
        } else if (bfemale.isSelected()) {
            gender = "FEMALE";
        } else {
            gender = "OTHER";
        }
        try {
            Conn conn = new Conn();
            String query = "INSERT INTO passenger VALUES('" + name + "','" + nationality + "','" + address + "','" + phone + "','" + aadhar + "','" + gender + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully.");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
