package Views;
import javax.swing.*;
import Controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author roei lavie, chen gershgorn
 * Mainframe class represents the first frame
 */
public class MainFrame extends JFrame implements ActionListener
{

	/**
	 * @login represents the login button
	 * @sinUp represents the sign up button
	 * @welcome represents the welcome label
	 * @panel is a panel for components
	 */
	
	private static final long serialVersionUID = 42057298234L;
	private JButton login;
	private JButton sinUp;
	private JPanel panel;
	private JLabel welcome;
	
	/**
	 * constructor
	 */
	public MainFrame()
	{
		super("ruppin Rent");
		login=new JButton("Login");
		sinUp=new JButton("sinUp");
		welcome = new JLabel("Welcome to Ruppin Rent");
		init();
	}
	/**
	 * initialize the components
	 */
     private void init()
	{
		setLayout(new BorderLayout());
		setSize(500,500);
		welcome.setFont(new Font("Calibri", Font.BOLD, 45));
		login.setFont(new Font("Calibri", Font.BOLD, 14));
		sinUp.setFont(new Font("Calibri", Font.BOLD, 14));
		
		login.setPreferredSize(new Dimension(100, 30));
		sinUp.setPreferredSize(new Dimension(100, 30));
		
		login.addActionListener(this);
		sinUp.addActionListener(this);
	    this.add(Actions.addButton(panel, login, sinUp), BorderLayout.SOUTH);
	    
	    this.add(new JLabel(Actions.addImage(500, 300,"images/rentacar.png")), BorderLayout.CENTER);
	    this.add(welcome , BorderLayout.NORTH);
	}
     
	 /**
	  * this method handling with the events
	  * if the user clicks on login the method show him the login page
	  * if the user clicks on signup the method show him the sign up page
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(login))	
		{
			loginPage lp=new loginPage();
			lp.setVisible(true);
			
		}
		else
		{
			signUpPage sp=new signUpPage();
			sp.setVisible(true);
			
		}
		this.dispose();
		
	}
	
}



