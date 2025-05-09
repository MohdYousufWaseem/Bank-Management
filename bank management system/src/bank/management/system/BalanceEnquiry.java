
package bank.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(310,404,150,25);
        back.addActionListener(this);
        image.add(back);
         
        int balance=0;
        Conn conn = new Conn();
        try{
            
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                } else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Current Account Balalnce is Rs "+ balance);
        text.setForeground(Color.WHITE);
        text.setBounds(180,250,400,20);
        image.add(text);
            
        setSize(800,700);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        
    }
    
    public static void main(String args[]){
        
        new BalanceEnquiry("");
    }
    
}
