package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Pin extends JFrame implements ActionListener {
    JPasswordField p1, p2;
    JButton b1, b2;
    String pin;


    Pin(String pin) {
  this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1300, 650);
        add(l3);


        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("Raleway", Font.BOLD, 18));
        label1.setBounds(360, 130, 300, 30);
        label1.setForeground(Color.WHITE);
        l3.add(label1);


        JLabel label2 = new JLabel("New PIN:");
        label2.setFont(new Font("Raleway", Font.BOLD, 16));
        label2.setBounds(360, 160, 300, 25);
        label2.setForeground(Color.WHITE);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setFont(new Font("Raleway", Font.BOLD, 16));
        p1.setBounds(510, 160, 200, 25);
        p1.setForeground(Color.WHITE);
        p1.setBackground(new Color(65, 125, 128));
        l3.add(p1);


        JLabel label3 = new JLabel("Re-Enter New PIN:");
        label3.setFont(new Font("Raleway", Font.BOLD, 16));
        label3.setBounds(360, 190, 300, 25);
        label3.setForeground(Color.WHITE);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setFont(new Font("Raleway", Font.BOLD, 16));
        p2.setBounds(510, 190, 200, 25);
        p2.setForeground(Color.WHITE);
        p2.setBackground(new Color(65, 125, 128));
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setFont(new Font("Raleway", Font.BOLD, 16));
        b1.setBounds(570, 300, 130, 25);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Raleway", Font.BOLD, 16));
        b2.setBounds(570, 330, 130, 25);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.addActionListener(this);
        l3.add(b2);


        setLayout(null); //default is borderlayout
        setSize(1550, 1080);
        setLocation(0, 0);
        //getContentPane().setBackground(Color.CYAN); -this is to set the color to the window
        //getContentPane().setBackground(new Color(102, 204, 255)); -new color is used when we are using custom color rather than build in
        setVisible(true);

    }


    @Override
    public  void actionPerformed(ActionEvent e){
        try{
            String pin1=p1.getText();
            String pin2=p2.getText();


            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(e.getSource()==b1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new PIN");
                    return;

                }if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter new PIN");
                    return;
                }
                Connn c=new Connn();
                String q1="update bank set pin= '"+pin1+"' where pin='"+pin+"'  ";
                String q2="update login set pin= '"+pin1+"' where pin='"+pin+"'  ";
                String q3="update signupthree set pin= '"+pin1+"' where pin='"+pin+"'  ";


                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
                setVisible(false);
                new main_Class(pin);

            }
            else if(e.getSource()==b2){
                new main_Class(pin);
                setVisible(false);
            }

        }catch(Exception E){
              E.printStackTrace();
        }
    }

    public static void main(String[] arsg) {
        new Pin("");
    }
}


