package OES;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.UIManager;

import oracle.jdbc.driver.OracleResultSet;

public class Cbeg4 extends JFrame  implements WindowListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,ctlab;
	ButtonGroup grp1,grp2;
	UIManager um;
	JButton b1,b2;
	JRadioButton r1,r2,r3,r4,r5,r6,r7,r8;
	Font f1,f2;
	int count=90;
	Timer timer;
	public Cbeg4()
	{ 
		setTitle("Online Exam System");
		l1=new JLabel("***************************");
		l2=new JLabel("***************************");
		l3=new JLabel("Online Exam System");
		l4=new JLabel("Q.7)");
		l5=new JLabel();
		l6=new JLabel("Points:");
		l7=new JLabel();
		l8=new JLabel("Q.8)");
		l9=new JLabel();
		l10=new JLabel("Points:");
		l11=new JLabel();
		ctlab=new JLabel();

		
		l1.setBounds(600,30,360,70);
		l3.setBounds(510,60,400,70);
		l2.setBounds(600,90,360,70);
		l4.setBounds(26,190,360,70);
		l5.setBounds(58,190,490,70);
		l6.setBounds(1162,190,60,70);
		l7.setBounds(1212,190,30,70);
		l8.setBounds(26,390,360,70);
		l9.setBounds(58,390,490,70);
		l10.setBounds(1162,390,60,70);
		l11.setBounds(1212,390,60,70);

		//CountDown Timer
		ctlab.setBounds(1092,130,200,50);
		ctlab.setText("Time left: "+count);
		TimeClass ct=new TimeClass(count);
		timer=new Timer(1000,ct);
		timer.start();

		
		grp1=new ButtonGroup();
		
		r1=new JRadioButton();
		r2=new JRadioButton();
		r3=new JRadioButton();
		r4=new JRadioButton();
		
		grp1.add(r1);grp1.add(r2);grp1.add(r3);grp1.add(r4);
		r1.setBounds(62,243,250,20);
		r2.setBounds(62,283,250,20);
		r3.setBounds(62,323,250,20);
		r4.setBounds(62,363,250,20);
		add(r1);add(r2);add(r3);add(r4);
		
		grp2=new ButtonGroup();
		r5=new JRadioButton();
		r6=new JRadioButton();
		r7=new JRadioButton();
		r8=new JRadioButton();
		
		grp2.add(r5);grp2.add(r6);grp2.add(r7);grp2.add(r8);
		r5.setBounds(62,443,250,20);
		r6.setBounds(62,483,250,20);
		r7.setBounds(62,523,250,20);
		r8.setBounds(62,563,250,20);
		add(r5);add(r6);add(r7);add(r8);
		
		b1=new JButton("<=Prev");
		b1.setBounds(130,620,150,50);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cbeg3.main(new String[]{});
			}
		});
		
		b2=new JButton("Next=>");
		b2.setBounds(1050,620,150,50);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cbeg5.main(new String[]{});
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "prafull");
				if(r1.isSelected())
					{
						String q1="update cbeg set uanswer='Sequential' where sno=1";
						Statement st3=con.createStatement();
						st3.executeUpdate(q1);
					}
				if(r2.isSelected())
					{
						String q2="update cbeg set uanswer='Random' where sno=1";
						Statement st4=con.createStatement();
						st4.executeUpdate(q2);
					}
				if(r3.isSelected())
					{
						String q3="update cbeg set uanswer='Sequential & Random' where sno=1";
						Statement st5=con.createStatement();
						st5.executeUpdate(q3);
					}
				if(r4.isSelected())
					{
						String q4="update cbeg set uanswer='None of the above' where sno=1";
						Statement st6=con.createStatement();
						st6.executeUpdate(q4);
					}
				if(r5.isSelected())
				{
					String q5="update cbeg set uanswer='Create a type of function' where sno=5";
					PreparedStatement pst9=con.prepareStatement(q5);
					pst9.executeUpdate();
				}
				if(r6.isSelected())
				{
					String q6="update cbeg set uanswer='Define the type of function' where sno=5";
					PreparedStatement pst10=con.prepareStatement(q6);
					pst10.executeUpdate();
				}if(r7.isSelected())
				{
					String q7="update cbeg set uanswer='Define the type of variable' where sno=5";
					PreparedStatement pst11=con.prepareStatement(q7);
					pst11.executeUpdate();
				}if(r8.isSelected())
				{
					String q8="update cbeg set uanswer='Create a datatype name' where sno=5";
					PreparedStatement pst12=con.prepareStatement(q8);
					pst12.executeUpdate();
				}
			}
				catch(Exception ae)
				{
					ae.getStackTrace();
				}
				}
			});
		try
		{				

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "prafull");
			String query1="select * from cbeg where R1='Sequential'";
			PreparedStatement pst1=con.prepareStatement(query1);
			OracleResultSet rs1=(OracleResultSet) pst1.executeQuery(query1);			
		
			while(rs1.next())
			{				
				l5.setText(rs1.getString("Questions"));
				l7.setText(rs1.getString("MARKS"));
				r1.setText(rs1.getString("R1"));
				r2.setText(rs1.getString("R2"));
				r3.setText(rs1.getString("R3"));
				r4.setText(rs1.getString("R4"));
			}
			rs1.close();
			String query2="select * from cbeg where R1='Create a type of function'";
			PreparedStatement pst2=con.prepareStatement(query2);
			OracleResultSet rs2=(OracleResultSet) pst2.executeQuery(query2);			
			while(rs2.next())
			{
				l9.setText(rs2.getString("Questions"));
				l11.setText(rs2.getString("MARKS"));
				r5.setText(rs2.getString("R1"));
				r6.setText(rs2.getString("R2"));
				r7.setText(rs2.getString("R3"));
				r8.setText(rs2.getString("R4"));
			}		
		rs2.close();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		addWindowListener(this);
		add(b1);add(b2);
		//Styling
				f1=new Font("Arial Black",Font.BOLD,12);
				f2=new Font("CASTELLAR",Font.BOLD,24);
				l3.setFont(f2);l4.setFont(f1);l5.setFont(f1);l6.setFont(f1);l7.setFont(f1);
				l8.setFont(f1);l9.setFont(f1);l10.setFont(f1);l11.setFont(f1);
				r1.setFont(f1);	r2.setFont(f1);	r3.setFont(f1);	r4.setFont(f1);
				r5.setFont(f1);	r6.setFont(f1);	r7.setFont(f1);	r8.setFont(f1);
				l3.setForeground(Color.RED);
				
				b1.setForeground(Color.BLUE);b2.setForeground(Color.MAGENTA);
				
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l6);add(l8);add(l9);add(l10);add(l11);
		add(ctlab);
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/OES/Pics/index.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public class TimeClass implements ActionListener{
		int counter;
		public TimeClass(int counter) {
			this.counter=counter;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			counter--;
			if(counter>=0)
			{
				ctlab.setText("Time left: "+counter+" seconds");
			}
			else
			{
			    ((javax.swing.Timer) timer).stop();
				Toolkit.getDefaultToolkit().beep();				
				ctlab.setText("Time is over now...");
				r1.setEnabled(false);r2.setEnabled(false);r3.setEnabled(false);r4.setEnabled(false);
				r5.setEnabled(false);r6.setEnabled(false);r7.setEnabled(false);r8.setEnabled(false);
				//b1.setEnabled(true);b2.setEnabled(true);
				JOptionPane.showMessageDialog(Cbeg4.this,"Your time is over now.But,you can move to another page");
			}
		}
	}
