package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

   JTable table;
   JScrollPane jsp;

   public FlightInfo() {
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);  // Using no layout manager for manual positioning

      // Heading Label
      JLabel heading = new JLabel("FLIGHT DETAILS");
      heading.setFont(new Font("Tahoma", Font.BOLD, 24));
      heading.setForeground(new Color(70,130,180));
      heading.setBounds(300, 20, 230, 30);
      add(heading);

      // Table for flight data
      table = new JTable();
      table.setBorder(new LineBorder(new Color(0, 0, 0)));
      table.setSelectionBackground(new Color(255, 223, 186));  //color change after hover

      // Scroll Pane for the table
      jsp = new JScrollPane(table);
      jsp.setBounds(50, 70, 700, 300);  
      add(jsp);

      // Load flight data initially
      loadFlightData();

      
      JLabel message = new JLabel("Happy Journey! Book your tickets now!");
      message.setFont(new Font("Tahoma", Font.ITALIC, 16));
      message.setBounds(250, 400, 300, 30);
      message.setForeground(new Color(64, 64, 64));
      add(message);

      // Frame properties
      setSize(800, 500);
      setLocation(400, 200);
      setVisible(true);
   }

   // Method to load flight data into the table
   private void loadFlightData() {
      try {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");
         table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception e) {
         e.printStackTrace();
         JOptionPane.showMessageDialog(null, "Error fetching flight data.");
      }
   }

   public static void main(String[] args) {
      new FlightInfo();
   }
}
