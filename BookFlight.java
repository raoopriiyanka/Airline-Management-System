package airlinemanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookFlight extends JFrame implements ActionListener {
   JTextField tfaadhar;
   JLabel tfname;
   JLabel tfnationality;
   JLabel tfaddress;
   JLabel labelgender;
   JLabel labelfname;
   JLabel labelfcode;
   JButton bookflight;
   JButton fetchButton;
   JButton flight;
   Choice source;
   Choice destination;
   JDateChooser dcdate;

   public BookFlight() {
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel heading = new JLabel("BOOK FLIGHT");
      heading.setBounds(420, 20, 500, 35);
      heading.setFont(new Font("Tahoma", Font.BOLD, 35));
      heading.setForeground(new Color(70,130,180));
      add(heading);

      JLabel lblaadhar = new JLabel("Aadhar:");
      lblaadhar.setBounds(60, 80, 150, 25);
      lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblaadhar);

      tfaadhar = new JTextField();
      tfaadhar.setBounds(220, 80, 150, 25);
      add(tfaadhar);

      fetchButton = new JButton("Fetch User");
      fetchButton.setBackground(new Color(70,130,180));
      fetchButton.setForeground(Color.WHITE);
      fetchButton.setBounds(380, 80, 120, 25);
      fetchButton.addActionListener(this);
      add(fetchButton);

      JLabel lblname = new JLabel("Name:");
      lblname.setBounds(60, 130, 150, 25);
      lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblname);

      tfname = new JLabel();
      tfname.setBounds(220, 130, 150, 25);
      add(tfname);

      JLabel lblnationality = new JLabel("Nationality:");
      lblnationality.setBounds(60, 180, 150, 25);
      lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblnationality);

      tfnationality = new JLabel();
      tfnationality.setBounds(220, 180, 150, 25);
      add(tfnationality);

      JLabel lbladdress = new JLabel("Address:");
      lbladdress.setBounds(60, 230, 150, 25);
      lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lbladdress);

      tfaddress = new JLabel();
      tfaddress.setBounds(220, 230, 150, 25);
      add(tfaddress);

      JLabel lblgender = new JLabel("Gender:");
      lblgender.setBounds(60, 280, 150, 25);
      lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblgender);

      labelgender = new JLabel();
      labelgender.setBounds(220, 280, 150, 25);
      add(labelgender);

      JLabel lblsource = new JLabel("Source:");
      lblsource.setBounds(60, 330, 150, 25);
      lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblsource);

      source = new Choice();
      source.setBounds(220, 330, 150, 25);
      add(source);

      JLabel lbldest = new JLabel("Destination:");
      lbldest.setBounds(60, 380, 150, 25);
      lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lbldest);

      destination = new Choice();
      destination.setBounds(220, 380, 150, 25);
      add(destination);

      try {
         Conn c = new Conn();
         String query = "select * from flight";
         ResultSet rs = c.s.executeQuery(query);

         while (rs.next()) {
            source.add(rs.getString("source"));
            destination.add(rs.getString("destination"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      flight = new JButton("Fetch Flights");
      flight.setBackground(new Color(70,130,180));
      flight.setForeground(Color.WHITE);
      flight.setBounds(380, 380, 120, 25);
      flight.addActionListener(this);
      add(flight);

      JLabel lblfname = new JLabel("Flight Name:");
      lblfname.setBounds(60, 430, 150, 25);
      lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblfname);

      labelfname = new JLabel();
      labelfname.setBounds(220, 430, 150, 25);
      add(labelfname);

      JLabel lblfcode = new JLabel("Flight Code:");
      lblfcode.setBounds(60, 480, 150, 25);
      lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lblfcode);

      labelfcode = new JLabel();
      labelfcode.setBounds(220, 480, 150, 25);
      add(labelfcode);

      JLabel lbldate = new JLabel("Date of Travel:");
      lbldate.setBounds(60, 530, 150, 25);
      lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(lbldate);

      dcdate = new JDateChooser();
      dcdate.setBounds(220, 530, 150, 25);
      add(dcdate);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
      Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
      ImageIcon image = new ImageIcon(i2);
      JLabel lblimage = new JLabel(image);
      lblimage.setBounds(550, 80, 500, 410);
      add(lblimage);

      bookflight = new JButton("Book Flight");
      bookflight.setBackground(new Color(70,130,180));
      bookflight.setForeground(Color.WHITE);
      bookflight.setBounds(220, 580, 150, 25);
      bookflight.addActionListener(this);
      add(bookflight);

      setSize(1100, 700);
      setLocation(200, 70);
      setVisible(true);
   }

   // Method to show the PNR dialog
   private void showPNRDialog(String pnr) {
      JOptionPane.showMessageDialog(this, "Your PNR number is: " + pnr, "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == fetchButton) {
         String aadhar = tfaadhar.getText();

         try {
            Conn conn = new Conn();
            String query = "select * from passenger where aadhar = '" + aadhar + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
               tfname.setText(rs.getString("name"));
               tfnationality.setText(rs.getString("nationality"));
               tfaddress.setText(rs.getString("address"));
               labelgender.setText(rs.getString("gender"));
            } else {
               JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      } else if (ae.getSource() == flight) {
         String src = source.getSelectedItem();
         String dest = destination.getSelectedItem();

         try {
            Conn conn = new Conn();
            String query = "select * from flight where source = '" + src + "' and destination = '" + dest + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
               labelfname.setText(rs.getString("f_name"));
               labelfcode.setText(rs.getString("f_code"));
            } else {
               JOptionPane.showMessageDialog(null, "No Flights Found");
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      } else if (ae.getSource() == bookflight) {
         Random random = new Random();
         String aadhar = tfaadhar.getText();
         String name = tfname.getText();
         String nationality = tfnationality.getText();
         String flightname = labelfname.getText();
         String flightcode = labelfcode.getText();
         String src = source.getSelectedItem();
         String dest = destination.getSelectedItem();
         String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
         String pnr = "PNR-" + random.nextInt(1000000); // Generate PNR

         try {
            Conn conn = new Conn();
            String query = "insert into reservation values('" + pnr + "', 'TIC-" + random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" + src + "', '" + dest + "', '" + ddate + "')";
            conn.s.executeUpdate(query);
            showPNRDialog(pnr); // Show PNR after booking
            setVisible(false);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   public static void main(String[] args) {
      new BookFlight();
   }
}
