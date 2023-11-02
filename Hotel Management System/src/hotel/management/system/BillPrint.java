package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;

public class BillPrint extends JFrame implements ActionListener
{
    JButton print;
    JTextArea detail;
    BillPrint()
    {
       setLayout(null);
       setTitle("Bill");
       setBounds(380,150,500,450);
      // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);

       
       detail= new JTextArea();
       detail.setBounds(5,0,480,380);
       detail.setEditable(false);
       add(detail);
       
       print=new JButton("Print");
       print.setBounds(210,380,80,30);
       print.setBackground(Color.BLACK);
       print.setForeground(Color.WHITE);
       print.addActionListener(this);
       add(print);
       
        String c_id=BillDetails.id;
        String name=BillDetails.name;
        String gender=BillDetails.gender;
        String mob=BillDetails.mobile;
        String country=BillDetails.country;
        String room_no=BillDetails.room;
        String roomtype=BillDetails.r_type;
        String bedtype=BillDetails.b_type;
        String checkin=BillDetails.indate;
        String checkout=BillDetails.outdate;
        String Price=BillDetails.price;
        String day=BillDetails.days;
        String amount=BillDetails.total;

        detail.setText("\t\t-: Hotel Management System :-\n");
        detail.setText(detail.getText()+"*********************************************************************************************************\n");
        detail.setText(detail.getText()+"Customer Details :-\n\n");
        detail.setText(detail.getText()+"\tName : "+name+"\n");
        detail.setText(detail.getText()+"\tGender : "+gender+"\n");
        detail.setText(detail.getText()+"\tMobile Number : "+mob+"\n");
        detail.setText(detail.getText()+"\tCountry : "+country+"\n\n");
        detail.setText(detail.getText()+"*********************************************************************************************************\n");
        detail.setText(detail.getText()+"Room Details :-\n\n");
        detail.setText(detail.getText()+"\tRoom Number : "+room_no+"\n");
        detail.setText(detail.getText()+"\tRoomType : "+roomtype+"\n");
        detail.setText(detail.getText()+"\tBed Type : "+bedtype+"\n");
        detail.setText(detail.getText()+"\tPrice : "+Price+"\n\n");
        detail.setText(detail.getText()+"Check In Date : "+checkin+"\t        Number of Days : "+day+"\n");
        detail.setText(detail.getText()+"Check Out Date : "+checkout+"\t      Total Amount : "+amount+"\n");
        detail.setText(detail.getText()+"*********************************************************************************************************\n");
        detail.setText(detail.getText()+"\t\t\t             Thank You, Please Visit Again.");
            
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
          detail.print();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
      
    }
   public static void main(String arg[])
    {
        BillPrint ob = new BillPrint();
    }
}
