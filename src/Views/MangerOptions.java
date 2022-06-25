package Views;
import javax.swing.*;
import Controller.Actions;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author roei lavie, chen gershgorn
 * ManagerOptions class represents a frame where the manager can select what to do
 */
public class MangerOptions  extends JFrame implements ActionListener
{
	/**
	 * @addBranch represents the button of add branch
	 * @rentCar represents the button of add car
	 * @disconnect represents disconnect from the page
	 * @panel represents the panel 
	 */
	private static final long serialVersionUID = 23949723L;
	private JButton addBranch;
	private JButton addCar;
	private JButton disconnect;
	private JPanel panel;
	
	/**
	 * constructor
	 */
	public  MangerOptions()
	{
		super("Manger Options");
		addBranch=new JButton("add Branch");
		addCar=new JButton("add Car");
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
		addBranch.setPreferredSize(new Dimension(100, 30));
		addCar.setPreferredSize(new Dimension(100, 30));
		disconnect.setPreferredSize(new Dimension(100, 30));
		addBranch.setFont(new Font("Calibri", Font.BOLD, 14));
		addCar.setFont(new Font("Calibri", Font.BOLD, 14));
		disconnect.setFont(new Font("Calibri", Font.BOLD, 14));
		 
		addBranch.addActionListener(this);
		addCar.addActionListener(this);
		disconnect.addActionListener(this);
	    this.add(new JLabel(Actions.addImage(500, 420,"images/options.jpg")), BorderLayout.CENTER);
	    this.add(addButtons(), BorderLayout.SOUTH);
	}
     
 	/**
 	 * 
 	 * @return the panel with all the components
 	 */
    private JPanel addButtons()
    {
    	panel=new JPanel(new FlowLayout());
    	panel.add(addBranch);
 		panel.add(addCar);
 		panel.add(disconnect);
 		return panel;
    }
	
	 /**
	  * this method handling with the events
	  * if the manager clicks on add branch the method show him the next frame
	  * if the manager clicks on add car the method show him the next frame
	  * if the manaher clickss on disconnect he returns to the login page
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(addBranch)) {
			AddBranch ad = new AddBranch();
			ad.setVisible(true);
			this.dispose();
		}
		
		else if(e.getSource().equals(addCar)) {
			AddCar ac = new AddCar();
			ac.setVisible(true);
			this.dispose();
		}
		
		else {
			loginPage lp = new loginPage();
			lp.setVisible(true);
			this.dispose();
		}
	}
}

