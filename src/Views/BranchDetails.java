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
 * BranchDetails class represents a frame where the customer can see the branches
 */
public class BranchDetails extends JFrame implements ActionListener
{
	/**
	 * @lbranches represents the branches 
	 * @location represents the location 
	 * @openHours represents the openHours 
	 * @closeHours represents the closeHours 
	 * @alocation represents the branch location that the customer inserts
	 * @aopenHours represents the open hours that the customer selected
	 * @acloseHours represents the close hours that the customer selected
	 * @branches represents the branch that the customer selected
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @actualBranches represents the ArrayList of the branches in the system
	 */
	private static final long serialVersionUID = 23425122L;
	private JLabel lbranches;
	private JLabel location;
	private JLabel openHours;
	private JLabel closeHours;
	private JLabel alocation;
	private JLabel aopenHours;
	private JLabel acloseHours;
	private Choice branches;
	
	
	private JButton confirm;
	private JButton back;
	private JPanel panel_1;
	private JPanel panel_2;
	private ArrayList<Branch> actualBranches;
	/**
	 * constructor 
	 */
	public BranchDetails() 
	{
		super("choose a branch");
		lbranches = new JLabel("choose a branch: ");
		location=new JLabel("location:");
		openHours=new JLabel("open Hours:");
		closeHours=new JLabel("close Hours:");
		alocation=new JLabel();
		aopenHours=new JLabel();
		acloseHours = new JLabel();
		
		back = new JButton("back");
		confirm = new JButton("confirm");
		actualBranches = new ArrayList<Branch>();
		branches = new Choice();
		AddChoice();
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
			this.add(addAll(),BorderLayout.NORTH);
			this.add(Actions.addButton(panel_2, confirm, back),BorderLayout.SOUTH);
			this.add(new JLabel(Actions.addImage(500, 300,"images/rentacar.png")), BorderLayout.CENTER);
			confirm.addActionListener(this);
			back.addActionListener(this);
			AddStyle();
		}
	 /**
	  * 
	  * @return a panel contain all the components
	  */
	 private JPanel addAll()
     {
    	 panel_1=new JPanel(new GridLayout(5,2));
    	 panel_1.add(lbranches);
 		 panel_1.add(branches);
 		 panel_1.add(new JLabel());
 		 panel_1.add(new JLabel());
 		 panel_1.add(location);
 		 panel_1.add(alocation);
 		 panel_1.add(openHours);
 		 panel_1.add(aopenHours);
 		 panel_1.add(closeHours);
 		 panel_1.add(acloseHours);
 		 return panel_1;
     }
	/**
	 * the method add items to the brahces
	 */
	 private void AddChoice() {
		 actualBranches = Actions.read("branches.ser");
		 for(Branch b : actualBranches) {
			 branches.add(b.getBrnachNumber());
		 }
		 
	 }
	 
	 /**
	  * change the font in all the components
	  */
	 private void AddStyle() {
			confirm.setFont(new Font("Calibri", Font.BOLD, 14));
			back.setFont(new Font("Calibri", Font.BOLD, 14));
			lbranches.setFont(new Font("Calibri", Font.BOLD, 14));
			location.setFont(new Font("Calibri", Font.BOLD, 14));
			openHours.setFont(new Font("Calibri", Font.BOLD, 14));
			closeHours.setFont(new Font("Calibri", Font.BOLD, 14));
			alocation.setFont(new Font("Calibri", Font.BOLD, 14));
			aopenHours.setFont(new Font("Calibri", Font.BOLD, 14));
			acloseHours.setFont(new Font("Calibri", Font.BOLD, 14));
			branches.setFont(new Font("Calibri", Font.BOLD, 14));
		 }
		 
	 /**
	  * this method handling with the events
	  * if the cusotmer clicks confirm the method show him the branch details
	  * if the customer clicks on back he returns to the last frame
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(confirm)) {
			Branch tmpBranch = 	actualBranches.get(branches.getSelectedIndex());
			alocation.setText(tmpBranch.getLocation());
			aopenHours.setText(tmpBranch.getOpenHours());
			acloseHours.setText(tmpBranch.getCloseHours());
		}
		
		else {
			CustomerOptions co=new CustomerOptions();
			co.setVisible(true);
			this.dispose();
		}
	}

}
