package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Signup3  extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6;

    JButton s,c; //s-submit , c-cancel
    String formno;


    Signup3(String formno){
    this.formno=formno;




        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);


        //label 1
        JLabel l1=new JLabel("Page 3: ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);



        //label2
        JLabel l2=new JLabel("Account Details  ");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(280,70,400,40);
        add(l2);





        //label3
        JLabel l3=new JLabel("Account Type: ");
        l3.setFont(new Font("Raleway",Font.BOLD,22));
        l3.setBounds(100,130,400,40);
        add(l3);


        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,200,25);
        r1.setBackground(new Color(215,252,252));
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(300,180,250,25);
        r2.setBackground(new Color(215,252,252));
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,200,25);
        r3.setBackground(new Color(215,252,252));
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(300,220,300,25);
        r4.setBackground(new Color(215,252,252));
        add(r4);

        ButtonGroup buttongroup=new ButtonGroup();
        buttongroup.add(r1);
        buttongroup.add(r2);
        buttongroup.add(r3);
        buttongroup.add(r4);



        //label4
        JLabel l4=new JLabel("Card Number: ");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        l4.setBounds(100,270,400,40);
        add(l4);

        //label5
        JLabel l5=new JLabel("(16-digit number)");
        l5.setFont(new Font("Raleway",Font.BOLD,14));
        l5.setBounds(100,300,400,30);
        add(l5);

        JLabel l5a=new JLabel("(It would appear on atm card \\cheque book and Statements)");
        l5a.setFont(new Font("Raleway",Font.BOLD,14));
        l5a.setBounds(330,300,600,30);
        add(l5a);


        //label6
        JLabel l6=new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,22));
        l6.setBounds(330,270,400,40);
        add(l6);

        //label7
        JLabel l7=new JLabel("PIN:");
        l7.setFont(new Font("Raleway",Font.BOLD,22));
        l7.setBounds(100,340,400,40);
        add(l7);

        //label8
        JLabel l8=new JLabel("(4-digit number)");
        l8.setFont(new Font("Raleway",Font.BOLD,14));
        l8.setBounds(100,370,400,30);
        add(l8);

        //label9
        JLabel l9=new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,22));
        l9.setBounds(330,340,400,40);
        add(l9);


        //label10
        JLabel l10=new JLabel("Services Required:");
        l10.setFont(new Font("Raleway",Font.BOLD,22));
        l10.setBounds(100,410,400,40);
        add(l10);

        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,460,200,25);
        c1.setBackground(new Color(215,252,252));
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(330,460,200,25);
        c2.setBackground(new Color(215,252,252));
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,200,25);
        c3.setBackground(new Color(215,252,252));
        add(c3);

        c4=new JCheckBox("EMAIL Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(330,490,200,25);
        c4.setBackground(new Color(215,252,252));
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,25);
        c5.setBackground(new Color(215,252,252));
        add(c5);

        c6=new JCheckBox("E_Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(330,520,200,25);
        c6.setBackground(new Color(215,252,252));
        add(c6);



        JCheckBox c7=new JCheckBox("I here by declares that the above entered details correct to the best of my knowledge.",true);
        //true is passed here which means the checkbox will always be checked
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,550,700,25);
        c7.setBackground(new Color(215,252,252));
        add(c7);


        //label11
        JLabel l11=new JLabel("Form No.:-");
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        l11.setBounds(700,10,100,30);
        add(l11);

        //label12

        JLabel l12=new JLabel();
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(760,10,60,30);
        add(l12);





        s=new JButton("SUBMIT");
        s.setFont(new Font("Raleway",Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250,610,100,30);
        s.addActionListener(this);
        add(s);

        c=new JButton("CANCEL");
        c.setFont(new Font("Raleway",Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(420,610,100,30);
        c.addActionListener(this);
        add(c);


        getContentPane().setBackground(new Color(215,252,252));
        setSize(800,850);
        setLayout(null);
        setLocation(400,20);
        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e){
        /// getting radio button values
        String atype=null;
        if(r1.isSelected()){
            atype="Saving Account";
        }else if(r2.isSelected()){
           atype="Fixed Deposit Account";
        }else if(r3.isSelected()){
            atype="Current Account";
        }else if(r4.isSelected()){
            atype="Recurring Deposit Account";
        }

        /// getting text pan
        Random ran=new Random();
        long first7=(ran.nextLong()% 90000000L)+1409963000000000L;
        String cardno=""+Math.abs(first7);

        long first3=(ran.nextLong() %9000L)+1000L;
        String pin=""+Math.abs(first3);

        String fac="";  ////fac+ is used so that we can select multiple buttons
        if(c1.isSelected()){
            fac=fac+"ATM CARD";
        }else if(c2.isSelected()){
            fac=fac+"Internet Banking";
        }else if(c3.isSelected()){
            fac=fac+"Mobile Banking";
        }else if(c4.isSelected()){
            fac=fac+"EMAIL Alerts";
        }else if(c5.isSelected()){
            fac=fac+"Cheque Book";
        }else if(c6.isSelected()){
            fac=fac+"E_Statement";
        }

        try{
            if(e.getSource()==s){ //s==submit
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields.");
                }
                else{
                    Connn c1=new Connn();
                    String  q1="Insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String  q2="Insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin :"+pin);
                    new Deposit(pin);//this to that we are sending pin to deposit class
                    setVisible(false);
                }
            } else if(e.getSource()==c){ //s==submit
                System.exit(0);
               }

        } catch(Exception E){
            E.printStackTrace();
        }

    }





    public static void main(String[] args){

        new Signup3("");
    }
}
