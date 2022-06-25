package Views;
import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.toedter.calendar.JDateChooser;

/**
 * @author roei lavie, chen gershgorn
 * availableCars class represents a frame where the user can choose car for rent
 */
public class availableCars  extends JFrame implements ActionListener
{
	/**
	 * @cars represents the car number 
	 * @ldate represents the start date
	 * @ledate represents the end date
	 * @message represents message from the the frame 
	 * @aCars represents the number of the car that the customer chose
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @date represents the start date that the customer chose
	 * @edate represents the end date that the customer chose
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @panel_3 is a panel for components
	 * @selectedBranch represents the brance that chosen
	 * @tmpcars represents the ArrayList of the cars in the system
	 */
	private static final long serialVersionUID = 3482392L;
	private Choice aCars;
	private JLabel cars;
	private JLabel ldate;
	private JLabel ledate;
	private JLabel message;
	
	private JButton confirm;
	private JButton back;
	private JDateChooser date;
	private JDateChooser edate;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private ArrayList<Car> tmpcars;
	private String selectedBranch;
	/**
	 * 
	 * @param tmpcars represents the cars that the customer can choose
	 * @param branch represents the brach that selected
	 */
	public  availableCars(ArrayList<Car> tmpcars, String branch)
	{
		super("choose a car");
		selectedBranch = branch;
		aCars=new Choice();
		for(Car c : tmpcars) {
			aCars.add(c.getCarNumber());
		}
		
		cars=new JLabel("car id:");
		ldate=new JLabel("choose start date:");
		ledate=new JLabel("choose end date:");
		message=new JLabel(" ");
		
		date = new JDateChooser();
		edate = new JDateChooser();
		
		back = new JButton("back");
		confirm = new JButton("confirm");
		this.tmpcars = tmpcars;
		init();
		
	}
	/**
	 * initilize the components
	 */
	 private void init()
		{
			 setLayout(new BorderLayout());
			 setSize(500,500);
			 confirm.setPreferredSize(new Dimension(100, 30));
			 back.setPreferredSize(new Dimension(100, 30));
			 
			 this.add(addAll(),BorderLayout.NORTH);
			 this.add(Actions.addButton(panel_2, confirm, back),BorderLayout.SOUTH);
			 panel_3 = Actions.addMessage(panel_3, message);
			 panel_3.add(new JLabel(Actions.addImage(500, 300,"images/rentacar.png")));
			 this.add(panel_3,BorderLayout.CENTER);
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
    	 panel_1=new JPanel(new GridLayout(3,2));
    	 panel_1.add(cars);
    	 panel_1.add(aCars);
 		 panel_1.add(ldate);
 		 panel_1.add(date);
 		 panel_1.add(ledate);
 		 panel_1.add(edate);
 		 return panel_1;
     }
	 
	 /**
	  * change the font in all the components
	  */
	 private void AddStyle() {
		aCars.setFont(new Font("Calibri", Font.BOLD, 14));
		cars.setFont(new Font("Calibri", Font.BOLD, 14));
		ldate.setFont(new Font("Calibri", Font.BOLD, 14));
		ledate.setFont(new Font("Calibri", Font.BOLD, 14));
		message.setFont(new Font("Calibri", Font.BOLD, 14));
		
		confirm.setFont(new Font("Calibri", Font.BOLD, 14));
		back.setFont(new Font("Calibri", Font.BOLD, 14));
		date.setFont(new Font("Calibri", Font.BOLD, 14));
		edate.setFont(new Font("Calibri", Font.BOLD, 14));
	 }
	
	 /**
	  * this method handling with the events
	  * if the cusotmer clicks confirm the method checks if the car is available for rent in this days,
	  * if he is available, the dates will save in the details of the car, the method sort the dates in the arraylist oreder by date,
	  * and the will not be available anymore at those days.
	  * if the customer clicks on back he returns to the last frame
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(confirm)) {
			if(date.getDate()==null||edate.getDate()==null)
			{
				message.setForeground(Color.RED);
				message.setText("please enter both of dates to continue");
				return;
			}
			
			
			for(Car c:tmpcars)
			{
				Date start = new Date(date.getDate().getTime());
				Date end = new Date(edate.getDate().getTime());
				if(aCars.getSelectedItem().equals(c.getCarNumber()))
				{
					if(!c.checkDate(start,end))
					{
						message.setForeground(Color.RED);
						message.setText("unavailable for this dates ");
						return;
					}
					
					Date[] temp= {start, end};
					c.getDates().add(temp);
					Collections.sort(c.getDates(), new Comparator<Date[]>() {
						public int compare(Date[] o1, Date[] o2) 
						{
							
							return o1[1].compareTo(o2[0]);
						}
					});
					
					message.setForeground(Color.BLACK);
					message.setText("sucssesfull");
					ArrayList<Branch> branches=Actions.read("branches.ser");
					for(Branch b1: branches) 
					{
						if(b1.getBrnachNumber().equals(selectedBranch)) {
							b1.removeCar(c.getCarNumber());
							b1.getCarsOfBranch().add(c);
							break;
						}
					}
					Actions.write(branches, "branches.ser");
				}
			}
		}
		
		else {
			RentAcar ret = new RentAcar();
			ret.setVisible(true);
			this.dispose();
		}
	}
}
