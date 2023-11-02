
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener 
{
    Container c;
    JLabel label1,label2,label3;
    JTextField user ,email;
    JPasswordField password;
    JButton btn1 ,btn2;
    
   Login()
    {
        setTitle("Login Form");
        setBounds(250,50,800,500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        c=getContentPane();
        c.setLayout(null);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        JLabel label = new JLabel(image);
        label.setBounds(350,30,400,400);
       
        c.add(label);
        
        label1=new JLabel("Username");
        label2=new JLabel("Email Id");
        label3=new JLabel("Password");
        
        label1.setBounds(10,50,100,20);
        label2.setBounds(10,100,100,20);
        label3.setBounds(10,150,100,20);
        
        c.add(label1);
        c.add(label2); 
        c.add(label3);
        
        user=new JTextField();
        user.setBounds(120,50,150,20);
        c.add(user);
        
        email=new JTextField();
        email.setBounds(120,100,150,20);
        c.add(email);
        
        password=new JPasswordField();
        password.setBounds(120,150,150,20);
        c.add(password);
        
        btn2=new JButton("Sign in");
        btn2.setBounds(200,350,80,30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        c.add(btn2);
        
        btn1=new JButton("Back");
        btn1.setBounds(10,350,70,30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        c.add(btn1);
       
        btn1.addActionListener(this); 
        btn2.addActionListener(this);
       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {  

        if(e.getSource()==btn1)
        {
          setVisible(false); 
          
        }
        if(e.getSource() == btn2)
        {
             String username = user.getText();
            String mail = email.getText();
            String pass = password.getText();
            try
            {
                Conn c = new Conn();
                String query ="Select * from Login where username='"+username+"' and email='"+mail+"' and password='"+pass+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next())
                {
                   setVisible(false);
                   new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            }catch(Exception e1)
            {
                e1.printStackTrace();
            }
           
        }      
        
   } 
    public static void main(String[] args)
    {
       new Login();
    }
    
}



