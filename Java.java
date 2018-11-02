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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Java extends JFrame implements WindowListener{
	JButton b1,b2;
	UIManager um;
	JLabel l1,l2,l3;
	Font f1,f2;
	Java()
	{
		setTitle("Online Exam System");
		l1=new JLabel("***************************");
		l2=new JLabel("***************************");
		l3=new JLabel("Online Exam System");
		
		l1.setBounds(600,30,360,70);
		l3.setBounds(510,60,400,70);
		l2.setBounds(600,90,360,70);
		
		f1=new Font("Lucida Calligraphy",Font.BOLD,24);
		f2=new Font("CASTELLAR",Font.BOLD,24);
		
		l3.setFont(f2);
		
		b1=new JButton("Java-Beginner");
		b2=new JButton("Java-Intermediate/Advanced");
	
		
		b1.setFont(f1);	b2.setFont(f1);	
		
		b1.setBounds(80,270,340,130);
		b2.setBounds(740,270,510,130);
		
		add(l1);add(l2);add(l3);
		add(b1);add(b2);
		
		l3.setForeground(Color.RED);
		b1.setForeground(Color.BLUE);b2.setForeground(Color.ORANGE);
		

		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jabeg1.main(new String[]{});

			}
		});

		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jaint1.main(new String[]{});

			}
		});
		addWindowListener(this);
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/OES/Pics/index.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Java jobj=new Java();
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
