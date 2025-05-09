
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(230,230,400,20);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(145,280,400,20);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(295,280,150,20);
        image.add(pin);
        
        JLabel repintext = new JLabel("Change Your PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(145,330,400,20);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(295,330,150,20);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(310,378,150,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(310,404,150,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,700);
        setLocation(300,0);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin = pin.getText();
            String nrepin = repin.getText();
            if(!npin.equals(nrepin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter PIN");
            }
            
            if(nrepin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pinnumber = '"+nrepin+"'where pinnumber = '"+pinnumber+"'";
            String query2 = "update login set pinnumber = '"+nrepin+"'where pinnumber = '"+pinnumber+"'";
            String query3 = "update signupthree set pinnumber = '"+nrepin+"'where pinnumber = '"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"PIN Changes Successfully");
            
            setVisible(false);
            new Transaction(nrepin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
    
}
