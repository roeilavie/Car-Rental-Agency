package Views;
import javax.swing.*;
import Controller.Actions;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author roei lavie, chen gershgorn
 * CustomerOptions class represents a frame where the customer can select what to do
 */
public class CustomerOptions extends JFrame implements ActionListener
{
	/**
	 * @showBranches represents the button of show branches
	 * @rentCar represents the button of rent a car
	 * @disconnect represents disconnect from the page
	 * @panel represents the panel 
	 */
	private static final long serialVersionUID = 24731409235L;
	private JButton showBranches;
	private JButton rentCar;
	private JButton disconnect;
	private JPanel panel;
	
	/**
	 * constructor
	 */
	public  CustomerOptions()
	{
		super("customer Options");
		showBranches=new JButton("show Branches");
		rentCar=new JButton("rent Car");
		disconnect = new JButton("disconnect");
		init(); 
	}
	
	/**
	 * initialize the components
	 */
     private void init()
	{
		setLayout(new BorderLayout());
		setSize(500,500);	
		showBranches.setPreferredSize(new Dimension(130, 30));
		rentCar.setPreferredSize(new Dimension(100, 30));
		disconnect.setPreferredSize(new Dimension(100, 30));
		
		disconnect.setFont(new Font("Calibri", Font.BOLD, 14));
		showBranches.setFont(new Font("Calibri", Font.BOLD, 14));
		rentCar.setFont(new Font("Calibri", Font.BOLD, 14));
		
		showBranches.addActionListener(this);
		rentCar.addActionListener(this);
		disconnect.addActionListener(this);
	    this.add(new JLabel(Actions.addImage(500, 420,"images/options.jpg")), BorderLayout.CENTER);
		this.add(addButtons(), BorderLayout.SOUTH);
	}
	 /**
	  * 
	  * @return a panel contain all the components
	  */
     private JPanel addButtons()
     {
    	 panel=new JPanel(new FlowLayout());
    	 panel.add(showBranches);
 		 panel.add(rentCar);
 		 panel.add(disconnect);
 		 return panel;
     }
     
	 /**
	  * this method handling with the events
	  * if the customer clicks on showBranches the method show him the branches details
	  * if the customer clicks on rentCar the method show him the frame if renting a car
	  * if the customer clickss on disconnect he returns to the login page
	  */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(showBranches)) {
			BranchDetails bd = new BranchDetails();
			bd.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource().equals(rentCar)){
			RentAcar ret = new RentAcar();
			ret.setVisible(true);
			this.dispose();
		}
		
		else {
			loginPage lp = new loginPage();
			lp.setVisible(true);
			this.dispose();
		}
		
	}

}

