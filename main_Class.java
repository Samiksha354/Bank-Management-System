package bank.management.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class main_Class extends JFrame  implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pin;


    main_Class(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);


        JLabel label=new JLabel("Please Select Your Transaction");
        label.setBounds(350,140,500,25);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,22));
        l3.add(label);

        b1=new JButton("DEPOSIT");
        b1.setFont(new Font("System",Font.BOLD,12));
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(350,213,160,27);
        b1.addActionListener(this);
        l3.add(b1);


        b2=new JButton("FAST CASH");
        b2.setFont(new Font("System",Font.BOLD,12));
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,250,160,27);
        b2.addActionListener(this);
        l3.add(b2);


        b3=new JButton("PIN CHANGE");
        b3.setFont(new Font("System",Font.BOLD,12));
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.setBounds(350,287,160,27);
        b3.addActionListener(this);
        l3.add(b3);

//        b4=new JButton("D");
//        b4.setFont(new Font("System",Font.BOLD,12));
//        b4.setBackground(new Color(65,125,128));
//        b4.setForeground(Color.WHITE);
//        b4.setBounds(350,324,160,27);
////        b4.addActionListener(this);
//        l3.add(b4);

//
        b5=new JButton("CASH WITHDRAWL");
        b5.setFont(new Font("System",Font.BOLD,12));
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.setBounds(550,213,160,27);
        b5.addActionListener(this);
        l3.add(b5);


        b6=new JButton("MINI STATEMENT");
        b6.setFont(new Font("System",Font.BOLD,12));
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.setBounds(550,250,160,27);
        b6.addActionListener(this);
        l3.add(b6);


        b7=new JButton("BALANCE ENQUIRY");
        b7.setFont(new Font("System",Font.BOLD,12));
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.setBounds(550,287,160,27);
        b7.addActionListener(this);
        l3.add(b7);

        b8=new JButton("EXIT");
        b8.setFont(new Font("System",Font.BOLD,12));
        b8.setBackground(new Color(65,125,128));
        b8.setForeground(Color.WHITE);
        b8.setBounds(550,324,160,27);
        b8.addActionListener(this);
        l3.add(b8);

        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==b1){
           new Deposit(pin);
           setVisible(false);
       }else if(e.getSource()==b8){
           System.exit(0); //to close all program
       }else if(e.getSource()==b5){
           new Withdrawl(pin);
           setVisible(false);
       }else if(e.getSource()==b7){
           new BalanceEnquriy(pin);
           setVisible(false);
       }else if(e.getSource()==b2){
           new FastCash(pin);
           setVisible(false);
       }else if(e.getSource()==b3){
           new Pin(pin);
           setVisible(false);
       }else if(e.getSource()==b6){
           new mini(pin);

       }
    }




    public static void main(String[]args){
        new main_Class("");

    }
}
