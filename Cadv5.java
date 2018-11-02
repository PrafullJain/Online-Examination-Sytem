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

import OES.Cint1.TimeClass;

import oracle.jdbc.driver.OracleResultSet;

public class Cadv5 extends JFrame implements WindowListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,ctlab;
	ButtonGroup grp1;
	JButton b;
	UIManager um;
	JRadioButton r1,r2,r3,r4;
	Font f1,f2;
	int count=90;
	Timer timer;
	public Cadv5()
	{ 		
		setTitle("Online Exam System");
		l1=new JLabel("***************************");
		l2=new JLabel("***************************");
		l3=new JLabel("Online Exam System");
		l4=new JLabel("Q.9)");
		l5=new JLabel();
		l6=new JLabel("Points:");
		l7=new JLabel();
		ctlab=new JLabel();
		
		l1.setBounds(600,30,360,70);
		l3.setBounds(510,60,400,70);
		l2.setBounds(600,90,360,70);
		l4.setBounds(26,190,360,70);
		l5.setBounds(58,190,790,70);
		l6.setBounds(1162,190,60,70);
		l7.setBounds(1212,190,30,70);
		


		
		grp1=new ButtonGroup();
		
		r1=new JRadioButton();
		r2=new JRadioButton();
		r3=new JRadioButton();
		r4=new JRadioButton();
		
		grp1.add(r1);grp1.add(r2);grp1.add(r3);grp1.add(r4);
		r1.setBounds(62,243,320,20);
		r2.setBounds(62,283,320,20);
		r3.setBounds(62,323,320,20);
		r4.setBounds(62,363,320,20);
		add(r1);add(r2);add(r3);add(r4);
		
		//CountDownTimer
				ctlab.setBounds(1162,130,200,50);
				ctlab.setText("Time left: "+count);
				TimeClass ct1=new TimeClass(count);
				timer=new Timer(1000,ct1);
				timer.start();
		
		b=new JButton("Result=>");
		b.setBounds(550,460,270,90);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cadvres.main(new String[]{});
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "prafull");
				if(r1.isSelected())
					{
						String q1="update cadv set uanswer='/+*-' where sno=7";
						Statement st3=con.createStatement();
						st3.executeUpdate(q1);
					}
				if(r2.isSelected())
					{
						String q2="update cadv set uanswer='*-+\' where sno=7";
						Statement st4=con.createStatement();
						st4.executeUpdate(q2);
					}
				if(r3.isSelected())
					{
						String q3="update cadv set uanswer='+-/*' where sno=7";
						Statement st5=con.createStatement();
						st5.executeUpdate(q3);
					}
				if(r4.isSelected())
					{
						String q4="update cadv set uanswer='*/+-' where sno=7";
						Statement st6=con.createStatement();
						st6.executeUpdate(q4);
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
			String query1="select * from cadv where R1='/+*-'";
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		addWindowListener(this);
		add(b);
		//Styling
				f1=new Font("Arial Black",Font.BOLD,12);
				f2=new Font("CASTELLAR",Font.BOLD,24);
				l3.setFont(f2);l4.setFont(f1);l5.setFont(f1);l6.setFont(f1);l7.setFont(f1);
				r1.setFont(f1);	r2.setFont(f1);	r3.setFont(f1);	r4.setFont(f1);
				l3.setForeground(Color.RED);
				
				b.setForeground(Color.BLUE);
				
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l6);
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
				timer.stop();
				Toolkit.getDefaultToolkit().beep();				
				ctlab.setText("Time is over now...");
				r1.setEnabled(false);r2.setEnabled(false);r3.setEnabled(false);r4.setEnabled(false);
				JOptionPane.showMessageDialog(Cadv5.this,"Your time is over now.But,you can move to another page");
			}
		}
	}
public static void main(String[] args) {
	Cadv5 c1=new Cadv5();
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