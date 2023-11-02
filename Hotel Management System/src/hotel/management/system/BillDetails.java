package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.*;

public class BillDetails extends JFrame implements ActionListener
{
     JTextField checkout;
     JButton search,back;
     JTable table;
     static String id,name,gender,mobile,country,room, r_type,b_type,indate,outdate,price,days,total;
    
     BillDetails()
    {
       setLayout(null);
       setTitle("Bill Details");
       setBounds(120,70,1000,590);
       //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setResizable(false);
       
       JLabel text = new JLabel("All Customers Bill Details");
       text.setBounds(310,10,290,20);
       text.setFont(new Font("serif",Font.BOLD,25));
       add(text);
       
       JLabel label = new JLabel("Note : Double click on the table row to generate bill.");
       label.setBounds(35,110,310,20);
       label.setForeground(Color.RED);
       add(label);
       
       JLabel label1 = new JLabel("Note : Date should be in this format.  For ex. :  03/04/2023 ");
       label1.setBounds(530,110,440,20);
       label1.setForeground(Color.RED);
       add(label1);
       
       
       JLabel l1 = new JLabel("Search by CheckOut Date");
       l1.setBounds(180,75,150,20);
       add(l1);
       
       checkout = new JTextField();
       checkout.setBounds(350,70,200,30);
       add(checkout);
       
       JLabel l2 = new JLabel("Bill Id");
       l2.setBounds(35,150,40,20);
       add(l2);
       
       JLabel l3 = new JLabel("Customer Id");
       l3.setBounds(95,150,70,20);
       add(l3);
       
       JLabel l4 = new JLabel("Name");
       l4.setBounds(195,150,50,20);
       add(l4);
       
       JLabel l5 = new JLabel("Gender");
       l5.setBounds(270,150,80,20);
       add(l5);
       
       JLabel l6 = new JLabel("Mobile No.");
       l6.setBounds(340,150,80,20);
       add(l6);
       
       JLabel l7 = new JLabel("Nationality");
       l7.setBounds(425,150,80,20);
       add(l7);
       
       JLabel l8 = new JLabel("Room No.");
       l8.setBounds(505,150,80,20);
       add(l8);
       
       JLabel l9 = new JLabel("Ckeckin Date");
       l9.setBounds(575,150,80,20);
       add(l9);
       
       JLabel l10 = new JLabel("CheckOut Date");
       l10.setBounds(655,150,85,20);
       add(l10);
       
       JLabel l11 = new JLabel("Price");
       l11.setBounds(765,150,80,20);
       add(l11);
       
       JLabel l12 = new JLabel("No. of days");
       l12.setBounds(825,150,80,20);
       add(l12);
       
       JLabel l13 = new JLabel("Total Amount");
       l13.setBounds(900,150,80,20);
       add(l13);
      
       
       
       
       search=new JButton("Search");
       search.setBounds(570,70,80,30);
       search.setBackground(Color.BLACK);
       search.setForeground(Color.WHITE);
       search.addActionListener(this);
       add(search);
       
       table = new JTable();
       table.setBounds(10,170,970,330);
       add(table);
       
       try
       {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("Select * from bills");
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         
         
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       table.addMouseListener(new MouseAdapter()
       { 
           public void mouseClicked(MouseEvent e)
           {
             if(e.getClickCount()==2)
             {
                 DefaultTableModel model=(DefaultTableModel)table.getModel();
                 
                  id=(String)model.getValueAt(table.getSelectedRow(),1);
                  name=(String)model.getValueAt(table.getSelectedRow(),2);
                  gender=(String)model.getValueAt(table.getSelectedRow(),3);
                  mobile=(String)model.getValueAt(table.getSelectedRow(),4);
                  country=(String)model.getValueAt(table.getSelectedRow(),5);
                  room=(String)model.getValueAt(table.getSelectedRow(),6);
                  indate=(String)model.getValueAt(table.getSelectedRow(),7);
                  outdate=(String)model.getValueAt(table.getSelectedRow(),8);
                  price=(String)model.getValueAt(table.getSelectedRow(),9);
                  days=(String)model.getValueAt(table.getSelectedRow(),10);
                  total=(String)model.getValueAt(table.getSelectedRow(),11);
                  
                  
                  try
                   {
                   String query = "Select * from rooms where room_number ='"+room+"'";

                   Conn c = new Conn();
                   ResultSet rs =  c.s.executeQuery(query);
                   while(rs.next())
                    {
                      r_type = rs.getString("room_type");
                      b_type =rs.getString("bed_type");
                 
                     }
               
                    }catch(Exception e1)
                     {
                       e1.printStackTrace();
                     }  
                  
                  new BillPrint();
             }
           }
           
        });
       
       back = new JButton("Back");
       back.setBounds(420, 510,150, 40);
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
           String out_date=checkout.getText();
          
          if(out_date.equals(""))
           {
                JOptionPane.showMessageDialog(null,"Please enter checkout date.");
           }
          else
          {
              try
              {
            
                 String query1 = "Select * from bills where checkout_time ='"+checkout.getText()+"'"; 
            
                 Conn conn = new Conn();
                 ResultSet rs = conn.s.executeQuery(query1);

                 table.setModel(DbUtils.resultSetToTableModel(rs));
         
               }catch(Exception e)
                {
                  e.printStackTrace();
                }
            }
        }
        
       else if(ae.getSource()==back)
       {
          setVisible(false);
          new Reception();
        }
        
    }
   public static void main(String arg[])
    {
       BillDetails ob = new BillDetails(); 
    }

}
