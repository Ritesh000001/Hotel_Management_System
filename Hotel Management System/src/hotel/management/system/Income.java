package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Income extends JFrame implements ActionListener
{
    JLabel sum;
    JTextField out_from,out_to;
    JButton search,back;
    
   Income()
   {
       setLayout(null);
       setTitle("Income");
       setBounds(120,70,1000,590);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       setResizable(false);
      
       Container c = getContentPane();
       c.setBackground(Color.WHITE);
       
       JLabel text = new JLabel("Check for Income Amount");
       text.setBounds(330,10,360,20);
       text.setFont(new Font("serif",Font.BOLD,25));
       add(text);
       
       JLabel label = new JLabel("Note : Date should be in this format.  For ex. : 03/04/2023 ");
       label.setBounds(35,110,440,20);
       label.setForeground(Color.RED);
       add(label);
       
       JLabel l1 = new JLabel("Search by Date :");
       l1.setBounds(95,75,160,20);
       add(l1);
       
       out_from = new JTextField();
       out_from.setBounds(270,70,200,30);
       add(out_from);
       
       out_to = new JTextField();
       out_to.setBounds(530,70,200,30);
       add(out_to);
       
       JLabel l2 = new JLabel("From");
       l2.setBounds(230,75,40,20);
       add(l2);
       
       JLabel l3 = new JLabel("To");
       l3.setBounds(505,75,70,20);
       add(l3);
       
       search=new JButton("Search");
       search.setBounds(770,70,80,30);
       search.setBackground(Color.BLACK);
       search.setForeground(Color.WHITE);
       search.addActionListener(this);
       add(search);
       
       back = new JButton("Back");
       back.setBounds(420, 510,150, 40);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setFont(new Font("serif",Font.BOLD,25));
       back.addActionListener(this);
       add(back);
            
       JLabel text2 = new JLabel("Total Income within these two dates : ");
       text2.setBounds(300,250,450,50);
       text2.setFont(new Font("serif",Font.BOLD,25));
       add(text2);
       
       sum = new JLabel();
       sum.setBounds(400,320,200,60);
       sum.setFont(new Font("serif",Font.BOLD,25));
       add(sum);

       setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==search)
       {
           String checkout_from=out_from.getText();
           String checkout_to=out_to.getText();
           
          if(checkout_from.equals("") || checkout_to.equals(""))
           {
                JOptionPane.showMessageDialog(null,"Please enter dates in both the fields.");
           }
          else
          {
               try
               {
                String query1 = "Select sum(total_amount) from bills where checkout_time between '"+checkout_from+"' and '"+checkout_to+"'"; 
            
                 Conn conn = new Conn();
                 ResultSet rs = conn.s.executeQuery(query1);
                 
                 while(rs.next())
                {
                    for (int i=1;i<2;i++)
                    {
                      sum.setText(rs.getString(i)+" Rs");
                    }
                  
                }
                 
               }catch(Exception e)
                {
                  e.printStackTrace();
                 }
          
            }
        }
        
       else  if(ae.getSource()==back)
       {
          setVisible(false);
        }
    }
   public static void main(String arg[])
   {
        Income ob = new Income();
    }
}