public static void main(String[] args) {
	Cbeg4 c1=new Cbeg4();
	setDefaultLookAndFeelDecorated(true);
}


@Override
public void windowOpened(WindowEvent e) {}@Override
public void windowClosing(WindowEvent e) {
	um.put("Panel.background", Color.BLACK);
	um.put("OptionPane.messageForeground",Color.green);
	um.put("OptionPane.minimumSize",new Dimension(500,290));
	final String msg=
			"<html><big>Thank you for using <u>Online-Examination System</u></big><hr><hr>"
			+"<p align=right><font size=7>Developed by a Prafull Jain!</font>"
			+"<hr><p align=left><font size=5>I Used Java jdk-1.7 to compile the source code.</font><br><br>"
			+"<hr><font size=5>Ur Comments as well as bug reports r very welcome at</font><p align=center>"
			+"<hr><em><big>prafulljaincp@gmail.com</big></em><hr>"
			+"<hr><em><font size=7>Other Links:-</font><br><hr><big>Gmail:-2016csprafull4817@poornima.edu.in</big></em><hr><br>"
			+"<hr><em><font size=6><big>GitHub:-github.com/PrafullJain/</big></font></em><hr><br></html>";

	ImageIcon icon=new ImageIcon("src/OES/Pics/Developer.jpg");
	Image ic1=icon.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_DEFAULT);			
	ImageIcon icon1=new ImageIcon(ic1);
	JOptionPane.showMessageDialog(this,msg,"Dedicated for U Guys",JOptionPane.PLAIN_MESSAGE,icon1);
}@Override
public void windowClosed(WindowEvent e) {
}@Override
public void windowIconified(WindowEvent e) {
}@Override
public void windowDeiconified(WindowEvent e) {
}@Override
public void windowActivated(WindowEvent e) {
}@Override
public void windowDeactivated(WindowEvent e) {
}
}

