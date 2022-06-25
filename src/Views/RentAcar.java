package Views;
import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * @author roei lavie, chen gershgorn
 * RentAcar class represents a frame where the customer can rent a car
 */
public class RentAcar extends JFrame implements ActionListener, ItemListener 
{
	
	/**
	 * @lbranch represents the branch 
	 * @lmodel represents the model
	 * @lcategory represents the category
	 * @lcreationYear represents the creation year
	 * @lgearBox represents the gear box type 
	 * @lprice_per_day represents the price per day
	 * @lmessage represents the message
	 * @branch represents the branch that the customer selected
	 * @model represents the model that the customer selected
	 * @category represents the category that the customer selected
	 * @creationYear represents the creation year that the customer selected
	 * @gearBox represents the gear box type that the customer selected
	 * @price_per_day represents the price that the customer inserts
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @refresh represents the button for refresh the page
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @panel_3 is a panel for components
	 * @branches represents the ArrayList of the branches in the system
	 * @cars represents the ArrayList of the cars in the system
	 * @tmp represents the ArrayList of the cars in the system after the customer selected the field
	 */
	
	
	private static final long serialVersionUID = 249984120312L;
	private JLabel lbranch;
	private JLabel lmodel;
	private JLabel lcategory;
	private JLabel lcreationYear;
	private JLabel lgearBox;
	private JLabel lprice_per_day;
	private JLabel lmessage;
	
	
	private Choice branch;
	private Choice model;
	private Choice category;
	private Choice creationYear;
	private Choice gearBox;
	
	private JTextField price_per_day;
	private JButton confirm;
	private JButton refresh;
	private JButton back;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private ArrayList<Branch> branches;
	private ArrayList<Car> cars;
	private ArrayList<Car> tmpcars;
	
	/**
	 * constructor
	 */
	public RentAcar() 
	{
		super("Rent a car");
		lmessage = new JLabel();
		lbranch = new JLabel("choose a branch:");
		lmodel = new JLabel("choose a model:");
		lcategory = new JLabel("choose category:");
		lcreationYear = new JLabel("choose year:");
		lgearBox = new JLabel("choose gearBox:");
		lprice_per_day = new JLabel("budget:");
		price_per_day = new JTextField();
		
		branches = new ArrayList<Branch>();
		refresh = new JButton("refresh");
		confirm = new JButton("confirm");
		back = new JButton("back");
		
		
		branch = new Choice();
		model = new Choice();
		category = new Choice();
		creationYear = new  Choice();
		gearBox = new  Choice();
		
		branch.addItem("choose a branch:");
		model.addItem("choose a model:");
		category.addItem("choose a category:");
		creationYear.addItem("choose a year:");
		gearBox.addItem("choose a gear box:");
	
		cars = new ArrayList<Car>();
		tmpcars = new ArrayList<Car>();
		model.setEnabled(false);
		category.setEnabled(false);
		creationYear.setEnabled(false);
		gearBox.setEnabled(false);
		price_per_day.setEnabled(false);
		
		
		AddChoices();
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
			refresh.setPreferredSize(new Dimension(100, 30));
			back.setPreferredSize(new Dimension(100, 30));
			
			
			this.add(addAll(),BorderLayout.NORTH);
			this.add(addButtons(),BorderLayout.SOUTH);
			this.add(Actions.addMessage(panel_3, lmessage), BorderLayout.CENTER);
			
			confirm.addActionListener(this);
			refresh.addActionListener(this);
			back.addActionListener(this);
			branch.addItemListener(this);
			model.addItemListener(this);
			category.addItemListener(this);
			creationYear.addItemListener(this);
			gearBox.addItemListener(this);
			AddStyle();
	 }
	/**
	* 
	* @return the panel after adding the components
	*/
	 private JPanel addAll()
     {
    	 panel_1=new JPanel(new GridLayout(7,2));
    	 panel_1.add(lbranch);
    	 panel_1.add(branch);
 		 panel_1.add(lmodel);
 		 panel_1.add(model);
 		 panel_1.add(lcategory);
 		 panel_1.add(category);
 		 panel_1.add(lcreationYear);
 		 panel_1.add(creationYear);
 		 panel_1.add(lgearBox);
 		 panel_1.add(gearBox);
 		 panel_1.add(lprice_per_day);
 		 panel_1.add(price_per_day);
 		 return panel_1;
     }
	/**
	* 
	* @return the panel after adding the components
	*/
	 
