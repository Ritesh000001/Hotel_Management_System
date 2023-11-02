package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Employeeinfo extends JFrame implements ActionListener
{
    Choice cemp_id;
    JTable table;
    JButton search,print,back;
    
   Employeeinfo()
   {
       setLayout(null);
       setTitle("Employees Informations");
       setBounds(120,70,1000,590);
       //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setResizable(false);
       
       Container c = getContentPane();
       c.setBackground(Color.WHITE);
       
       JLabel text = new JLabel("All Employees Informations");
       text.setBounds(340,5,310,35);
       text.setFont(new Font("serif",Font.BOLD,25));
       add(text);
       
       JLabel l1 = new JLabel("Search by Employee Id");
       l1.setBounds(230,75,150,25);
       add(l1);
       
       cemp_id = new Choice();
       
        try
        {
           Conn con = new Conn();
           String query ="Select * from employees";
           ResultSet rs = con.s.executeQuery(query);
           while(rs.next())
            {
              cemp_id.add(rs.getString("employee_id"));  
            }
        }catch(Exception e1)
         {
            e1.printStackTrace();
         }
       cemp_id.setBounds(400,75,200,30);
       cemp_id.setBackground(Color.WHITE);
       add(cemp_id);
       
       search=new JButton("Search");
       search.setBounds(650,70,80,30);
       search.setBackground(Color.BLACK);
       search.setForeground(Color.WHITE);
       search.addActionListener(this);
       add(search);
       
       print =new JButton("Print");
       print.setBounds(750,70,80,30);
       print.setBackground(Color.BLACK);
       print.setForeground(Color.WHITE);
       print.addActionListener(this);
       add(print);
       
       table = new JTable();
       
       try
       {
         Conn conn = new Conn();
         ResultSet rs = conn.s.executeQuery("Select * from employees");
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       JScrollPane jsp = new JScrollPane(table);
       jsp.setBounds(10,150,970,350);
       add(jsp);
    
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
          String empid = cemp_id.getSelectedItem();
          String query = "Select * from employees where employee_id = '"+empid+"'";
            
          try
           {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(query);
         
            table.setModel(DbUtils.resultSetToTableModel(rs));
         
         
           }catch(Exception e)
           {
              e.printStackTrace();
            }
        }
      
      if(ae.getSource()==print)
      {
          try
          {
           table.print();
          }catch(Exception e)
           {
             e.printStackTrace();
            } 
      }
      
      if(ae.getSource()==back)
      {
        setVisible(false);
      }
   }
   public static void main(String arg[])
   {
      Employeeinfo ob = new Employeeinfo();  
   }
}

