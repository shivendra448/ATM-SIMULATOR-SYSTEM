package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    SignupTwo(String formno) {
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
        
        JLabel additonalDetails = new JLabel("Page 2: Additional Details ");
        additonalDetails.setFont(new Font("Raleway" , Font.BOLD , 20));
        additonalDetails.setBounds(300,50,400,30);
        add(additonalDetails);
        
        JLabel rel = new JLabel("Religion: ");
        rel.setFont(new Font("Raleway" , Font.BOLD , 17));
        rel.setBounds(100,110,100,30);
        add(rel);
        
        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300,110,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel  cat = new JLabel("Category: ");
        cat.setFont(new Font("Raleway" , Font.BOLD , 17));
        cat.setBounds(100,150,200,30);
        add(cat);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category .setBounds(300,150,400,30);
        category.setBackground(Color.WHITE);
        add(category );
        
        JLabel incom = new JLabel("Income: ");
        incom.setFont(new Font("Raleway" , Font.BOLD , 17));
        incom.setBounds(100,190,200,30);
        add(incom);
        
        String incomecategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,190,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway" , Font.BOLD , 17));
        educational.setBounds(100,230,200,30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway" , Font.BOLD , 17));
        qualification.setBounds(100,260,200,30);
        add(qualification);
        
        String educationvalues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctorate","Others"};
        education = new JComboBox(educationvalues);
        education.setBounds(300,240,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        
        JLabel occu = new JLabel("Occupation: ");
        occu.setFont(new Font("Raleway" , Font.BOLD , 17));
        occu.setBounds(100,310,200,30);
        add(occu);
        
        String occupationvalues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300,310,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
       
        JLabel panno = new JLabel("PAN Number: ");
        panno.setFont(new Font("Raleway" , Font.BOLD , 17));
        panno.setBounds(100,350,200,30);
        add(panno);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD ,14));
        pan.setBounds(300,350,400,30);
        add(pan);
        
        JLabel aadharnumber = new JLabel("Aadhar Number: ");
        aadharnumber.setFont(new Font("Raleway" , Font.BOLD , 17));
        aadharnumber.setBounds(100,390,200,30);
        add(aadharnumber);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD ,14));
        aadhar.setBounds(300,390,400,30);
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("Raleway" , Font.BOLD , 17));
        seniorcitizen.setBounds(100,430,200,30);
        add(seniorcitizen );
        
        syes = new JRadioButton ("YES");
        syes.setBounds(300,430,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton ("NO");
        sno.setBounds(450,430,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);
        
        
        JLabel existingaccount = new JLabel("Existing Account: ");
        existingaccount.setFont(new Font("Raleway" , Font.BOLD , 17));
        existingaccount.setBounds(100,470,200,30);
        add(existingaccount );
        
        eyes = new JRadioButton ("YES");
        eyes.setBounds(300,470,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton ("NO");
        eno.setBounds(450,470,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup  egroup= new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,530,80,30);
        next.addActionListener(this);
        add(next);
        
        
         getContentPane().setBackground(Color.WHITE);
        
         setSize(800,650);
         setLocation(300,15);
         setVisible(true);
    }
    
    public void  actionPerformed(ActionEvent ae) {
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
                
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        
      
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        }  else if (eno.isSelected()) {
            existingaccount = "No";
        }  
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try  {
               Conn c = new Conn();
               String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
               c.s.executeUpdate(query);
               
               //Signup3 object
               setVisible(false);
               new SignupThree(formno).setVisible(true);  
        }      catch ( Exception e) {
               System.out.println(e);
        }
        
    }

   public static void main(String args[]) {
       new SignupTwo("");
   
    }
}
