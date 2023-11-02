
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener
{
   Dashboard()
   {
       setTitle("Dashboard");
       setBounds(0,0,1366,768);
       //setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       //setResizable(false);

       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/9.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1366,768);
       add(image);
       
       JLabel label = new JLabel("WELCOME");
       label.setBounds(500,30,300,50);
       label.setForeground(Color.WHITE);
       label.setFont(new Font("serif",Font.PLAIN,50));
       image.add(label);
               
     
       JMenuBar mb = new JMenuBar();
       mb.setBounds(0,0,1366,20);
       image.add(mb);
       
       JMenu m1 = new JMenu("HOTEL MANAGEMENT");
       m1.setForeground(Color.BLUE);
       mb.add(m1);
       
       JMenuItem reception = new JMenuItem("RECEPTION");
       m1.add(reception);
       reception.addActionListener(this);
               
       JMenu m2 = new JMenu("MANAGER");
       m2.setForeground(Color.RED);
       mb.add(m2);
      
       JMenuItem employee= new JMenuItem("ADD EMPLOYEE");
       m2.add(employee);
       employee.addActionListener(this);
       
       JMenuItem room = new JMenuItem("ADD ROOMS");
       m2.add(room);
       room.addActionListener(this);
       
       JMenuItem emp_info = new JMenuItem("EMPLOYEES INFORMATION");
       m2.add(emp_info);
       emp_info.addActionListener(this);
       
       JMenuItem room_details = new JMenuItem("ALL ROOM DETAILS");
       m2.add(room_details);
       room_details.addActionListener(this);
       
       JMenuItem inquiry = new JMenuItem("INQUIRY");
       m2.add(inquiry);
       inquiry.addActionListener(this);
       
       JMenuItem income = new JMenuItem("INCOME");
       m2.add(income);
       income.addActionListener(this);
       
       JMenu m3 = new JMenu("LOG OUT");
       m3.setForeground(Color.BLACK);
       mb.add(m3);
       
       JMenuItem yes = new JMenuItem("YES,I want to log out");
       m3.add(yes);
       yes.addActionListener(this);
       
       JMenuItem no = new JMenuItem("NO,I don't want to log out");
       m3.add(no);
       no.addActionListener(this);
       
       setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {
       if(e.getActionCommand().equals("RECEPTION"))
       {
          new Reception();
       }
       else if(e.getActionCommand().equals("ADD EMPLOYEE"))
       {
          new AddEmployee();
       }
       
       else if(e.getActionCommand().equals("ADD ROOMS"))
       {
          new AddRooms(); 
       }
       else if(e.getActionCommand().equals("EMPLOYEES INFORMATION"))
       {
          new Employeeinfo();      
       }
       else if(e.getActionCommand().equals("ALL ROOM DETAILS"))
       {
          new Rooms(); 
       }
       else if(e.getActionCommand().equals("INQUIRY"))
       {
          new Inquiry(); 
       }
       else if(e.getActionCommand().equals("INCOME"))
       {
          new Income();
       }
       else if(e.getActionCommand().equals("YES,I want to log out"))
       {
          setVisible(false);
          
       }
   }
   public static void main(String arg[])
   {
       Dashboard ob = new Dashboard();
    }
}
