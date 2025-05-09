
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit,withdrawl,balance,exit,fastcash,mini,pin;
    String pinnumber;
    FastCash(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(185,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(140,322,140,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(320,322,140,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(140,348,140,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mini = new JButton("Rs 2000");
        mini.setBounds(320,348,140,25);
        mini.addActionListener(this);
        image.add(mini);
        
        pin = new JButton("Rs 5000");
        pin.setBounds(140,374,140,25);
        pin.addActionListener(this);
        image.add(pin);
        
        balance = new JButton("Rs 10000");
        balance.setBounds(320,374,140,25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Back");
        exit.setBounds(320,400,140,25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit){
            setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    }else 
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                }
                int withamount = Integer.parseInt(amount);
                if(ae.getSource() != exit && balance<withamount)
                        {
                            JOptionPane.showMessageDialog(null,"Insufficient balance");
                            return;
                        }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[])
    {
        new FastCash("");
    }
    
}
