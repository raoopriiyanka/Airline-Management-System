package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
   JTable table;
   JTextField pnr;
   JButton show;

   public JourneyDetails() {
      this.getContentPane().setBackground(Color.WHITE);
      this.setLayout(null);
      
      // Adding a heading
      JLabel heading = new JLabel("JOURNEY DETAILS");
      heading.setFont(new Font("Tahoma", Font.BOLD, 25)); 
      heading.setForeground(new Color(70, 130, 180)); 
      heading.setBounds(290, 20, 300, 30);
      this.add(heading);
      
      JLabel lblpnr = new JLabel("PNR Details:");
      lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblpnr.setBounds(200, 70, 100, 25); 
      this.add(lblpnr);
      
      this.pnr = new JTextField();
      this.pnr.setBounds(300, 70, 120, 25); 
      this.add(this.pnr);
      
      this.show = new JButton("Show Details");
      this.show.setBackground(new Color(70,130,180));
      this.show.setForeground(Color.WHITE);
      this.show.setBounds(430, 70, 120, 25);
      this.show.addActionListener(this);
      this.add(this.show);
      
      this.table = new JTable();
      this.table.setFont(new Font("Tahoma", Font.PLAIN, 10)); 
      this.table.setRowHeight(15); // Set row height
      JScrollPane jsp = new JScrollPane(this.table);
      jsp.setBounds(40, 110, 760, 300); 
      jsp.setBackground(Color.WHITE);
      this.add(jsp);
      
      this.setSize(850, 550); 
      this.setLocationRelativeTo(null); // Center JFrame on the screen
      this.setVisible(true);
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
   }

   public void actionPerformed(ActionEvent ae) {
      try {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '" + this.pnr.getText() + "'");
         if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog((Component)null, "No Information Found");
            return;
         }

         this.table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new JourneyDetails();
   }
}
