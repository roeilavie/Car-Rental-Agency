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
 * AddBranch class represents a frame where the manager can add a branch
 */
public class AddBranch extends JFrame implements ActionListener
{
	
	/**
	 * @brnachNumber represents the branch number 
	 * @location represents the location 
	 * @openHours represents the openHours 
	 * @closeHours represents the closeHours 
	 * @message represents message from the the frame 
	 * @abrnachNumber represents the branch number that the manager inserts
	 * @alocation represents the branch location that the manager inserts
	 * @aopenHours represents the open hours that the manager selected
	 * @acloseHours represents the close hours that the manager selected
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @panel_3 is a panel for components
	 * @branches represents the ArrayList of the branches in the system
	 */
	private static final long serialVersionUID = 3483472L;
	private JLabel brnachNumber;
	private JLabel location;
	private JLabel openHours;
	private JLabel closeHours;
	private JLabel message;
	
	private JTextField abrnachNumber;
	private JTextField alocation;
	
	private Choice aopenHours;
	private Choice acloseHours;
	private JButton confirm;
	
	private JButton back;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private ArrayList<Branch> branches;
	/**
	 * constructor
	 */
	public AddBranch() 
	{
		super("add new branch");
		brnachNumber=new JLabel("branch Number:");
		location=new JLabel("location:");
		openHours=new JLabel("open Hours:");
		closeHours=new JLabel("close Hours:");
		message = new JLabel(" ");
		
		abrnachNumber=new JTextField();
		alocation=new JTextField();
		
		aopenHours=new Choice();
		acloseHours = new Choice();
		confirm = new JButton("confirm");
		back = new JButton("back");
		AddOpenAndCloseHours();
		branches = new ArrayList<Branch>();
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
		panel_2 = Actions.addMessage(panel_2, message);
		panel_2.add(new JLabel(Actions.addImage(500, 250,"images/rentacar.png")), BorderLayout.CENTER);
		this.add(panel_2,BorderLayout.CENTER);
		this.add(Actions.addButton(panel_3, confirm, back),BorderLayout.SOUTH);
		confirm.addActionListener(this);
		back.addActionListener(this);
	}
	
	/**
	 * 
	 * @return the panel after adding the components
	 */
	 private JPanel addAll()
     {
    	panel_1=new JPanel(new GridLayout(4,2));
    	panel_1.add (brnachNumber);
    	panel_1.add(abrnachNumber);
 		panel_1.add(location);
 		panel_1.add(alocation);
 		panel_1.add(openHours);
 		panel_1.add(aopenHours);
 		panel_1.add(closeHours);
 		panel_1.add(acloseHours);
 		return panel_1;
     }
	 
	 /**
	  * the method changes the font of all the components in the frame
	  */
	 private void AddStyle() {
		confirm.setFont(new Font("Calibri", Font.BOLD, 14));
		back.setFont(new Font("Calibri", Font.BOLD, 14));
		brnachNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		location.setFont(new Font("Calibri", Font.BOLD, 14));
		openHours.setFont(new Font("Calibri", Font.BOLD, 14));
		closeHours.setFont(new Font("Calibri", Font.BOLD, 14));
		message.setFont(new Font("Calibri", Font.BOLD, 14));
		
		abrnachNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		alocation.setFont(new Font("Calibri", Font.BOLD, 14));
		
		aopenHours.setFont(new Font("Calibri", Font.BOLD, 14));
	    acloseHours.setFont(new Font("Calibri", Font.BOLD, 14));
	 }
	 
	 /**
	  * the method sets the open and close hours
	  */
	 private void AddOpenAndCloseHours() {
		 for(int i = 1;i <= 24; i++) {
				aopenHours.add(Integer.toString(i) + ":00");
				acloseHours.add(Integer.toString(i) + ":00");
		 }
	 }
	
	 /**
	  * the method handling with the events if the manager wants to add a branch or he wants to go back to the last page
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(confirm)) {
			if(abrnachNumber.getText().equals("") || alocation.getText().equals("")
				|| aopenHours.getSelectedItem().equals(acloseHours.getSelectedItem()) || Actions.isNumeric(abrnachNumber.getText()) == false) {
				message.setForeground(Color.RED);
				message.setText("Invalid details");
				return;
			}
			
			branches = Actions.read("branches.ser");
			
			for(Branch branch : branches) {
				if(branch.getBrnachNumber().equals(abrnachNumber.getText())) {
					message.setForeground(Color.RED);
					message.setText("The branch number is already exists");
					return;
				}
			}
				
			Branch b = new Branch(abrnachNumber.getText(),alocation.getText(),aopenHours.getSelectedItem(), acloseHours.getSelectedItem());
			message.setForeground(Color.BLACK);
			message.setText("successfull");
			branches.add(b);
			Actions.write(branches,"branches.ser");
		}
		
		else {
			MangerOptions m=new MangerOptions();
			m.setVisible(true);
			this.dispose();
		}
	}
}

