package Views;
import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author roei lavie, chen gershgorn
 * loginPage class represents a frame where the customer and the manager can login
 */
public class loginPage extends JFrame  implements ActionListener
{
	/**
	 * @email represents the email
	 * @lpassWord represents the password
	 * @message represents the message 
	 * @aEmail represents the email that the user inserts
	 * @apassWord represents password that the user inserts
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @cutomers represents the ArrayList of the customer in the system
	 */
	private static final long serialVersionUID = 23489242L;
	private JLabel email;
	private JLabel passWord;
	private JLabel message;
	private JTextField aEmail;
	private JPasswordField apassWord;
	
	private JButton confirm;
	private JButton back;
	private JPanel panel_1;
	private JPanel panel_2;
	private ArrayList<Customer> customers;
	
	
	/**
	 * constructor
	 */
	public loginPage ()
	{
		super("Login Page");
		email=new JLabel("Email:");
		passWord=new JLabel("Password:");
		aEmail=new JTextField();
		apassWord=new JPasswordField();
		
		
		confirm=new JButton("Confirm");
		back = new JButton("Back");
		message = new JLabel(" ");
		message.setPreferredSize(new Dimension(180,30));
		customers = new ArrayList<Customer>();
		init();
				
	}
	
	/**
	 * initialize the components
	 */
	private void init()
	{
		setLayout(new BorderLayout());
		setSize(500,500);
		confirm.setPreferredSize(new Dimension(100, 30));
		back.setPreferredSize(new Dimension(100, 30));
		AddStyle();
		
		this.add(addAll(),BorderLayout.NORTH);
		this.add(Actions.addButton(panel_1, confirm, back),BorderLayout.SOUTH);
		panel_2 = Actions.addMessage(panel_2, message);
		panel_2.add(new JLabel(Actions.addImage(500, 300,"images/rentacar.png")));
		this.add(panel_2, BorderLayout.CENTER);
		confirm.addActionListener(this);
		back.addActionListener(this);
	}
	 
	/**
	 * 
	 * @return the panel with all the components
	 */
	 private JPanel addAll()
     {
    	 panel_1=new JPanel(new GridLayout(2,2));
    	 panel_1.add(email);
    	 panel_1.add(aEmail);
 		 panel_1.add(passWord);
 		 panel_1.add(apassWord);
 		 return panel_1;
     }
	 
	 /**
	  * change the font in all the components
	  */
	 private void AddStyle() {
		confirm.setFont(new Font("Calibri", Font.BOLD, 14));
		back.setFont(new Font("Calibri", Font.BOLD, 14));
		email.setFont(new Font("Calibri", Font.BOLD, 14));
		aEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		
		passWord.setFont(new Font("Calibri", Font.BOLD, 14));
		apassWord.setFont(new Font("Calibri", Font.BOLD, 14));
		message.setFont(new Font("Calibri", Font.BOLD, 14));
	 }
	 
	 /**
	  * this method handling with the events
	  * if the user clicks on confirm the method show him the next frame
	  * if the user clicks on back the method show him the last page
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
		{	
		if(e.getSource().equals(confirm)) {
			customers = Actions.read("customers.ser");
			if(MainClass.man.getEmail().equals(aEmail.getText())==true&& MainClass.man.getPassWord().equals(Actions.ConvertToString(apassWord.getPassword()))==true)
			{
				MangerOptions m=new MangerOptions();
				m.setVisible(true);
				this.dispose();
				return;
			}
			
			else {
				for(Customer c : customers)
				{
					if(c.getEmail().equals(aEmail.getText())==true && c.getPassWord().equals(Actions.ConvertToString(apassWord.getPassword()))==true)
					{
						CustomerOptions co=new CustomerOptions();
						co.setVisible(true);
						this.dispose();
						return;
					}	
				}
			}
			message.setForeground(Color.RED);
			message.setText("incorect email or password");		
		}
		
		else {
			MainFrame mf = new MainFrame();
			mf.setVisible(true);
			this.dispose();
		}
	}
}

