
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener
{
    JButton login,clear,signup;
    JTextField cardnofield;
    JPasswordField pinnofield;
    Login()
    {
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card Number :");
        cardno.setFont(new Font("Raleway",Font.BOLD,16));
        cardno.setBounds(120,150,150,60);
        add(cardno);
        
        cardnofield = new JTextField();
        cardnofield.setBounds(300,170,230,30);
        cardnofield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardnofield);
        
        JLabel pin = new JLabel("Enter your pin :");
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(120,220,400,80);
        add(pin);
        
        pinnofield = new JPasswordField();
        pinnofield.setBounds(300,240,230,30);
        add(pinnofield);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,150);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardnofield.setText("");
            pinnofield.setText("");
            
        }else if(ae.getSource()== login){
            {
                Conn conn = new Conn();
                String cardnumber = cardnofield.getText();
                String pinnumber = pinnofield.getText();
                String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
                try{
                    ResultSet rs = conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number and Pin");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        } else if(ae.getSource() == signup){
            setVisible(false);
            new Signupone().setVisible(true);
            
        }
        
    }
            
public static void main(String args[])
{
    new Login();
}
}
