
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setTitle("Mini Statament");
        
        
        setLayout(null);
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bank  = new JLabel("State Bank Of India");
        bank.setBounds(80,10,200,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(10,30,200,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(10,80,400,200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(10,250,400,100);
        add(balance);
        balance.setText("HI");
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal=0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date")  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"  + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                        bal = bal + Integer.parseInt(rs.getString("amount"));
                    }else 
                        bal = bal - Integer.parseInt(rs.getString("amount"));
            } 
            balance.setText("Your Current Account Balance is Rs "+bal);

        }catch(Exception e){
            
            System.out.println(e);
        }
        setSize(500,500);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        
        new MiniStatement("");
    }
    
}
