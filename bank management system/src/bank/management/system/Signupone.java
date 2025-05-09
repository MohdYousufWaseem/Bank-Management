
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{
    
    long random;
    JTextField nametextfield,fathernametextfield,dobtextfield,eaddresstextfield,addresstextfield,pincodetextfield,citytextfield,statetextfield;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser date;
    Signupone(){
        
        Random ran = new Random();
        //System.out.println(ran);
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        setLayout(null);
        
        JLabel formno = new JLabel("Application Form Number "  + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personaldet = new JLabel("Page 1 : Personal Details");
        personaldet.setFont(new Font("Raleway",Font.BOLD,22));
        personaldet.setBounds(290,80,400,40);
        add(personaldet);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametextfield = new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);
        
        JLabel fathername = new JLabel("Father Name: ");
        fathername.setFont(new Font("Raleway",Font.BOLD,20));
        fathername.setBounds(100,180,200,30);
        add(fathername);
        
        fathernametextfield = new JTextField();
        fathernametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fathernametextfield.setBounds(300,180,400,30);
        add(fathernametextfield);
        
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300,220,400,30);
        date.setForeground(Color.BLACK);
        add(date);
        
        dobtextfield = new JTextField();
        dobtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        dobtextfield.setBounds(300,140,200,30);
        add(dobtextfield);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,260,100,30);
        add(gender);
        
        male =new JRadioButton("Male");
        male.setBounds(300,260,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female =new JRadioButton("Female");
        female.setBounds(500,260,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("E-mail: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,300,100,30);
        add(email);
        
        eaddresstextfield = new JTextField();
        eaddresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        eaddresstextfield.setBounds(300,300,400,30);
        add(eaddresstextfield);
        
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,340,200,30);
        add(marital);
        
        married =new JRadioButton("Married");
        married.setBounds(300,340,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried =new JRadioButton("Unmarried");
        unmarried.setBounds(450,340,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        others =new JRadioButton("Others");
        others.setBounds(600,340,100,30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,380,100,30);
        add(address);
        
        addresstextfield = new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(300,380,400,30);
        add(addresstextfield);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,420,100,30);
        add(city);
        
        citytextfield = new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(300,420,400,30);
        add(citytextfield);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,460,100,30);
        add(state);
        
        statetextfield = new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(300,460,400,30);
        add(statetextfield);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,500,100,30);
        add(pincode);
        
        pincodetextfield = new JTextField();
        pincodetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pincodetextfield.setBounds(300,500,400,30);
        add(pincodetextfield);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(630,560,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,650);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nametextfield.getText();
        String fathername  = fathernametextfield.getText();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender  = "Male";
        } else if(female.isSelected()){
            gender  = "Female";
        }
        String email = eaddresstextfield.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unamrried";
        } else if(others.isSelected())
        {
            marital = "Others";
        }
        String address = addresstextfield.getText();
        String city = citytextfield.getText();
        String state = statetextfield.getText();
        String pin = pincodetextfield.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            } else if(fathername.equals("")){
                JOptionPane.showMessageDialog(null,"Fathername is Required");
            } else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date Of Birth is Required");
            } else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is Required");
            } else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            } else if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status is Required");
            } else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            } else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            } else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            } else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"PinCode is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new Signupone();
    }
    
}
