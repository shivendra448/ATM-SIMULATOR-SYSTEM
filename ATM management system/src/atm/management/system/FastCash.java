package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash  extends JFrame implements ActionListener { 
    
    JButton amount,back;
    String pinnumber;
    
    FastCash(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout (null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220,230,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        image.add(text); 
        
        amount = new JButton("Rs 100");
        amount.setBounds(170,323,150,25);
        amount.addActionListener(this);
        image.add(amount);
        
        amount = new JButton("Rs 500");
        amount .setBounds(355,323,150,25);
        amount.addActionListener(this);
        image.add(amount);
        
        amount = new JButton("Rs 1000");
        amount .setBounds(170,350,150,25);
        amount.addActionListener(this);
        image.add(amount );
        
        amount = new JButton("Rs 2000");
        amount.setBounds(355,350,150,25);
        amount.addActionListener(this);
        image.add(amount );
        
        amount= new JButton("Rs 5000");
        amount.setBounds(170,377,150,25);
        amount.addActionListener(this);
        image.add(amount );
        
        amount = new JButton("Rs 10000");
        amount.setBounds(355,377,150,25);
        amount.addActionListener(this);
        image.add(amount );
        
        back = new JButton("BACK");
        back.setBounds(355,403,150,25);
        back.addActionListener(this);
        image.add(back  );
        
        setSize(900,700);
        setLocation(230,0);
        //setUndecorated(true);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource()== back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
        }  else   {
               String amount = ((JButton)ae.getSource()).getText().substring(3);  //Rs 500
               Conn c = new Conn();
               try {
                    ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                     Date date = new Date();
                     String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Withdrawal', '"+amount+"')";
                     c.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
                     
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
               } catch (Exception e) {
                   System.out.println(e);
               }
       }   
           
       }
             
    public static void main(String args[]) {
      
        new FastCash("");
    }
}
