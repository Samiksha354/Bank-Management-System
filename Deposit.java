package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    String pin;//global declaration of the pin comming from signup3

    TextField textField;

    JButton b1, b2; //b1-deposit b2-back buttons

    Deposit(String pin){ /// constructor of class
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(365,160,400,35); //this is for font
        //add(label1);-not using cause we have to add the label
        // on the image of atm not on the window
        label1.setForeground(Color.WHITE);
        l3.add(label1);//the label will be visible on image


        textField =new TextField();
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        textField.setBounds(365,200,340,25); //this is for font
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);


        b1=new JButton("DEPOSIT");
        b1.setFont(new Font("Raleway",Font.BOLD,14));
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(600,285,110,25);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setFont(new Font("Raleway",Font.BOLD,14));
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(600,322,110,25);
        b2.addActionListener(this);
        l3.add(b2);

        ///string pin we have accepted the pin coming from signup3
        setLayout(null); //default is borderlayout
        setSize(1550,1080);
        setLocation(0,0);
//        getContentPane().setBackground(Color.CYAN); -this is to set the color to the window
        //getContentPane().setBackground(new Color(102, 204, 255)); -new color is used when we are using custom color rather than build in
        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e){
    try{
        String amount=textField.getText();
        Date date=new Date();
        if(e.getSource()==b1){
            if(textField.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit.");
            }else{
                Connn c=new Connn();
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','deposit','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs."+amount+"Deposited Successfully");
                setVisible(false);
                new main_Class(pin);

            }
        }else if(e.getSource()==b2){
             setVisible(false);
             new main_Class(pin);
        }


    }catch(Exception E){
           E.printStackTrace();
        }
    }


    public static void main(String [] args){
     new Deposit(""); ///object of constructor
        //empty string is for accepting pin from sign up three
    }
}
