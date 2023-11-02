package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Checkout extends JFrame implements ActionListener
{
    JTextField tfidno,tfname,tfgender,tfcountry,tfmobile,tfcheckintime,tfprice,tfdays,tftotal,tfdeposite,tfpending;
    JButton search,back,checkout;
    JLabel checkouttime;
    Choice croomno;
    
    Checkout()
    {
       setLayout(null);
       setTitle("Check Out");
       setBounds(180,70,900,590);
       //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setResizable(false);
       
       Container con = getContentPane();
       con.setBackground(Color.WHITE);
       
       JLabel l1 = new JLabel("Check Out");
       l1.setBounds(390,0,180,40);
       l1.setFont(new Font("serif",Font.BOLD,20));
       add(l1);
       
       JLabel l2 = new JLabel("Room Number");
       l2.setBounds(250,50,90,40);
       add(l2);
       
       croomno = new Choice();
      
        try
        {
           Conn c = new Conn();
           String query ="Select * from rooms where availability = 'Occupied'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next())
            {
              croomno.add(rs.getString("room_number"));  
            }
        }catch(Exception e1)
         {
            e1.printStackTrace();
         }
       croomno.setBounds(360,55,150,30);
       croomno.setBackground(Color.WHITE);
       add(croomno);
       
       search=new JButton("Search");
       search.setBounds(550,55,80,30);
       search.setBackground(Color.BLACK);
       search.setForeground(Color.WHITE);
       search.addActionListener(this);
       add(search);
        
       JLabel l3 = new JLabel("ID Number");
       l3.setBounds(40,105,70,40);
       add(l3);
      
       tfidno = new JTextField();
       tfidno.setBounds(170,110,200,30);
       add(tfidno);
      
       JLabel l4 = new JLabel("Name");
       l4.setBounds(40,160,70,40);
       add(l4);
      
       tfname = new JTextField();
       tfname.setBounds(170,165,200,30);
       add(tfname);
      
       JLabel l5 = new JLabel("Gender");
       l5.setBounds(40,210,70,40);
       add(l5);
      
       tfgender = new JTextField();
       tfgender.setBounds(170,215,200,30);
       add(tfgender);
      
      
       JLabel l6 = new JLabel("Country");
       l6.setBounds(40,260,70,40);
       add(l6);
      
       tfcountry = new JTextField();
       tfcountry.setBounds(170,265,200,30);
       add(tfcountry);
      
       JLabel l8 = new JLabel("Mobile Number");
       l8.setBounds(40,310,130,40);
       add(l8);
       
       tfmobile = new JTextField();
       tfmobile.setBounds(170,315,200,30);
       add(tfmobile);
       
       JLabel l9 = new JLabel("Check in Time");
       l9.setBounds(40,360,130,40);
       add(l9);
       
       tfcheckintime = new JTextField();
       tfcheckintime.setBounds(170,360,200,30);
       add(tfcheckintime);
       
       JLabel l10 = new JLabel("Price per day");
       l10.setBounds(500,105,80,40);
       add(l10);
       
       tfprice = new JTextField();
       tfprice.setBounds(650,110,200,30);
       add(tfprice);
      
       JLabel l11 = new JLabel("Total no. of days");
       l11.setBounds(500,160,95,40);
       add(l11);
       
       tfdays= new JTextField();
       tfdays.setBounds(650,165,200,30);
       add(tfdays);
      
       JLabel l12 = new JLabel("Total Amount");
       l12.setBounds(500,210,80,40);
       add(l12);
       
       tftotal = new JTextField();
       tftotal.setBounds(650,215,200,30);
       add(tftotal);
      
       JLabel l13 = new JLabel("Deposite");
       l13.setBounds(500,260,70,40);
       add(l13);
       
       tfdeposite = new JTextField();
       tfdeposite.setBounds(650,265,200,30);
       add(tfdeposite);
      
       JLabel l14 = new JLabel("Pending Amount");
       l14.setBounds(500,310,100,40);
       add(l14);
     
       tfpending = new JTextField();
       tfpending.setBounds(650,315,200,30);
       add(tfpending);
       
       JLabel l15 = new JLabel("Check Out Time");
       l15.setBounds(500,360,100,40);
       add(l15);
       
       SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
       Date date = new Date();
       checkouttime = new JLabel(""+obj.format(date));
       checkouttime.setBounds(650,360,180,40);
       add(checkouttime);

       back = new JButton("Back");
       back.setBounds(280,480,120,35);
       back.setFont(new Font("serif",Font.BOLD,18));
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
       checkout = new JButton("Check Out");
       checkout.setBounds(500,480,120,35);
       checkout.setFont(new Font("serif",Font.BOLD,18));
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
       add(checkout);
     
       setVisible(true);
       
    }
    
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==search)
       {
           String roomno = croomno.getSelectedItem();
           String query = "Select * from customers where room_allocated = '"+roomno+"'";
           
           try
           {
               Conn c = new Conn();
               ResultSet rs =  c.s.executeQuery(query);
               while(rs.next())
                {
                  tfidno.setText(rs.getString("id_number"));
                  tfname.setText(rs.getString("name"));
                  tfgender.setText(rs.getString("gender"));
                  tfcountry.setText(rs.getString("country"));
                  tfmobile.setText(rs.getString("mobile_no"));
                  tfcheckintime.setText(rs.getString("checkin_time"));
                  tfdeposite.setText(rs.getString("deposite"));
                }
               
               ResultSet rs2 =  c.s.executeQuery("Select * from rooms where room_number = '"+roomno+"'");
               while(rs2.next())
                {
                  tfprice.setText(rs2.getString("price"));
                  
                  String price = rs2.getString("price");
                  
                  String in,out;
                  out=checkouttime.getText();     
                  in=tfcheckintime.getText();
                  SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
                  Date d1 = obj.parse(out);
                  Date d2 = obj.parse(in);
                      
                  long diff = d1.getTime()-d2.getTime();
                  int days = (int)diff/(1000*60*60*24);
                  if(days==0)
                    days=1;
                      
                  tfdays.setText(""+days);
                  
                  int total = Integer.parseInt(tfprice.getText())*Integer.parseInt(tfdays.getText());
                  
                  tftotal.setText(""+total);
                  
                  int pending =total-Integer.parseInt(tfdeposite.getText());
                  
                  tfpending.setText(""+pending);
                }
               
            }catch(Exception e)
             {
               e.printStackTrace();
             }
        }
       
       else if(ae.getSource()==checkout)
       {
            String id = tfidno.getText();
            String name = tfname.getText();
            String gender = tfgender.getText();
            String country =tfcountry .getText();
            String mobile = tfmobile.getText();
            String checkin = tfcheckintime.getText();
            String checkout = checkouttime.getText();
            String price = tfprice.getText();
            String days = tfdays.getText();
            String amount = tftotal.getText();
            
           try
           {
              String room = croomno.getSelectedItem();
               
              String query = "delete from customers where room_allocated='"+room+"'";
              String query2 = "update rooms set availability='Available' where room_number='"+room+"'";
              String query3 = "insert into bills (customer_id_no,name,gender,mobile_no,country,room_no,checkin_time,checkout_time,price,no_of_days,total_amount) values('"+id+"','"+name+"','"+gender+"','"+mobile+"','"+country+"','"+room+"','"+checkin+"','"+checkout+"','"+price+"','"+days+"','"+amount+"')";          
              
              Conn conn = new Conn();
              conn.s.executeUpdate(query);
              conn.s.executeUpdate(query2);
              conn.s.executeUpdate(query3);

              JOptionPane.showMessageDialog(null,"CheckOut Done Successfully");
            
              setVisible(false);
              new Reception();
             
           } catch(Exception e)
           {
              e.printStackTrace();
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
     Checkout ob = new Checkout();
   }
}