	 private JPanel addButtons() {
		 panel_2 = new JPanel(new FlowLayout());
		 panel_2.add(confirm);
		 panel_2.add(refresh);
		 panel_2.add(back);
		 return panel_2;
	 }
	/**
	* the method add items to the choices
	*/
	 private void AddChoices() 
	 {
		 
		 branches = Actions.read("branches.ser");
		 for(Branch b : branches) 
		 {
			 branch.addItem(b.getBrnachNumber());
		 }
	 }
	 /**
	  * this method handling with the events
	  * if the cusotmer clicks confirm the method checks which cars are available and show the customer the next page
	  * if the customer clicks on refresh, all the fields will be like at the beginning
	  * if the customer clicks on back he returns to the last frame
	  */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(confirm))
		{
			if(price_per_day.getText().equals("")) {
				lmessage.setForeground(Color.RED);
				lmessage.setText("missing fields");
				return;
		}
		
		for(Car c : cars) {
			if(Integer.parseInt(price_per_day.getText()) < Integer.parseInt(c.getPricePerDay()) && tmpcars.contains(c)) 
			{
				tmpcars.remove(c);
			}
		
		}
		
		if(tmpcars.size()==0)
		{
			price_per_day.setEnabled(false);
			lmessage.setText("empty search-press on refresh");
			return;
		}
		
		availableCars a=new availableCars(tmpcars,branch.getSelectedItem());	
		a.setVisible(true);
		this.dispose();
		
		}
		else if(e.getSource().equals(refresh))
		{
			Reset();
		}
		
		else {
			CustomerOptions co=new CustomerOptions();
			co.setVisible(true);
			this.dispose();
		}
	}
	
	 /**
	  * this method handling with the events
	  * the customer need to pick from the options that he can pick every step
	  */
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		cars = branches.get(branch.getSelectedIndex()-1).getCarsOfBranch();
		if(e.getSource().equals(branch))
		{
		for(Car c : cars) 
		{
			model.addItem(c.getModel());	
		}
		model=noDuplicate(model);
		model.setEnabled(true);
		branch.setEnabled(false);
		return;
		}
		
	    if(e.getSource().equals(model))
	    {
	    	
	    	for(Car c : cars) 
			{
	    		if(model.getSelectedItem().equals(c.getModel()))
				 category.addItem(c.getCategory());
			}
	    	category=noDuplicate(category);
	    	 category.setEnabled(true);
	    	 model.setEnabled(false);
	    	 return;
	    }
	    if(e.getSource().equals(category))
	    {
	    	
	    	for(Car c : cars) 
			{
	    		if(category.getSelectedItem().equals(c.getCategory()))
				 creationYear.addItem(c.getCreationYear());
			}
	    	creationYear=noDuplicate(creationYear);
	    	 creationYear.setEnabled(true);
	    	 category.setEnabled(false);
	    	 return;
	    }
	    if(e.getSource().equals( creationYear))
	    {
	    	
	    	for(Car c : cars) 
			{
	    		if( creationYear.getSelectedItem().equals(c.getCreationYear())) {
	    			gearBox.addItem(c.getGearBoxType());
	    			tmpcars.add(c);
	    		}
				
			}
	    	gearBox=noDuplicate(gearBox);
	    	 gearBox.setEnabled(true);
	    	 creationYear.setEnabled(false);
	    	 return;
	    }
	    if(e.getSource().equals(gearBox))
	    {
	    	price_per_day.setEnabled(true);
	    	gearBox.setEnabled(false);
	    	
	    	for(Car c : cars)
               {
	    		if(gearBox.getSelectedItem().equals(c.getGearBoxType()) == false && tmpcars.contains(c))
	    			tmpcars.remove(c);
	    	
               }	
	    	
	    }
	    
	}
	
	/**
	 * the method gets a choice and remove the duplicates
	 * @param list represents the choice that we are checking
	 * @return the list after removing the duplicates
	 */
	 private Choice noDuplicate(Choice list)
	    {
	    	ArrayList<Integer>temp=new ArrayList<Integer>();
	    	for(int i=0; i<=list.getItemCount();i++)
	    	{
	    		for(int j=i+1; j<=list.getItemCount()-1;j++)
		    	{
		    		if(list.getItem(i).equals(list.getItem(j)))
		    			temp.add(j);
		    	}
	    		
	    	}
	    	for(int i=0;i<temp.size();i++)
	    	   {
	    	    list.remove(temp.get(i));
	    	   }
	    	return list;
	    }
	 /**
	  * the method reset all the page
	  */
	 private void Reset() {
			branch.removeAll();
			model.removeAll();
			category.removeAll();
			creationYear.removeAll();
			gearBox.removeAll();
			
			price_per_day.setText("");
			branch.addItem("choose a branch");
			model.addItem("choose a model");
			category.addItem("choose acategory");
			creationYear.addItem("choose a year");
			gearBox.addItem("choose a gear box");
			
			branch.setEnabled(true);
			model.setEnabled(false);
			category.setEnabled(false);
			creationYear.setEnabled(false);
			price_per_day.setEnabled(false);
			gearBox.setEnabled(false);
			price_per_day.setText("");
			lmessage.setText("");
			price_per_day.setEnabled(false);
			AddChoices();
	 }
	 
	 /**
	  * the method changes the font of all the components in the frame
	  */
	 private void AddStyle() {
		 
	     lbranch.setFont(new Font("Calibri", Font.BOLD, 14));
				lmodel.setFont(new Font("Calibri", Font.BOLD, 14));
				lcategory.setFont(new Font("Calibri", Font.BOLD, 14));
				lcreationYear.setFont(new Font("Calibri", Font.BOLD, 14));
				lgearBox.setFont(new Font("Calibri", Font.BOLD, 14));
				lprice_per_day.setFont(new Font("Calibri", Font.BOLD, 14));
				lmessage.setFont(new Font("Calibri", Font.BOLD, 14));
				
				
				branch.setFont(new Font("Calibri", Font.BOLD, 14));
				model.setFont(new Font("Calibri", Font.BOLD, 14));
				category.setFont(new Font("Calibri", Font.BOLD, 14));
				creationYear.setFont(new Font("Calibri", Font.BOLD, 14));
				gearBox.setFont(new Font("Calibri", Font.BOLD, 14));
				
				price_per_day.setFont(new Font("Calibri", Font.BOLD, 14));
				confirm.setFont(new Font("Calibri", Font.BOLD, 14));
				refresh.setFont(new Font("Calibri", Font.BOLD, 14));
				back.setFont(new Font("Calibri", Font.BOLD, 14));
		 
	 }
}



