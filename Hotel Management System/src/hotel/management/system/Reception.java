package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener
{ 
     JButton  searchrooms,checkin,checkout,customerinfo,bill_details;
    
   Reception()
    {
        setLayout(null);
        setTitle("Reception");
        setBounds(180,70,900,590);
        setResizable(false);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
      
        Container con = getContentPane();
        con.setBackground(Color.WHITE);  
        
        JLabel l1 = new JLabel("Reception");
        l1.setBounds(115,30,120,40);
        l1.setFont(new Font("serif",Font.BOLD,25));
        add(l1);
        
        searchrooms= new JButton("Search Rooms");
        searchrooms.setBounds(35,100,250,35);
        searchrooms.setBackground(Color.BLACK);
        searchrooms.setForeground(Color.WHITE);
        searchrooms.setFont(new Font("Arial",Font.PLAIN,20));
        searchrooms.addActionListener(this);
        add(searchrooms);
      
        checkin = new JButton("Check in");
        checkin.setBounds(35,190,250,35);
        checkin.setBackground(Color.BLACK);
        checkin.setForeground(Color.WHITE);
        checkin.setFont(new Font("Arial",Font.PLAIN,20));
        checkin.addActionListener(this);
        add(checkin);
      
        checkout= new JButton("Check Out");
        checkout.setBounds(35,280,250,35);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Arial",Font.PLAIN,20));
        checkout.addActionListener(this);
        add(checkout);
      
        customerinfo = new JButton("Customer's Information");
        customerinfo.setBounds(35,380,250,35);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.setFont(new Font("Arial",Font.PLAIN,20));
        customerinfo.addActionListener(this); 
        add(customerinfo);
      
        bill_details = new JButton("Bill Details");
        bill_details.setBounds(35,470,250,35);
        bill_details.setBackground(Color.BLACK);
        bill_details.setForeground(Color.WHITE);
        bill_details.setFont(new Font("Arial",Font.PLAIN,20));
        bill_details.addActionListener(this);
        add(bill_details);
      
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/6.jpg"));
        Image i2 = image.getImage().getScaledInstance(550, 530, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(330,10,550,530);
        add( label); 
     
        setVisible(true);
    }   
    public void actionPerformed(ActionEvent e)
    { 
       if(e.getSource()==searchrooms)
       {
          setVisible(false);
          new Searchroom();  
       }
        
       else if(e.getSource()==checkin)
       {
          setVisible(false);
          new Checkin(); 
       }
       
       else if(e.getSource()==checkout)
       {
          setVisible(false);
          new Checkout();
       }
       
       else if(e.getSource()==customerinfo)
       {
          setVisible(false);
          new Customerinfo();
       }
       
        else if(e.getSource()==bill_details)
       {
          setVisible(false);
          new BillDetails();
       }
    }        

   public static void main(String arg[])
    {
        Reception ob=new Reception();
    }
}
