package Views;
import Model.*;
import Controller.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author roei lavie, chen gershgorn
 * signUpPage class represents a frame where the user can sign up
 */
public class signUpPage extends JFrame implements ActionListener
{

	/**
	 * @fname represents the first name
	 * @sname represents the surname
	 * @id represents the id
	 * @email represents the email
	 * @birthDate represents the birthday 
	 * @licenseYear represents the license year
	 * @passWord represents the password
	 * @vpassWord represents the verify password
	 * @afname represents the name that the user inserts
	 * @asname represents the name that the user inserts
	 * @aid represents the id year that the user inserts
	 * @aemail represents the email that the user inserts
	 * @date represents the birthday that the customer inserts
	 * @alicenseYear represents the license year that the user selected
	 * @apassWord represents the password that the user inserts
	 * @avpassWord represents the password that the user inserts to verify
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @panel_3 is a panel for components
	 * @customers represents the ArrayList of the customers in the system
	 */
	private static final long serialVersionUID = 345398324L;
	private JLabel message;
	private JLabel fname;
	private JLabel sname;
	private JLabel id;
	private JLabel email;
	private JLabel birthDate;
	private JLabel licenseYear;
	private JLabel passWord;
	private JLabel vpassWord;
	
	private JTextField afname;
	private JTextField asname;
	private JTextField aid;
	private JTextField aemail;
	
	private JDateChooser date;
	private Choice alicenseYear;
	private JPasswordField apassWord;
	private JPasswordField avpassWord;
	private ArrayList<Customer> customers;
	

	private JButton confirm;
	private JButton back;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	/**
	 * constructor
	 */
	public signUpPage ()
	{
		super("sign-Up Page");
		LocalDate d=LocalDate.now();
		message=new JLabel();
		fname=new JLabel("first name: ");
		sname=new JLabel("last name: ");
		id=new JLabel("id: ");
		email=new JLabel("email: ");
		birthDate=new JLabel("birthDate: ");
		licenseYear=new JLabel("year of driving license: ");
		passWord=new JLabel("password: ");
		vpassWord=new JLabel("re-password: ");
		
		date = new JDateChooser();
		afname=new JTextField();
		asname=new JTextField();
		aid=new JTextField();
		aemail=new JTextField();	
		alicenseYear=new Choice();
		for(int i=1940;i<=d.getYear();i++)
		{
			alicenseYear.add(Integer.toString(i));
		}
		
		
		apassWord=new JPasswordField();
		avpassWord=new JPasswordField();
		confirm=new JButton("confirm");
		back = new JButton("back");
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
		this.add(Actions.addMessage(panel_3, message), BorderLayout.CENTER);
		this.add(Actions.addButton(panel_2, confirm, back),BorderLayout.SOUTH);
		confirm.addActionListener(this);
		back.addActionListener(this);
	}
	 
	/**
	* 
	* @return the panel after adding the components
	*/
	 private JPanel addAll()
     {
    	 panel_1=new JPanel(new GridLayout(0,2));
    	 panel_1.add(fname);
    	 panel_1.add(afname);
 		 panel_1.add(sname);
 		 panel_1.add(asname);
 		 panel_1.add(id);
 		 panel_1.add(aid);
 		 panel_1.add(email);
 		 panel_1.add(aemail);
 		 panel_1.add(licenseYear);
 		 
 		 panel_1.add(alicenseYear);
 		 panel_1.add(birthDate);
 		 panel_1.add(date);
 		 panel_1.add(passWord);
 		 panel_1.add(apassWord);
 		 panel_1.add(vpassWord);
 		 panel_1.add(avpassWord);
 		 return panel_1;
     }
	 
	/**
	 * the method changes the font of all the components in the frame
	 */
	 private void AddStyle() {
		confirm.setFont(new Font("Calibri", Font.BOLD, 14));
		back.setFont(new Font("Calibri", Font.BOLD, 14));
		email.setFont(new Font("Calibri", Font.BOLD, 14));
		aemail.setFont(new Font("Calibri", Font.BOLD, 14));
		
		passWord.setFont(new Font("Calibri", Font.BOLD, 14));
		apassWord.setFont(new Font("Calibri", Font.BOLD, 14));
		message.setFont(new Font("Calibri", Font.BOLD, 14));
		
		fname.setFont(new Font("Calibri", Font.BOLD, 14));
		sname.setFont(new Font("Calibri", Font.BOLD, 14));
		id.setFont(new Font("Calibri", Font.BOLD, 14));
		birthDate.setFont(new Font("Calibri", Font.BOLD, 14));
		licenseYear.setFont(new Font("Calibri", Font.BOLD, 14));
		passWord.setFont(new Font("Calibri", Font.BOLD, 14));
		apassWord.setFont(new Font("Calibri", Font.BOLD, 14));
		vpassWord.setFont(new Font("Calibri", Font.BOLD, 14));
		avpassWord.setFont(new Font("Calibri", Font.BOLD, 14));
		
		afname.setFont(new Font("Calibri", Font.BOLD, 14));
		asname.setFont(new Font("Calibri", Font.BOLD, 14));
		aid.setFont(new Font("Calibri", Font.BOLD, 14));
		alicenseYear.setFont(new Font("Calibri", Font.BOLD, 14));
	 }
	 
	 /**
	  * this method handling with the events
	  * if the user clicks confirm the method show him the customer options
	  * if the customer clicks on back he returns to the last frame
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(confirm)) {
			message.setForeground(Color.RED);
			if(Actions.isAlpha(afname.getText()) == false|| Actions.isAlpha(asname.getText()) ==false)
			{
				if(afname.getText().equals("")||asname.getText().equals(""))
				{
					message.setText("first name/last name cannot be empty ");
					return;
					
				}
				message.setText("the name cannot be with spaces or numbers");
				return;
			}
			
			
			else if(aid.getText().length()!=9||aid.getText().equals(""))
			{
				message.setText("invalid id ");
				return;
			}
			
			
			else if(Actions.isValidEmailAddress(aemail.getText())==false)
			{
				message.setText("invalid email");
				return;
			}
			
			else if(Actions.ConvertToString(apassWord.getPassword()).equals(Actions.ConvertToString(avpassWord.getPassword())) == false || apassWord.getPassword().length == 0|| avpassWord.getPassword().length == 0)
			{
				message.setText("passwords are not the same/empty");
				return;
				
			}
			
			customers = Actions.read("customers.ser");
			for(Customer c : customers) {
				if(c.getId().equals(aid.getText())) {
					message.setForeground(Color.RED);
					message.setText("customer already exists");
					return;
				}
			}
			
			Date birthOf = new Date(date.getDate().getTime());
			Customer c = new Customer(afname.getText(),asname.getText(), aid.getText(), aemail.getText(),  alicenseYear.getSelectedItem(),Actions.ConvertToString(apassWord.getPassword()), birthOf);
			customers.add(c);
			Actions.write(customers,"customers.ser");
			
			CustomerOptions a=new CustomerOptions();
			a.setVisible(true);
			this.dispose();
		}
		
		else {
			MainFrame mf = new MainFrame();
			mf.setVisible(true);
			this.dispose();
		}
		
	
	}
	
}
	


