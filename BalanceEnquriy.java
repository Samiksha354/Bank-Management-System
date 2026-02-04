package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.ResultSet;


public class BalanceEnquriy extends JFrame  implements ActionListener{
String pin;
JLabel label2;
JButton b1;
BalanceEnquriy(String pin){
             this.pin=pin;


             ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
             Image i2 =i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
             ImageIcon i3=new ImageIcon(i2);
             JLabel l3=new JLabel(i3);
             l3.setBounds(0,0,1300,650);
             add(l3);


             JLabel label1=new JLabel("YOUR CURRENT BALANCE IS Rs.");
             label1.setFont(new Font("System",Font.BOLD,16));
             label1.setBounds(365,130,700,35); //this is for font
             //add(label1);-not using cause we have to add the label
             // on the image of atm not on the window
             label1.setForeground(Color.WHITE);
             l3.add(label1);//the label will be visible on image


             label2=new JLabel("");
             label2.setFont(new Font("System",Font.BOLD,16));
             label2.setBounds(365,150,500,35); //this is for font
             //add(label1);-not using cause we have to add the label
             // on the image of atm not on the window
             label2.setForeground(Color.WHITE);
             l3.add(label2);

             b1=new JButton("BACK");
             b1.setFont(new Font("Raleway",Font.BOLD,12));
             b1.setBackground(new Color(65,125,128));
             b1.setForeground(Color.WHITE);
             b1.setBounds(600,285,110,25);
             b1.addActionListener(this);
             l3.add(b1);

             int balance=0;
             try{
                 Connn c=new Connn();
                 ResultSet resultSet=c.statement.executeQuery("Select * from bank where pin='"+pin+"'");
                 while(resultSet.next()){
                     if(resultSet.getString("type").equals("deposit")){ //if column type =deposit,amount get stored in deposit
                         balance +=Integer.parseInt(resultSet.getString("amount"));
                     }else{
                         balance -=Integer.parseInt(resultSet.getString("amount"));
                     }
                 }
             }catch(Exception e){
                 e.printStackTrace();
             }


             label2.setText(""+balance);


             setLayout(null); //default is borderlayout
             setSize(1550,1080);
             setLocation(0,0);
             //getContentPane().setBackground(Color.CYAN); -this is to set the color to the window
             //getContentPane().setBackground(new Color(102, 204, 255)); -new color is used when we are using custom color rather than build in
             setVisible(true);

         }


         @Override
         public void actionPerformed(ActionEvent e){
           setVisible(false);
           new main_Class(pin);
         }

          public static void main(String[]args){
          new BalanceEnquriy("");
          }
}
