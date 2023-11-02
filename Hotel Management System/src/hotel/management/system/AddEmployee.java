
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class AddEmployee extends JFrame implements ActionListener
{  
    JTextField tfname,tfage,tfsalary,tfmobile,tfadhar;
    JTextArea taaddress ;
    JComboBox cbjob;
    JRadioButton male,female;
    JButton submit,back;
    JLabel empid,joining;
    
    Random ran = new Random();
    int number = ran.nextInt(9999);
    
   AddEmployee()
   {
      setLayout(null);
      setTitle("Add Employee");
      setBounds(180,60,900,600);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setResizable(false);

      ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/4.jpg"));
      Image i2 = image.getImage().getScaledInstance(550, 515, Image.SCALE_DEFAULT);
      ImageIcon i3 =new ImageIcon(i2);
      JLabel label = new JLabel(i3);
      label.setBounds(330,10,550,515);
      add( label); 
      
      JLabel label2 = new JLabel("Employee Id");
      label2.setBounds(30,10,90,40);
      add(label2);
      
      empid = new JLabel("" + number);
      empid.setBounds(120,10,90,40);
      add(empid);
      
      JLabel l1 = new JLabel("Name");
      l1.setBounds(30,55,70,40);
      add(l1);
      
      tfname = new JTextField();
      tfname.setBounds(120,60,200,30);
      add(tfname);
      
      JLabel l2 = new JLabel("Age");
      l2.setBounds(30,105,70,40);
      add(l2);
      
      tfage = new JTextField();
      tfage.setBounds(120,110,200,30);
      add(tfage);
      
      JLabel l3 = new JLabel("Gender");
      l3.setBounds(30,145,70,40);
      add(l3);
      
      male =  new JRadioButton("Male");
      male.setBounds(120,150,70,30);
      male.setSelected(true);
      add(male);
      
      female =  new JRadioButton("Female");
      female.setBounds(190,150,70,30);
      add(female);
      
      ButtonGroup gender = new ButtonGroup();
      gender.add(male);
      gender.add(female);
      
      JLabel l4 = new JLabel("Job");
      l4.setBounds(30,190,70,40);
      add(l4);
      
      String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waiteress","Manager","Accountant","Guards"};
      cbjob = new JComboBox(str);
      cbjob.setBounds(120,195,200,30);
      cbjob.setBackground(Color.WHITE);
      add(cbjob);
      
      JLabel l5 = new JLabel("Salary");
      l5.setBounds(30,240,70,40);
      add(l5);
     
      tfsalary = new JTextField();
      tfsalary.setBounds(120,245,200,30);
      add(tfsalary);
      
      JLabel l6 = new JLabel("Mobile No.");
      l6.setBounds(30,290,70,40);
      add(l6);
     
      tfmobile = new JTextField();
      tfmobile.setBounds(120,295,200,30);
      add(tfmobile);
      
      JLabel l7 = new JLabel("Adhar No.");
      l7.setBounds(30,340,70,40);
      add(l7);
      
      tfadhar = new JTextField();
      tfadhar.setBounds(120,345,200,30);
      add(tfadhar);
      
      JLabel l8 = new JLabel("Address");
      l8.setBounds(30,380,70,40);
      add(l8);
     
      taaddress = new JTextArea();
      taaddress.setBounds(120,390,200,50);
      taaddress.setLineWrap(true);
      add(taaddress);
      
      JLabel l9 = new JLabel("Joining Date");
      l9.setBounds(30,440,80,40);
      add(l9);
      
      Date date = new Date();
      joining = new JLabel(""+date);
      joining.setBounds(120,440,180,40);
      add(joining);
     
      submit= new JButton("Submit");
      submit.setBounds(190,490,130,40);
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.setFont(new Font("serif",Font.PLAIN,20));
      add(submit);
      
      submit.addActionListener(this);
      
      back= new JButton("Back");
      back.setBounds(10,490,130,40);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setFont(new Font("serif",Font.PLAIN,20));
      add(back);
      
      back.addActionListener(this);
    
      setVisible(true);
   }
   public void actionPerformed(ActionEvent e )
   {
       if(e.getSource()==back)
       {
            setVisible(false);
        }
       else
       {
         String emp_id = empid.getText();
         String name = tfname.getText();
         String age = tfage.getText();
         String salary = tfsalary.getText();
         String mobile = tfmobile.getText();
         String adhar = tfadhar.getText();
         String address = taaddress.getText();
       
       if(name.equals("") || age.equals("") || salary.equals("") || mobile.equals("") || adhar.equals("") || address.equals(""))     
          {
            JOptionPane.showMessageDialog(null,"Please fill all the details.");
           }
      
         else
          { 
           
            int n = mobile.length();
           
           
              if(n!=10)
              {
               JOptionPane.showMessageDialog(null,"Mobile number should be of ten digits.");
           
              }
                  
              else
              {
                int an=adhar.length();
                if(an!=12)
                {
                 JOptionPane.showMessageDialog(null,"Adhar number should be of twelve digits."); 
                }
                 else
                 {
                  String gender = null;
                  if(male.isSelected())
                     gender = "Male";
                  else if(female.isSelected())
                     gender = "Female";
       
                 String job = (String) cbjob.getSelectedItem();
                 String join_date= joining.getText();

                  try
                  {
                      Conn conn = new Conn();
                      String query = "insert into employees values('"+emp_id+"','"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+mobile+"','"+adhar+"','"+address+"','"+join_date+"')";          
                      conn.s.executeUpdate(query);
           
                      JOptionPane.showMessageDialog(null,"Employee added successfully");
           
                      setVisible(false);
                   }
                    catch(Exception e1)
                    {
                      e1.printStackTrace();
                    }
              
                 }
             
                } 
            }
       }
   }
    public static void main(String arg[])
    {
      AddEmployee ob = new AddEmployee();   
    }
}
