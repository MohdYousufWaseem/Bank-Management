
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener{
    
    JTextField pannumbertextfield,aadhartextfield;
    JButton next;
    JRadioButton senn,seny,enn,eny;
    JComboBox religion,categ,inco,edu,occu;
    String formno;
    
    Signuptwo(String formno){
        
        this.formno=formno;
        
        
        setLayout(null);
        
        setTitle("New Account Application Form Page No.-2");
        
        
        JLabel additionaldet = new JLabel("Page 2 : Additional Details");
        additionaldet.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldet.setBounds(290,80,400,40);
        add(additionaldet);
        
        JLabel religion1 = new JLabel("Religion: ");
        religion1.setFont(new Font("Raleway",Font.BOLD,20));
        religion1.setBounds(100,140,100,30);
        add(religion1);
        
        String valreligion[] = {"","Hindu","Muslim","Christianity","Sikh","Others"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,180,200,30);
        add(category);
        
        String valcategory[] = {"","General","OBC","EWS","PH","SC","ST","Others"};
        categ = new JComboBox(valcategory);
        categ.setBounds(300,180,400,30);
        categ.setBackground(Color.WHITE);
        add(categ);
        
        
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,220,200,30);
        add(income);
        
        String inc[] = {"","<100000","100000-200000","200000-500000","500000-700000","700000-1000000",">1000000"};
        inco = new JComboBox(inc);
        inco.setBounds(300,220,200,30);
        inco.setBackground(Color.WHITE);
        add(inco);
        
        
        JLabel education = new JLabel("Education: ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,260,400,30);
        add(education);
        
        String educ[] = {"","High School","Intermediate","Graduation","Post-Graduation","Doctrate","Others"};
        edu = new JComboBox(educ);
        edu.setBounds(300,260,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);
        
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,300,400,30);
        add(occupation);
        
        String occup[] = {"","Salaried","self-Employed","Business","Student","Retired","Others"};
        occu = new JComboBox(occup);
        occu.setBounds(300,300,400,30);
        occu.setBackground(Color.WHITE);
        add(occu);
        
        JLabel pannumber = new JLabel("Pan Number");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20));
        pannumber.setBounds(100,340,400,30);
        add(pannumber);
        
        pannumbertextfield = new JTextField();
        pannumbertextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pannumbertextfield.setBounds(300,340,400,30);
        add(pannumbertextfield);
        
        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,380,400,30);
        add(aadhar);
        
        aadhartextfield = new JTextField();
        aadhartextfield.setFont(new Font("Raleway",Font.BOLD,14));
        aadhartextfield.setBounds(300,380,400,30);
        add(aadhartextfield);
        
        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,420,400,30);
        add(senior);
        
        seny = new JRadioButton("Yes");
        seny.setBounds(300,420,100,30);
        seny.setBackground(Color.WHITE);
        add(seny);
        
        senn = new JRadioButton("No");
        senn.setBounds(400,420,300,30);
        senn.setBackground(Color.WHITE);
        add(senn);
        
        ButtonGroup group = new ButtonGroup();
        group.add(seny);
        group.add(senn);
        
        JLabel exist = new JLabel("Existing Account: ");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBounds(100,460,400,30);
        add(exist);
        
        eny = new JRadioButton("Yes");
        eny.setBounds(300,460,100,30);
        eny.setBackground(Color.WHITE);
        add(eny);
        
        enn = new JRadioButton("No");
        enn.setBounds(400,460,300,30);
        enn.setBackground(Color.WHITE);
        add(enn);
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(eny);
        group1.add(enn);
        
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
        String sreligion = (String) religion.getSelectedItem();
        String category = (String) categ.getSelectedItem();
        String income = (String) inco.getSelectedItem();
        String education = (String) edu.getSelectedItem();
        String occupation = (String) occu.getSelectedItem();
        String senior = null;
        if(seny.isSelected()){
            senior  = "Yes";
        } else if(senn.isSelected()){
            senior  = "No";
        }
        String pan = pannumbertextfield.getText();
        String existing = null;
        if(eny.isSelected()){
            existing = "Yes";
        } else if(enn.isSelected()){
            existing = "No";
        }
        
        String aadhaar = aadhartextfield.getText();
        
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null,"Religion is Required");
            } else if(category.equals("")){
                JOptionPane.showMessageDialog(null,"Category is Required");
            } else if(income.equals("")){
                JOptionPane.showMessageDialog(null,"Incoome is Required");
            } else if(education.equals("")){
                JOptionPane.showMessageDialog(null,"Education is Required");
            } else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null,"Occupation is Required");
            } else if(senior.equals("")){
                JOptionPane.showMessageDialog(null,"Senior Citizen Confirmation is Required");
            } else if(existing.equals("")){
                JOptionPane.showMessageDialog(null,"Existing Account Confirmation is Required");
            } else if(pan.equals("")){
                JOptionPane.showMessageDialog(null,"Pannumber is Required");
            } else if(aadhaar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhaar+"','"+senior+"','"+existing+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signupthree(formno).setVisible(true);
            }
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new Signuptwo("");
    }
    
}
