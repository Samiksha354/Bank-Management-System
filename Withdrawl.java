package bank.management.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;




public class Withdrawl extends JFrame  implements ActionListener{
    String pin;
    TextField textField;
    JButton b1,b2;
    Withdrawl(String pin){
     this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);



        JLabel label1=new JLabel("MAXIMUM WITHDRAWL IS RS.10,000");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(365,120,700,35); //this is for font
        //add(label1);-not using cause we have to add the label
        // on the image of atm not on the window
        label1.setForeground(Color.WHITE);
        l3.add(label1);//the label will be visible on image


        JLabel label2=new JLabel("PLEASE ENTER YOUR AMOUNT:");
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(365,150,500,35); //this is for font
        //add(label1);-not using cause we have to add the label
        // on the image of atm not on the window
        label2.setForeground(Color.WHITE);
        l3.add(label2);//the label will be visible on image


        textField =new TextField();
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        textField.setBounds(365,185,340,25); //this is for font
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);


        b1=new JButton("WITHDRAWL");
        b1.setFont(new Font("Raleway",Font.BOLD,12));
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(600,285,110,25);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setFont(new Font("Raleway",Font.BOLD,12));
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(600,322,110,25);
        b2.addActionListener(this);
        l3.add(b2);


        ///string pin we have accepted the pin coming from signup3
        setLayout(null); //default is borderlayout
        setSize(1550,1080);
        setLocation(0,0);
        //getContentPane().setBackground(Color.CYAN); -this is to set the color to the window
        //getContentPane().setBackground(new Color(102, 204, 255)); -new color is used when we are using custom color rather than build in
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1) {

            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    Connn c = new Connn();
                    //executequery is used when you have to get data from table
                    //executeupdate is used when you have to add data to table
                    //ResultSet is inbuild we have to import= import java.sql.ResultSet;
                    ResultSet resultSet = c.statement.executeQuery("select*from  bank where pin='" + pin + "'");
                    int balance = 0;
                    //while loop is to check whether the data
                    // from the table is stored in resultSet or not
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("deposit")) { //if column type =deposit,amount get stored in deposit
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    c.statement.executeUpdate("Insert into bank values ('" + pin + "','" + date + "','Withdrawl','" + amount + "')");
                    //here amount is amount which is withdwar by people
                    JOptionPane.showMessageDialog(null, "RS." + amount + "Debited Successfully");
                    setVisible(false);
                    new main_Class(pin);


                }

            } catch (Exception E) {

            }
        }else if(e.getSource()==b2){
            setVisible(false);
            new main_Class(pin);
        }

    }
    public static void main(String[] args){
   new Withdrawl("");
    }
}
