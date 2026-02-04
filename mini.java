package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;


public class mini  extends JFrame implements ActionListener{
    String pin;
    JButton button;

    mini(String pin){
        this.pin=pin;
        getContentPane().setBackground(new Color(255,204,204));
        setLayout(null); //default is borderlayout
        setSize(350,600);
        setLocation(0,0);
        //getContentPane().setBackground(Color.CYAN); -this is to set the color to the window
        //getContentPane().setBackground(new Color(102, 204, 255)); -new color is used when we are using custom color rather than build in

        JLabel label1=new JLabel();
        label1.setBounds(20,200,400,25);
        add(label1);

        JLabel label2=new JLabel("Samiksha Jadhav");
        label2.setFont(new Font("System",Font.BOLD,15));
        label1.setBounds(70,100,200,25);
        add(label2);

        JLabel label3=new JLabel();
        label3.setBounds(20,300,300,20);
        add(label3);

        JLabel label4=new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);


        try {
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin='" + pin + "'");
            while (resultSet.next()) {
                label3.setText("Card Number: " + resultSet.getString("card_number").substring(0, 4) + "XXXXXXXX" + resultSet.getString("card_number").substring(12));

            }
        }catch(Exception e){
            e.printStackTrace();

        }

        try {
            int balance = 0;
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin='"+pin+"'");
            while(resultSet.next()){
                label1.setText(label1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
                if (resultSet.getString("type").equals("deposit")){
                    balance +=Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -=Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your total Balance is Rs. "+balance);
        }catch(Exception e){
            e.printStackTrace();

        }

       button=new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);
        setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }
    public static void main(String[] args){
        new mini("");

    }
}

