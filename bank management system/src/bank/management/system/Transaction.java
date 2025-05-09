
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    
    JButton deposit,withdrawl,balance,exit,fastcash,mini,pin;
    String pinnumber;
    Transaction(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(185,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140,322,140,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrwal");
        withdrawl.setBounds(320,322,140,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(140,348,140,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mini = new JButton("Mini Statement");
        mini.setBounds(320,348,140,25);
        mini.addActionListener(this);
        image.add(mini);
        
        pin = new JButton("Pin Change");
        pin.setBounds(140,374,140,25);
        pin.addActionListener(this);
        image.add(pin);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(320,374,140,25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
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
        if(ae.getSource()==exit)
            System.exit(0);
        else if(ae.getSource()==deposit){
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource()==pin){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource()==mini){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Transaction("");
    }
    
}
