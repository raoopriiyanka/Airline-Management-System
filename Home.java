package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);
        
        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1700, 800);
        add(image);
        
        // Heading
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU!");
        heading.setBounds(570, 20, 800, 100);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        image.add(heading);
        
        // Menu Bar
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(new Color(34, 34, 34)); // Darker background color for menu bar
        setJMenuBar(menubar);
        
        // Add menu items
        addMenuItem(menubar, "Flight Details");
        addMenuItem(menubar, "Add Customer Details");
        
        addMenuItem(menubar, "Book Flight");
//        addMenuItem(menubar, "Reservation Details");
        addMenuItem(menubar, "Journey Details");
        addMenuItem(menubar, "Cancel Ticket");
        addMenuItem(menubar, "Boarding Pass");

        // Frame Settings
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(600, 250);
        setVisible(true);
    }

    // Method to add menu items with action listener
    private void addMenuItem(JMenuBar menubar, String itemName) {
        JMenuItem menuItem = new JMenuItem(itemName);
        menuItem.setFont(new Font("Tahoma", Font.BOLD, 16)); 
        menuItem.setBackground(new Color(50, 150, 250));
        menuItem.setForeground(Color.WHITE); 
        menuItem.setBorderPainted(false); 
        menuItem.setFocusPainted(false); 
        menuItem.addActionListener(this);
        
        // Set custom background for the menu item
        menuItem.setOpaque(true);
        menuItem.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); 
        menubar.add(menuItem);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        }
        else if (text.equals("Book Flight")) {
            new BookFlight();
        }
        else if (text.equals("Journey Details")) {
            new JourneyDetails();
        }
        else if(text.equals("Cancel Ticket")) {
            new Cancel();
        }
        else if(text.equals("Boarding Pass")) {
            new BoardingPass();
        }
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
