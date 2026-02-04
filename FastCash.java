package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    String pin;


    FastCash( String pin) {
       this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1300, 650);
        add(l3);


        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(350, 140, 500, 25);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 20));
        l3.add(label);

        b1 = new JButton("Rs. 100");
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 213, 160, 27);
        b1.addActionListener(this);
        l3.add(b1);


        b2 = new JButton("Rs. 500");
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.setBounds(350, 250, 160, 27);
        b2.addActionListener(this);
        l3.add(b2);


        b3 = new JButton("Rs. 1000");
        b3.setFont(new Font("System", Font.BOLD, 14));
        b3.setBackground(new Color(65, 125, 128));
        b3.setForeground(Color.WHITE);
        b3.setBounds(350, 287, 160, 27);
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
        b5 = new JButton("Rs. 2000");
        b5.setFont(new Font("System", Font.BOLD, 14));
        b5.setBackground(new Color(65, 125, 128));
        b5.setForeground(Color.WHITE);
        b5.setBounds(550, 213, 160, 27);
        b5.addActionListener(this);
        l3.add(b5);


        b6 = new JButton("Rs. 5000");
        b6.setFont(new Font("System", Font.BOLD, 14));
        b6.setBackground(new Color(65, 125, 128));
        b6.setForeground(Color.WHITE);
        b6.setBounds(550, 250, 160, 27);
        b6.addActionListener(this);
        l3.add(b6);


        b7 = new JButton("Rs. 10000");
        b7.setFont(new Font("System", Font.BOLD, 14));
        b7.setBackground(new Color(65, 125, 128));
        b7.setForeground(Color.WHITE);
        b7.setBounds(550, 287, 160, 27);
        b7.addActionListener(this);
        l3.add(b7);

        b8 = new JButton("BACK");
        b8.setFont(new Font("System", Font.BOLD, 14));
        b8.setBackground(new Color(65, 125, 128));
        b8.setForeground(Color.WHITE);
        b8.setBounds(550, 324, 160, 27);
        b8.addActionListener(this);
        l3.add(b8);

        setLayout(null);
        setSize(1550, 1000);
        setLocation(0, 0);
        setVisible(true);
    }

        @Override
    public void actionPerformed(ActionEvent e){

            if(e.getSource()== b8){
                setVisible(false);
                new main_Class(pin);//redirect to the main class
            }else {
                String amount = ((JButton) e.getSource()).getText().substring(4);
                //fetching value in button but there RS. 100 so only to fetch 100 the amount
                //substring(4 ) is used so Rs._ got ignored
                Connn c = new Connn();
                Date date = new Date();


                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin='"+pin+"'");
                    int balance=0;
                    while(resultSet.next()){
                        if (resultSet.getString("type").equals("deposit")){
                            balance +=Integer.parseInt(resultSet.getString("amount"));
                        }else{
                            balance -=Integer.parseInt(resultSet.getString("amount"));
                        }
                    }String num="17";
                    if(e.getSource() != b7 && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    c.statement.executeUpdate("Insert into bank values('"+pin+"','"+date+"','withdrawl','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+"  debited Successfully");
                } catch (Exception E) {
                    E.printStackTrace();

                }
                setVisible(false);
                new main_Class(pin);
            }
    }
    public static void main(String[] args){
     new FastCash(" ");
    }
}
