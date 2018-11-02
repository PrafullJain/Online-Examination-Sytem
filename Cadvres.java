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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import oracle.jdbc.driver.OracleResultSet;
public class Cadvres extends JFrame implements WindowListener{
	JButton b,chekbtn;
	UIManager um;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	static JLabel l13;
	static int c=0;
	Font f1,f2;

	Cadvres()
	{		
		setTitle("Online Exam System");
		l1=new JLabel("***************************");
		l2=new JLabel("***************************");
		l3=new JLabel("Online Exam System");
		l4=new JLabel("Your Course Name:");
		l5=new JLabel("C");
		l6=new JLabel("Your Course Level:");
		l7=new JLabel("Advance");
		l8=new JLabel("Total Marks:");
		l9=new JLabel("50");
		l10=new JLabel("Your Marks:");
		l11=new JLabel();
		l12=new JLabel("Your Correct Answers:");
		l13=new JLabel();
		
		
		l1.setBounds(600,30,360,70);
		l3.setBounds(510,60,400,70);
		l2.setBounds(600,90,360,70);
		
		l4.setBounds(70,190,190,70);
		l5.setBounds(230,190,60,70);
		l6.setBounds(70,260,190,70);
		l7.setBounds(230,260,160,70);
		l8.setBounds(70,330,110,70);
		l9.setBounds(200,330,60,70);
		l10.setBounds(70,400,110,70);
		l11.setBounds(200,400,60,70);
		l12.setBounds(70,470,180,70);
		l13.setBounds(240,470,60,70);
		
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);
		add(l8);add(l9);add(l10);add(l11);add(l12);add(l13);
		addWindowListener(this);
		chekbtn=new JButton("Check Your Answers");
		chekbtn.setBounds(180,590,200,60);
		chekbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			cheadvans1.main(new String[]{});	
			}
		});
		
		b=new JButton("Go To Home=>");
		b.setBounds(1080,590,200,60);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pmain.main(new String[]{});
			}
		});
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "prafull");
			Statement stmt=con.createStatement();
			String q1="select * from cadv where sno=1";
			OracleResultSet rs1=(OracleResultSet) stmt.executeQuery(q1);
			while(rs1.next())
			{
				s1=rs1.getString("CANSWER");
				s2=rs1.getString("UANSWER");
				if(s1.equalsIgnoreCase(s2))
				{
					c=c+1;
				}
			}
			rs1.close();
			String q2="select * from cadv where sno=2";
			OracleResultSet rs2=(OracleResultSet) stmt.executeQuery(q2);
			while(rs2.next())
			{
				s3=rs2.getString("CANSWER");
				s4=rs2.getString("UANSWER");
				if(s3.equals(s4))
				{
				c=c+1;
				}
			}
			rs2.close();
			String q3="select * from cadv where sno=3";
			OracleResultSet rs3=(OracleResultSet) stmt.executeQuery(q3);
			while(rs3.next())
			{
				s5=rs3.getString("CANSWER");
				s6=rs3.getString("UANSWER");
				if(s5.equals(s6))
				{
				    c=c+1;
				}
			}
			rs3.close();
			String q4="select * from cadv where sno=4";
			OracleResultSet rs4=(OracleResultSet) stmt.executeQuery(q4);
			while(rs4.next())
			{
				s7=rs4.getString("CANSWER");
				s8=rs4.getString("UANSWER");
				if(s7.equalsIgnoreCase(s8))
				{
				  c=c+1;
				}
			}
			rs4.close();
			String q5="select * from cadv where sno=5";
			OracleResultSet rs5=(OracleResultSet) stmt.executeQuery(q5);
			while(rs5.next())
			{
				s9=rs5.getString("CANSWER");
				s10=rs5.getString("UANSWER");
				if(s9.equalsIgnoreCase(s10))
				{
				  c=c+1;
				}
			}
			rs5.close();
			String q6="select * from cadv where sno=6";
			OracleResultSet rs6=(OracleResultSet) stmt.executeQuery(q6);
			while(rs6.next())
			{
				s11=rs6.getString("CANSWER");
				s12=rs6.getString("UANSWER");
				if(s11.equalsIgnoreCase(s12))
				{
				 c=c+1;
				}
			}
			rs6.close();
			String q7="select * from cadv where sno=7";
			OracleResultSet rs7=(OracleResultSet) stmt.executeQuery(q7);
			while(rs7.next())
			{
				s13=rs7.getString("CANSWER");
				s14=rs7.getString("UANSWER");
				if(s13.equalsIgnoreCase(s14))
				{
					c=c+1;
				}
			}
			rs7.close();
			String q8="select * from cadv where sno=8";
			OracleResultSet rs8=(OracleResultSet) stmt.executeQuery(q8);
			while(rs8.next())
			{
				s15=rs8.getString("CANSWER");
				s16=rs8.getString("UANSWER");
				if(s15.equalsIgnoreCase(s16))
				{
					c=c+1;
				}
			}
			rs8.close();
			String q9="select * from cadv where sno=9";
			OracleResultSet rs9=(OracleResultSet) stmt.executeQuery(q9);
			while(rs9.next())
			{
				s17=rs9.getString("CANSWER");
				s18=rs9.getString("UANSWER");
				if(s17.equalsIgnoreCase(s18))
				{
					c=c+1;
				}
			}
			rs9.close();
			String res=String.valueOf(c);
			l13.setText(res);
			int mark=c*5;
			String marks=String.valueOf(mark);
			l11.setText(marks);
			if(c==0)
			{
				String res1=String.valueOf(c);
				l13.setText(res1);
			}
		}catch(Exception e)
		{
			e.getStackTrace();
		}
		add(b);add(chekbtn);
		//Styling
		
		f1=new Font("Arial Black",Font.BOLD,12);
		f2=new Font("CASTELLAR",Font.BOLD,24);
		l3.setFont(f2);l4.setFont(f1);l5.setFont(f1);l6.setFont(f1);l7.setFont(f1);
		l8.setFont(f1);l9.setFont(f1);l10.setFont(f1);l11.setFont(f1);
		l12.setFont(f1);l13.setFont(f1);
		l3.setForeground(Color.RED);
		chekbtn.setForeground(Color.BLUE);
		b.setForeground(Color.BLUE);
		setLayout(null);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/OES/Pics/index.png"));
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(MAXIMIZED_BOTH);
	}
	public static void main(String[] args) {
		Cadvres c1=new Cadvres();
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
