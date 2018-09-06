
package regformapp;



import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.HeadlessException;

import java.awt.event.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

class Frame1 extends JFrame implements ActionListener{
    
    
    
    String ID,NAME,FATHERNAME,Gender,ADDRESS,EMAILID,PHONENUMBER;
    
    
    int STUDENTID;

    
    JTextField studentid_txt,name_txt,fname_txt,add_txt,phone_txt,email_txt;
  
JLabel gender_lbl,studentid_lbl,name_lbl,fname_lbl,add_lbl,phone_lbl,email_lbl;

JRadioButton male,female;

ButtonGroup gender_grp;

JTextArea add_txtArea;

JButton btn;

JFrame frame;

Container c;
public Frame1(){




//creating JLabel for Heading
Font Fo=new Font("Arial",Font.BOLD,20);

JLabel heading_lbl=new JLabel();
heading_lbl.setBounds(900,5,2000,40);
heading_lbl.setText("<html><font><u><b>Registration Form:-</b></u></font></html>");

heading_lbl.setFont(Fo);


//creating Flobal Font style for all components
Font f1=new Font("Arial",Font.BOLD,14);
//-----------------------------------------------------------------

studentid_lbl=new JLabel("StudentID : ");
studentid_lbl.setBounds(50,80,100,30);

studentid_txt=new JTextField();
studentid_txt.setBounds(180,80,180,30);

//-----------------------------------------------------------------
//creating JLabel for Name
name_lbl=new JLabel("Name : ");
name_lbl.setBounds(50,120,100,30);

name_txt=new JTextField();
name_txt.setBounds(180,120,180,30);
//-----------------------------------------------------------------
fname_lbl=new JLabel("Father Name : ");
fname_lbl.setBounds(50,160,100,30);

fname_txt=new JTextField();
fname_txt.setBounds(180,160,180,30);
//------------------------------------------------------------------
gender_lbl=new JLabel("Gender : ");
gender_lbl.setBounds(50,200,100,30);

//------------------------------------------------------------------
Cursor cur=new Cursor(Cursor.HAND_CURSOR);
//------------------------------------------------------------------

male=new JRadioButton("male");
male.setBounds(180,200,70,30);
//male.setBackground(Color.yellow);
male.setCursor(cur);
//------------------------------------------------------------------

female=new JRadioButton("female");
female.setBounds(280,200,80,30);
//female.setBackground(Color.yellow);
female.setCursor(cur);
//-------------------------------------------------------------------

gender_grp=new ButtonGroup();
gender_grp.add(male);
gender_grp.add(female);

//--------------------------------------------------------------------

/*JLabel dob_lbl=new JLabel("Date of birth : ");
dob_lbl.setBounds(50,200,100,30);

String day_arr[]=new String[31];

for(int i=1;i<=31;i++)

day_arr[i-1]=Integer.toString(i);

JComboBox date=new JComboBox(day_arr);
date.setBounds(180,200,40,30);

String month_arr[]={"jan","feb","march","april","may","june","july","aug","sept","oct","nov","dec"};
JComboBox month=new JComboBox(month_arr);
month.setBounds(230,200,40,30);

String year_arr[]=new String[70];
for(int i=1951;i<=2020;i++)
year_arr[i-1951]=Integer.toString(i);

JComboBox year=new JComboBox(year_arr);
year.setBounds(300,200,40,30);
*/
//------------------------------------------------------------------------

// Creating JLabel for the Address
 add_lbl=new JLabel("Address : ");
 add_lbl.setBounds(50,240,100,30); 
 
 // Creating JTextArea for the address
 add_txtArea= new JTextArea();
 add_txtArea.setBounds(180,240,180,100);

//--------------------------------------------------------------------------

//Creating JLabel for the phone
 phone_lbl=new JLabel("Phone No. : ");
 phone_lbl.setBounds(50,350,100,30);
 
 // Creating JTextField for the phone
 phone_txt=new JTextField();
 phone_txt.setBounds(180,350,180,30);
 //---------------------------------------------------------------------------
 //  Creating JLabel for the Email
 email_lbl=new JLabel("Email : ");
 email_lbl.setBounds(50,390,100,30);
 
 // Creating JTextField for the Email
 email_txt=new JTextField();
 email_txt.setBounds(180,390,180,30);

//------------------------------------------------------------------------------

btn=new JButton("SaveRecord");
btn.addActionListener(this);
btn.setBounds(50, 420,100,30);

//create a frame using JFrame class
frame=new JFrame("Registration Form:");
frame.setVisible(true);
frame.setBounds(200,100,700,600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//setting background color of Frame

c=frame.getContentPane();
c.setLayout(null);
c.setBackground(Color.BLUE);

studentid_lbl.setFont(f1);
name_lbl.setFont(f1);
fname_lbl.setFont(f1);
gender_lbl.setFont(f1);
//dob_lbl.setFont(f1);
add_lbl.setFont(f1);
phone_lbl.setFont(f1);
email_lbl.setFont(f1);

studentid_txt.setFont(f1);
 name_txt.setFont(f1);
 fname_txt.setFont(f1);
 male.setFont(f1);
 female.setFont(f1);
phone_txt.setFont(f1);
email_txt.setFont(f1);

c.add(heading_lbl);
c.add(name_lbl);
c.add(fname_lbl);
c.add(gender_lbl);
c.add(male);
c.add(female);
//c.add(dob_lbl);
c.add(add_lbl);
c.add(phone_lbl);
c.add(email_lbl);
c.add(studentid_lbl);

c.add(studentid_txt);
c.add(name_txt);
c.add(fname_txt);
//c.add(date);
//c.add(month);
//c.add(year);
c.add(add_txtArea);
c.add(phone_txt);
c.add(email_txt);
c.add(btn);


}

@Override
public void actionPerformed (ActionEvent e) {
    
try{
    
  
        
     //DriverManager.registerDriver(new  SQLServerDriver());
 
//Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/celes","celestin","celestin10");
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//Connection con=DriverManager.getConnection("jdbc:odbc:myconnection ");

Connection con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TP9QDE1;databaseName=celes;user=sa;password=celestin10");
PreparedStatement p =  con.prepareStatement("insert into REGFORM values (?,?,?,?,?,?)");
STUDENTID =Integer.parseInt(studentid_txt.getText());

//ID =studentid_txt.getText();
Gender = "male";
if(female.isSelected()==true)
    Gender="female";
NAME = name_txt.getText();

FATHERNAME = fname_txt.getText();
ADDRESS = add_txtArea.getText();
PHONENUMBER = phone_txt.getText();
EMAILID = email_txt.getText();

//STUDENTID=Integer.parseInt(ID);
//PHONENUMBER=Integer.parseInt(contact);

System.out.println(STUDENTID);
System.out.println(NAME);
System.out.println(FATHERNAME);
System.out.println(Gender);
System.out.println(ADDRESS);
System.out.println(PHONENUMBER);
System.out.println(EMAILID);

p.setInt(1, STUDENTID);
p.setString(2, NAME);
p.setString(3, FATHERNAME);
p.setString(4, ADDRESS);
p.setString(5, PHONENUMBER);
p.setString(6, EMAILID);

p.executeUpdate();
JOptionPane.showMessageDialog(rootPane, "Record Saved Successfully !");

}
catch (HeadlessException | NumberFormatException | SQLException ex ){
System.out.println(ex);
}
}

   

}
public class RegFormApp {

    
    public static void main(String[] args) {
       Frame1 f=new Frame1();
    }
    
}
