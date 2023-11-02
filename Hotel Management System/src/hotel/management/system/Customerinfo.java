package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener
{
    JTextField name;
    JTable table;
    JButton search,back;
    
   Customerinfo()
   {
       setLayout(null);
       setTitle("Customerinfo");
       setBounds(180,70,900,590);
       //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setResizable(false);
       
       Container c = getContentPane();
       c.setBackground(Color.WHITE);
       
       JLabel text = new JLabel("All Customers Informations");
       text.setBounds(310,10,310,20);
       text.setFont(new Font("serif",Font.BOLD,25));
       add(text);
       
       JLabel lable = new JLabel("Search by Customer's Name");
       lable.setBounds(170,75,170,20);
       add(lable);
       
       name = new JTextField();
       name.setBounds(350,70,200,30);
       add(name);
       
       JLabel l1 = new JLabel("Customer Id");
       l1.setBounds(2,150,100,18);
       l1.setFont(new Font("serif",Font.BOLD,18));
       add(l1);
       
       JLabel l2 = new JLabel("Id Number");
       l2.setBounds(110,150,100,18);
       l2.setFont(new Font("serif",Font.BOLD,18));
       add(l2);
       
       JLabel l3 = new JLabel("Name");
       l3.setBounds(230,150,100,18);
       l3.setFont(new Font("serif",Font.BOLD,18));
       add(l3);
       
       JLabel l4 = new JLabel("Gender");
       l4.setBounds(320,150,100,18);
       l4.setFont(new Font("serif",Font.BOLD,18));
       add(l4);
       
       JLabel l5 = new JLabel("Mobile No.");
       l5.setBounds(410,150,100,18);
       l5.setFont(new Font("serif",Font.BOLD,18));
       add(l5);
       
       JLabel l6 = new JLabel("Country");
       l6.setBounds(520,150,100,20);
       l6.setFont(new Font("serif",Font.BOLD,18));
       add(l6);
       
       JLabel l7 = new JLabel("Room No.");
       l7.setBounds(605,150,100,18);
       l7.setFont(new Font("serif",Font.BOLD,18));
       add(l7);
       
       JLabel l8 = new JLabel("Checkin Time");
       l8.setBounds(695,150,110,18);
       l8.setFont(new Font("serif",Font.BOLD,18));
       add(l8);
       
       JLabel l9 = new JLabel("Deposite");
       l9.setBounds(815,150,100,18);
       l9.setFont(new Font("serif",Font.BOLD,18));
       add(l9);
       
       table = new JTable();
       table.setBounds(0,170,900,330);
       add(table);
       
       try
       {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("Select * from customers");
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         
         
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       search=new JButton("Search");
       search.setBounds(570,70,80,30);
       search.setBackground(Color.BLACK);
       search.setForeground(Color.WHITE);
       search.addActionListener(this);
       add(search);
       
       back = new JButton("Back");
       back.setBounds(360, 510,150, 40);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setFont(new Font("serif",Font.BOLD,25));
       back.addActionListener(this);
       add(back);
         
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==search)
       {
          String cname=name.getText();
          
          if(cname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter customer's name.");
            }
          else
           {
             try
             {
            
               String query1 = "Select * from customers where name ='"+name.getText()+"'"; 
            
               Conn conn = new Conn();
               ResultSet rs = conn.s.executeQuery(query1);

               table.setModel(DbUtils.resultSetToTableModel(rs));
         
             }catch(Exception e)
              {
                e.printStackTrace();
              }
            }
        }
        
       if(ae.getSource()==back)
       {
          setVisible(false);
          new Reception();
        }
    }
   public static void main(String arg[])
   {
      Customerinfo ob = new Customerinfo();  
   }
}
