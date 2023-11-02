
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener
{
    JTextField tfroomno,tfprice;
    JComboBox cbavailable,cbtype,cbclean;  
    JRadioButton ac,nonac;
    JButton  addroom,back;
    
     AddRooms()
   {
      setLayout(null);
      setTitle("Add Rooms");
      setBounds(180,70,900,550);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);

      JLabel l1 = new JLabel("Add Rooms");
      l1.setBounds(125,20,100,40);
      l1.setFont(new Font("serif",Font.BOLD,20));
      add(l1);
      
      JLabel l2 = new JLabel("Room No.");
      l2.setBounds(30,95,70,40);
      add(l2);
      
      tfroomno = new JTextField();
      tfroomno.setBounds(120,100,200,30);
      add(tfroomno);
      
      
      JLabel l4 = new JLabel("Availability");
      l4.setBounds(30,155,70,40);
      add(l4);
      
      String str[] = {"Available","Occuppied"};
      cbavailable = new JComboBox(str);
      cbavailable.setBounds(120,160,200,30);
      cbavailable.setBackground(Color.WHITE);
      add(cbavailable);
      
      JLabel l5 = new JLabel("Room Type");
      l5.setBounds(30,200,70,40);
      add(l5);
      
      ac =  new JRadioButton("AC");
      ac.setBounds(120,205,70,30);
      ac.setSelected(true);
      add(ac);
      
      nonac =  new JRadioButton("Non AC");
      nonac.setBounds(190,205,70,30);
      add(nonac);
      
      ButtonGroup roomtype = new ButtonGroup();
      roomtype.add(ac);
      roomtype.add(nonac);
      
      JLabel l6 = new JLabel("Bed Type");
      l6.setBounds(30,245,70,40);
      add(l6);
      
      String ar[] = {"Single Bed","Double Bed"};
      cbtype = new JComboBox(ar);
      cbtype.setBounds(120,250,200,30);
      cbtype.setBackground(Color.WHITE);
      add(cbtype);
     
      JLabel l7 = new JLabel("Price");
      l7.setBounds(30,295,70,40);
      add(l7);
     
      tfprice = new JTextField();
      tfprice.setBounds(120,300,200,30);
      add(tfprice);
      
      JLabel l8 = new JLabel("Cleaning Status");
      l8.setBounds(30,345,100,40);
      add(l8);
      
      String arr[] = {"Clean","Dirty"};
      cbclean = new JComboBox(arr);
      cbclean.setBounds(150,350,170,30);
      cbclean.setBackground(Color.WHITE);
      add(cbclean);
      
      addroom= new JButton("Add Room");
      addroom.setBounds(190,430,130,40);
      addroom.setBackground(Color.BLACK);
      addroom.setForeground(Color.WHITE);
      addroom.setFont(new Font("serif",Font.PLAIN,20));
      add(addroom);
      
      addroom.addActionListener(this);
      
      back= new JButton("Back");
      back.setBounds(10,430,130,40);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setFont(new Font("serif",Font.PLAIN,20));
      add(back);
      
      back.addActionListener(this);
     
      ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/7.jpg"));
      Image i2 = image.getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT);
      ImageIcon i3 =new ImageIcon(i2);
      JLabel label = new JLabel(i3);
      label.setBounds(330,10,550,450);
      add( label); 
      
      setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        { 
            setVisible(false);
            //new Dashboard();
        }
        else
        {
            String roomnumber = tfroomno.getText();
            String availability = (String)cbavailable.getSelectedItem();
            String rstatus = (String)cbclean .getSelectedItem();
            String price = tfprice.getText();
            String type = (String)cbtype .getSelectedItem();
            
            String room_type = null;
             if(ac.isSelected())
                room_type = "AC";
             else if(nonac.isSelected())
                room_type = "Non AC";
       
           if(roomnumber.equals("") || price.equals("") )     
             {
                JOptionPane.showMessageDialog(null,"Please fill all the details.");
               
             }
      
            else
            {
            
            try
            {
            Conn conn = new Conn();
           
           String query = "insert into rooms values('"+roomnumber+"','"+availability+"','"+room_type+"','"+type+"','"+price+"','"+rstatus+"')";          
          
           conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"New room added successfully");
           
           setVisible(false);
            }
           catch(Exception e1)
           {
            e1.printStackTrace();
           }
         
           }
           
        }
    }
     public static void main(String arg[])
     {
         AddRooms ob=new AddRooms();
     }
}
