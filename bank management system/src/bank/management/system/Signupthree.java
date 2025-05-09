

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Signupthree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    Signupthree(String formno)
    {
        this.formno=formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,120,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,160,250,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,160,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350,180,250,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(100,180,250,20);
        add(r4);
        
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        
        JLabel cardnumber = new JLabel("Card Number");
        cardnumber.setFont(new Font("Raleway",Font.BOLD,22));
        cardnumber.setBounds(100,220,200,30);
        add(cardnumber);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4104");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,220,250,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,250,300,15);
        add(carddetail);
        
        JLabel pinnumber = new JLabel("Pin Number");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(100,290,200,30);
        add(pinnumber);
        
        JLabel pin = new JLabel("XXXX");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(330,290,200,30);
        add(pin);
        
        JLabel Pindetail = new JLabel("Your 4 Digit Password");
        Pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        Pindetail.setBounds(100,320,300,15);
        add(Pindetail);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,360,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,420,200,30);
        add(c3);
        
        c4 = new JCheckBox("E-mail & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,420,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,440,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,440,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that all the details mentioned above are true");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,490,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,560,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(450,560,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);

        setBackground(Color.WHITE);
        setSize(900,1200);
        setLocation(350,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit){
            String accounttype = null;
            if(r1.isSelected()){
                accounttype = "Saving Account";
            } else if(r2.isSelected()){
                accounttype = "Fixed Deposit Account";
            } else if(r3.isSelected()){
                accounttype = "Current Account";
            } else if(r4.isSelected()){
                accounttype = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber  = "" + Math.abs((random.nextLong()%90000000L + 5040936000000000L));
            
            String pinnumber  = "" + Math.abs((random.nextLong()%9000L+1000L));
            
            String facility="";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            } else if(c2.isSelected()){
                facility = facility + "Internet Banking";
            } else if(c3.isSelected()){
                facility = facility + "Mobile Banking";
            } else if(c4.isSelected()){
                facility = facility + "E-mail & SMS Alerts";
            } else if(c5.isSelected()){
                facility = facility + "Cheque Book";
            } else if(c6.isSelected()){
                facility = facility + "E-Statement";
            }
            
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else if(cardnumber.equals("")){
                    JOptionPane.showMessageDialog(null,"Card Number is require");
                } else if(pinnumber.equals("")){
                    JOptionPane.showMessageDialog(null,"Pin Number is required");
                } else if(facility.equals("")){
                    JOptionPane.showMessageDialog(null,"Service Required must be filled");
                } else {
                    Conn conn = new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    conn.s.executeUpdate(query);
                    String query1 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";               
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n"+"Pin Number: "+pinnumber);
                  
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
                
            } catch(Exception e){
                System.out.println(e);
            }
                
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String args[])
    {
        new Signupthree("");
    }
    
}
