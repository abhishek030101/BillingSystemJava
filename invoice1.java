import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.util.*;
import java.io.*;
import java.text.*;

class frame1 extends JFrame implements ActionListener, ItemListener
 {
      
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1,tf3,tf5,tf7;
    JTextArea ta1; 
    JButton b1,b2,b3,b4,b5;
    JComboBox cb1,cb2,cb3;
   String filename="data.csv";
   String s7,s8;
   String totaldata[];
   int result1[],v,result=0,i=0,dummy;
   frame1()
 {    
      Font f = new Font("Times New Roman",Font.BOLD,18);
     /* Toolkit t=Toolkit.getDefaultToolkit();
      Dimension d=t.getScreenSize();
	 
      Image i=t.getImage("pp.jpg");
      setIconImage(i);*/
      Color c = new Color(98,217,217);
      setBackground(c);

   l1 = new JLabel("Enter name");
   l1.setBounds(30,50,150,20);
   add(l1);
  
   l2 = new JLabel(" Product");  
   l2.setBounds(400,50,100,20);
   add(l2); 
     
   l3 = new JLabel("rate");  
   l3.setBounds(400,100,100,20);
   add(l3);
  
    l4 = new JLabel("Qty");
    l4.setBounds(400,150,100,20);
    add(l4);
    
    l5 = new JLabel("contact no");
    l5.setBounds(30,100,150,20);
    add(l5);	
   
    l5 = new JLabel("city");
    l5.setBounds(30,150,150,20);
    add(l5);	
   
    String s[]={"keyboard","mouse","desktop","printer","scanner","pendrive"} ; 
    
	cb1 = new JComboBox(s);
    cb1.setBounds(500,50,150,20); 
    cb1.addItemListener(this); 
    add(cb1);
  
  String s1[]={"1","2","3","4","5","6","7","8","9","10"} ; 
   cb2 = new JComboBox(s1);
   cb2.setBounds(500,150,100,20);
   add(cb2);
   
    String s5[]={"indore","bhopal","delhi","gurgaon","mumbai"} ; 
    cb3 = new JComboBox(s5);
    cb3.setBounds(140,150,100,20);
    add(cb3);
    cb3.addItemListener(this); 
  
   tf1 = new JTextField();
   tf1.setBounds(140,50,200,20);     //name
   add(tf1);
   
   tf3 = new JTextField();
   tf3.setBounds(500,100,100,20);  //charge
   add(tf3);  
   tf5 = new JTextField();
   tf5.setBounds(800,50,100,20);     //total
   add(tf5);
   
   tf7= new JTextField();
   tf7.setBounds(140,100,200,20);    //contact no
   add(tf7);
   
    b1 = new JButton("cost");
    b1.setBounds(700,50,80,20);
    add(b1);
    b1.addActionListener(this);
    
    b2 = new JButton("add product");
    b2.setBounds(700,100,200,20);
    add(b2);
    b2.addActionListener(this);
	
	b3 = new JButton("details");
    b3.setBounds(260,150,80,20);
    add(b3);
    b3.addActionListener(this);
	
	b4 = new JButton("calculate");
    b4.setBounds(1100,150,90,20);
    add(b4);
    b4.addActionListener(this);
		
	b5 = new JButton("print");
    b5.setBounds(1200,150,80,20);
    add(b5);
    b5.addActionListener(this);
     
    ta1=new JTextArea();
    ta1.setBounds(20,200,1400,450);   
    ta1.setFont(f);
	add(ta1);
//------------code for taking input from .csv file--------------------//
try{
    File filedata =new File(filename);
    Scanner inputstream=new Scanner(filedata);
    inputstream.next();
  
     while(inputstream.hasNext())
        {
         String data=inputstream.next();
      //   String values=data.split(",");
 		 System.out.println(data);

        }

 inputstream.close();
   }
catch(Exception e){}
//------------------------------------------//

//--------------code for date and time-----------//

SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy  HH:mm:ss");
		 Date date = new Date();
	   s7	= (""+sdf.format(date));
	//----------------------------------------//	


 }   
    //listeners//
public void actionPerformed(ActionEvent e)
 {   if(e.getSource()==b1)
	 {
      try
	        {
            String s3 =tf3.getText();
            String s4=(String)cb2.getSelectedItem();
            int x =Integer.parseInt(s3);
            int y=Integer.parseInt(s4);
            int z= x*y;
            String s5 =""+z;
        	 tf5.setText(s5);
			++i;
		                                        //code for evaluating amount
	           for(v=1;v<=i;v++)  
	           {
	            	totaldata[v]=tf3.getText();
	            	String demovalue=totaldata[v];
		         result1[v]=Integer.parseInt(demovalue);
               	}
	 }
	 catch(Exception c){}
	 }
	 
	   if(e.getSource()==b3)
	   {
	    ta1.append("Customer name:-"+tf1.getText()+","+"\n"+"contact:-"+tf7.getText()+","+"\n"+"city:-"
		                              +(String)cb3.getSelectedItem()+"\t\t\t\t\t\t\t\t\t"+(s7)+"."+"\n\n");
        ta1.append("Product name"+"\t\t"+"Qty"+"\t\t"+"Rate(per nos)"+"\t\t"+" Charges"
		                 +"\n");
	   }
	    if(e.getSource()==b2)
		{
		ta1.append((String)cb1.getSelectedItem()+"\t\t"+(String)cb2.getSelectedItem()+"\t\t"+tf3.getText()+"\t\t"+
		                      tf5.getText()+"\n");	
		}				  
			 if(e.getSource()==b5)
		{
		//-------------code for printing invoice--------------//
                MessageFormat Header = new MessageFormat("invoice");
               MessageFormat Footer=new MessageFormat("page{0,number,integer}");
            try
        {
	            ta1.print(Header,Footer);
         }
         catch(Exception u){}
		}
//--------------------------------------------------------------//
      //-----code for calculating the total values-----------------//
  
  try{
    if(e.getSource()==b4)
		{ for(v=1;v<=i;v++)
		 dummy=result1[v];
     	result=result+dummy;
	  ta1.append("\n\n\n\n\t\t\t\t"+""+result);
		}				  
  }
  catch(Exception d){}
  } 
public void itemStateChanged(ItemEvent e)
  {
	//1
  if(cb1.getSelectedItem()== "keyboard")
	 {
		 tf3.setText("850");
	 }
	 //2
  if(cb1.getSelectedItem()== "mouse")
	 {
		 tf3.setText("550");
	 }
	 //3
  if(cb1.getSelectedItem()== "pc")
	 {
		 tf3.setText("22000");
	 }
   //4
   if(cb1.getSelectedItem()== "desktop")
	 {
		 tf3.setText("22000");
	 }
   //5
   if(cb1.getSelectedItem()== "printer")
	 {
		 tf3.setText("20000");
	 }
	  //6
   if(cb1.getSelectedItem()=="scanner")
    {
	 tf3.setText("15000");
	 }
	  //7
   if(cb1.getSelectedItem()== "pendrive")
	 {
		 tf3.setText("500");
	 }  
	

  }
 }
class invoice1
{
 public static void main(String args[])
  {
	
    frame1 f = new frame1();
    f.setLayout(null);
    f.setVisible(true); 
    f.setSize(1500,800);
    f.setLocation(0,0); 
   }
}
