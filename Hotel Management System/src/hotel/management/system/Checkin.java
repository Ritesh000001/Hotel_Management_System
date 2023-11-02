package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Checkin extends JFrame implements ActionListener
{
    JComboBox cbid;
    JTextField tfidno,tfname,tfmobile,tfcountry,tfdeposite;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton submit,back;
    
    Checkin()
    {       
      setLayout(null);
      setTitle("Check in");
      setBounds(180,60,900,600);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      
      Container con = getContentPane();
      con.setBackground(Color.WHITE);
      
      
      JLabel l1 = new JLabel("New Check in Form");
      l1.setBounds(115,20,180,40);
      l1.setFont(new Font("serif",Font.BOLD,20));
      add(l1);
      
      JLabel l2 = new JLabel("Customer ID");
      l2.setBounds(30,70,70,40);
      add(l2);
      
      String options[] = {"Adhar Card ","Passport","Voter Id Card","Driving License","Ration Card"};
      cbid = new JComboBox(options);
      cbid.setBounds(200,75,200,30);
      cbid.setBackground(Color.WHITE);
      add(cbid);
     
      JLabel l3 = new JLabel("ID Number");
      l3.setBounds(30,120,70,40);
      add(l3);
      
      tfidno = new JTextField();
      tfidno.setBounds(200,125,200,30);
      add(tfidno);
      
      JLabel l4 = new JLabel("Name");
      l4.setBounds(30,170,70,40);
      add(l4);
      
      tfname = new JTextField();
      tfname.setBounds(200,175,200,30);
      add(tfname);
      
      JLabel l5 = new JLabel("Gender");
      l5.setBounds(30,214,70,40);
      add(l5);
      
      rbmale =  new JRadioButton("Male");
      rbmale.setBounds(200,220,70,30);
      rbmale.setBackground(Color.WHITE);
      rbmale.setSelected(true);
      add(rbmale);
      
      rbfemale =  new JRadioButton("Female");
      rbfemale.setBounds(270,220,70,30);
      rbfemale.setBackground(Color.WHITE);
      add(rbfemale);
      
      ButtonGroup gender = new ButtonGroup();
      gender.add(rbmale);
      gender.add(rbfemale);
      
      JLabel l6 = new JLabel("Mobile No.");
      l6.setBounds(30,265,70,40);
      add(l6);
      
      tfmobile = new JTextField();
      tfmobile.setBounds(200,270,200,30);
      add(tfmobile);
      
      
      JLabel l7 = new JLabel("Country");
      l7.setBounds(30,310,70,40);
      add(l7);
      
      tfcountry = new JTextField();
      tfcountry.setBounds(200,315,200,30);
      add(tfcountry);
      
      JLabel l8 = new JLabel("Allocated room number");
      l8.setBounds(30,350,140,40);
      add(l8);
      
      croom = new Choice();
      
      try
       {
        Conn c = new Conn();
        String query ="Select * from rooms where availability = 'Available'";
        ResultSet rs = c.s.executeQuery(query);
        while(rs.next())
         {
          croom.add(rs.getString("room_number"));  
         }
       }catch(Exception e1)
        {
          e1.printStackTrace();
        }
      croom.setBounds(200,360,200,30);
      croom.setBackground(Color.WHITE);
      add(croom);
      
      JLabel l9 = new JLabel("Check in Time ");
      l9.setBounds(30,390,130,40);
      add(l9);
      
      SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
      Date date = new Date();
      checkintime = new JLabel(""+obj.format(date));
      checkintime.setBounds(200,390,180,40);
      add(checkintime);
     
      JLabel l10 = new JLabel("Deposite");
      l10.setBounds(30,440,70,40);
      add(l10);
     
      tfdeposite = new JTextField();
      tfdeposite.setBounds(200,445,200,30);
      add(tfdeposite);
      
      submit= new JButton("Submit");
      submit.setBounds(270,500,130,40);
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.setFont(new Font("serif",Font.PLAIN,20));
      submit.addActionListener(this);
      add(submit);
      
      back= new JButton("Back");
      back.setBounds(30,500,130,40);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setFont(new Font("serif",Font.PLAIN,20));
      back.addActionListener(this);
      add(back);
      
      ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/5.png"));
      Image i2 = image.getImage().getScaledInstance(350, 450, Image.SCALE_DEFAULT);
      ImageIcon i3 =new ImageIcon(i2);
      JLabel label = new JLabel(i3);
      label.setBounds(450,60,350,450);
      add( label);  
     
      setVisible(true);
   }
    
   public void actionPerformed(ActionEvent ae)
   {
     if(ae.getSource()==submit)
       {
         String id = (String)cbid.getSelectedItem();
         String idnumber = tfidno.getText();
         String name = tfname.getText();
         String gender = null;
         
           if(rbmale.isSelected())
            {
              gender = "Male";
            }
           else
            {   
              gender ="Female";
            }
         
         String mobile = tfmobile.getText();
         String country =  tfcountry.getText();
         String room =  croom.getSelectedItem();
         String time = checkintime.getText();
         String deposite = tfdeposite.getText();
         
         if(idnumber.equals("") || name.equals("") || mobile.equals("") || country.equals("") || deposite.equals(""))     
         {
            JOptionPane.showMessageDialog(null,"Please fill all the details.");
          }
      
         else
         {
           try
           {
              String query = "insert into customers values('"+id+"','"+idnumber+"','"+name+"','"+gender+"','"+mobile+"','"+country+"','"+room+"','"+time+"','"+deposite+"')";
              String query2 = "update rooms set availability = 'Occupied' where room_number = '"+room+"'" ;
             
              Conn conn = new Conn();
              conn.s.executeUpdate(query);
              conn.s.executeUpdate(query2);
             
              JOptionPane.showMessageDialog(null,"New Customer added Successfully");
            
              setVisible(false);
              new Reception();
             
           } catch(Exception e)
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
      Checkin ob =  new Checkin();  
  }
    
}
