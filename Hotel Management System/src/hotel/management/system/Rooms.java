package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener
{
    JTable table;
    JButton back,search;
    JComboBox bedtype;
    JRadioButton ac,nonac;
    
   Rooms()
   {
       setLayout(null);
       setTitle("All Room Details");
       setBounds(180,70,900,590);
      // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setResizable(false);
       
       Container c = getContentPane();
       c.setBackground(Color.WHITE);

       JLabel text = new JLabel("All Rooms Detail");
       text.setBounds(350,10,250,20);
       text.setFont(new Font("serif",Font.BOLD,25));
       add(text);
       
       JLabel lbl1 = new JLabel("Bed Type");
       lbl1.setBounds(50,70,100,20);
       add(lbl1);
       
       bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
       bedtype.setBounds(140,70,150,20);
       bedtype.setBackground(Color.WHITE);
       add(bedtype);

       JLabel lbl2 = new JLabel("Room Type");
       lbl2.setBounds(500,70,100,20);
       add(lbl2);
       
       ac =  new JRadioButton("AC");
       ac.setBounds(620,65,70,30);
       ac.setBackground(Color.WHITE);
       ac.setSelected(true);
       add(ac);
      
       nonac =  new JRadioButton("Non AC");
       nonac.setBounds(690,65,70,30);
       nonac.setBackground(Color.WHITE);
       add(nonac);
      
       ButtonGroup roomtype = new ButtonGroup();
       roomtype.add(ac);
       roomtype.add(nonac);
       
       search = new JButton("Search");
       search.setBounds(380,125,120,25);
       search.setBackground(Color.BLACK);
       search.setForeground(Color.WHITE);
       search.addActionListener(this);
       add(search);
       
       JLabel l1 = new JLabel("Room Number");
       l1.setBounds(20,180,130,18);
       l1.setFont(new Font("serif",Font.BOLD,18));
       add(l1);
       
       JLabel l2 = new JLabel("Availability");
       l2.setBounds(190,180,100,23);
       l2.setFont(new Font("serif",Font.BOLD,18));
       add(l2);
       
       JLabel l3 = new JLabel("Room Type");
       l3.setBounds(330,180,100,23);
       l3.setFont(new Font("serif",Font.BOLD,18));
       add(l3);
       
       JLabel l4 = new JLabel("Bed Type");
       l4.setBounds(490,180,130,23);
       l4.setFont(new Font("serif",Font.BOLD,18));
       add(l4);
       
       JLabel l5 = new JLabel("Price");
       l5.setBounds(650,180,100,23);
       l5.setFont(new Font("serif",Font.BOLD,18));
       add(l5);
       
       JLabel l6 = new JLabel("Cleaning Status");
       l6.setBounds(760,180,130,23);
       l6.setFont(new Font("serif",Font.BOLD,18));
       add(l6);
       
       table = new JTable();
       table.setBounds(0,210,900,340);
       add(table);
       
       try
       {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("Select * from rooms");
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         
         
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       back = new JButton("Back");
       back.setBounds(380,290,120,35);
       back.setFont(new Font("serif",Font.BOLD,18));
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       table.add(back);
     
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
        if(ae.getSource()==search)
       {
            String roomtype = null;
             if(ac.isSelected())
                roomtype = "AC";
             else if(nonac.isSelected())
                roomtype = "Non AC";
       
           try
           {
             String query1 = "Select * from rooms where bed_type='"+bedtype.getSelectedItem()+"' AND room_type ='"+roomtype+"'"; 
           
             Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery(query1);

             table.setModel(DbUtils.resultSetToTableModel(rs));
         
           }catch(Exception e)
            {
             e.printStackTrace();
             }
        }
       
       else if(ae.getSource()==back)
       {
          setVisible(false);
        }
               
    }
   public static void main(String arg[])
   {
      Rooms ob = new Rooms();  
   }
}
   

