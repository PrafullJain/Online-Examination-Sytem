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


public class jhecbegans2 extends JFrame implements WindowListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	JButton b1,b2;
	UIManager um;
	Font f1,f2;

	public jhecbegans2() {
		setTitle("Online Exam System");
		l1=new JLabel("***************************");
		l2=new JLabel("***************************");
		l3=new JLabel("Online Exam System");
		l4=new JLabel("Q.3)");
		l18=new JLabel();
		l5=new JLabel("Your answer :-");
		l6=new JLabel("");
		l7=new JLabel("Correct answer :-");
		l8=new JLabel("");
		l9=new JLabel("Explanation :-");
		l10=new JLabel("");
		/**********************************************/
		l17=new JLabel("Q.4)");
		l19=new JLabel();
		l11=new JLabel("Your answer :-");
		l12=new JLabel("");
		l13=new JLabel("Correct answer :-");
		l14=new JLabel("");
		l15=new JLabel("Explanation :-");
		l16=new JLabel("");
		
		
		f1=new Font("Arial Black",Font.BOLD,12);
		f2=new Font("CASTELLAR",Font.BOLD,24);
		
		l1.setBounds(600,30,360,70);
		l3.setBounds(510,60,400,70);
		l2.setBounds(600,90,360,70);
		l4.setBounds(26,190,360,70);
		l18.setBounds(56,190,600,70);
		l5.setBounds(56,230,360,70);
		l6.setBounds(166,230,360,70);
		l7.setBounds(56,250,360,120);
		l8.setBounds(193,276,360,70);
		l9.setBounds(56,294,360,120);
		l10.setBounds(164,319,1200,70);
		
		l17.setBounds(26,360,460,70);
		l19.setBounds(56,360,630,70);
		l11.setBounds(56,405,360,50);
		l12.setBounds(166,395,360,70);
		l13.setBounds(56,410,360,120);
		l14.setBounds(193,436,360,70);
		l15.setBounds(56,450,360,120);
		l16.setBounds(164,475,1200,70);
		
		b1=new JButton("<=Prev");
		b1.setBounds(130,620,150,50);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jhecbegans1.main(new String[]{});
			}
		});
		
		b2=new JButton("Next=>");
		b2.setBounds(1050,620,150,50);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jhecbegans3.main(new String[]{});
			}
				});
	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "prafull");
			Statement stmt=con.createStatement();
			String q1="select * from jbeg where sno=3";
			OracleResultSet rs1=(OracleResultSet) stmt.executeQuery(q1);
			while(rs1.next())
			{
				l6.setText(rs1.getString("UANSWER"));
				l8.setText(rs1.getString("CANSWER"));
				l10.setText(rs1.getString("EXPLANATION"));
				l18.setText(rs1.getString("QUESTIONS"));
			}
			rs1.close();
			String q2="select * from jbeg where sno=4";
			OracleResultSet rs2=(OracleResultSet) stmt.executeQuery(q2);
			while(rs2.next())
			{
				l19.setText(rs2.getString("QUESTIONS"));
				l12.setText(rs2.getString("UANSWER"));
				l14.setText(rs2.getString("CANSWER"));
				l16.setText(rs2.getString("EXPLANATION"));
			}
			rs2.close();			
		}catch(Exception ex)
		{
			ex.getStackTrace();
		}
			addWindowListener(this);
	//Styling
			f1=new Font("Arial Black",Font.BOLD,12);
			f2=new Font("CASTELLAR",Font.BOLD,24);
			Font f3=new Font("Calibri Light",Font.BOLD,14);
			l3.setForeground(Color.RED);
			l3.setFont(f2);l4.setFont(f1);l18.setFont(f1);l17.setFont(f1);l19.setFont(f1);
			l5.setFont(f1);l7.setFont(f1);l9.setFont(f1);
			l11.setFont(f1);l13.setFont(f1);l15.setFont(f1);
			l6.setFont(f3);	l8.setFont(f3);	l10.setFont(f3);
			l12.setFont(f3);l14.setFont(f3);l16.setFont(f3);
			b1.setForeground(Color.BLUE);b2.setForeground(Color.MAGENTA);
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);
		add(l8);add(l9);add(l10);add(l11);add(l12);add(l13);add(l14);
		add(l15);add(l16);add(l17);add(l18);add(l19);add(b1);add(b2);

		
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/OES/Pics/index.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public static void main(String[] args) {
	jhecbegans2 c1=new jhecbegans2();
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
