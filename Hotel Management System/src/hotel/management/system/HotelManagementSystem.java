
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener
{
    JButton exit,next;
    
    HotelManagementSystem()
    {
        setSize(1366,650);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel label = new JLabel(image);
        label.setBounds(200,200,1366,650);
        add(label);
        
        JLabel text =new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,510,790,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        label.add(text);
        
        next = new JButton("Next");
        next.setBounds(1050,510,150,50);
        next.setFont(new Font("serif",Font.PLAIN,35));
        next.addActionListener(this);
        label.add(next);
        
        exit = new JButton("Exit");
        exit.setBounds(850,510,150,50);
        exit.setFont(new Font("serif",Font.PLAIN,35));
        label.add(exit);
        exit.addActionListener(this);
        
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        next.setCursor(cur);
         
        setVisible(true);
        
        while(true)
        {
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch(Exception e){
                e.printStackTrace();
            }
        } 
    }
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==next)
       {
            new Login();
        }
       
       else if(e.getSource()==exit)
       {
           System.exit(0);
        }
    }
    public static void main(String[] args)
    {
       HotelManagementSystem ob = new HotelManagementSystem();
    }
}


