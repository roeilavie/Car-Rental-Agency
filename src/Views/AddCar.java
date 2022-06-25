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
 * AddCar class represents a frame where the manager can add a car
 */
public class AddCar extends JFrame  implements ActionListener
{
	/**
	 * @carNumber represents the car number 
	 * @creationYear represents the creation year
	 * @model represents the model
	 * @subModel represents the sub model
	 * @message represents message from the the frame 
	 * @category represents the category
	 * @gearBoxType represents the gear box type
	 * @pricePerDay represents the price per day
	 * @branch represents the branch
	 * @acarNumber represents the car number that the manager inserts
	 * @apricePerDay represents the price that the manager inserts
	 * @amodel represents the model that the manager inserts
	 * @asubModel represents the sub model that the manager inserts
	 * @acategory represents the category that the manager selected
	 * @agearBoxType represents the gear box type that the manager selected
	 * @acreationYear represents the creation year that the manager selected
	 * @abranch represents the branch that the manager selected
	 * @confirm represents the button for add a branch
	 * @back represents the button for go back to the last page
	 * @panel_1 is a panel for components
	 * @panel_2 is a panel for components
	 * @panel_3 is a panel for components
	 * @brances represents the brances in the system
	 * @branches represents the ArrayList of the branches in the system
	 */
	
	private static final long serialVersionUID = 3472848L;
	private JLabel message;
	private JLabel  carNumber;
	private JLabel creationYear;
	private JLabel model;
	private JLabel subModel;
	private JLabel  category;
	private JLabel gearBoxType;
	private JLabel  pricePerDay;
	private JLabel branch;
	
	private JTextField  acarNumber;
	private JTextField  apricePerDay;
	private JTextField amodel;
	private JTextField asubModel;
	private Choice  acategory;
	private Choice agearBoxType;
	private Choice acreationYear;
	private Choice abranch;
	
	
	private JButton confirm;
	private JButton back;
	private JPanel panel_1;
	private ArrayList<Branch> branches;
	private JPanel panel_2;
	private JPanel panel_3;
	
	/**
	 * constructor
	 */
	public AddCar ()
	{
		super("add New Car");
		message=new JLabel();
		carNumber=new JLabel("car number:");
		creationYear=new JLabel("creation year:");
		model=new JLabel("model:");
		subModel=new JLabel("sub model:");
		category=new JLabel("category:");
		gearBoxType=new JLabel("gearBoxType:");
		pricePerDay =new JLabel("price per day:");
		branch=new JLabel("branch:");
		
		acategory =new Choice();
		agearBoxType= new Choice();
		acreationYear= new Choice();
		abranch = new Choice();
		 
		acarNumber= new JTextField();
		amodel= new JTextField();
		asubModel= new JTextField();
		apricePerDay =new JTextField();
		
		
		confirm=new JButton("Confirm");
		back = new JButton("back");
		branches = new ArrayList<Branch>();
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
		back.setPreferredSize(new Dimension(100, 30));
		this.add(addAll(),BorderLayout.NORTH);
		this.add(Actions.addButton(panel_2, confirm, back),BorderLayout.SOUTH);
		this.add(Actions.addMessage(panel_3, message),BorderLayout.CENTER);
		AddStyle();
		confirm.addActionListener(this);
		back.addActionListener(this);
	}
	/**
	 * 
	 * @return the panel with all the components
	 */
	
	private JPanel addAll()
    {
    	panel_1=new JPanel(new GridLayout(8,2));
    	panel_1.add(carNumber);
    	panel_1.add(acarNumber);
 		panel_1.add(creationYear);
 		panel_1.add(acreationYear);
 		panel_1.add(model);
 		panel_1.add(amodel);
 		panel_1.add(subModel);
 		panel_1.add(asubModel);
 		 
 		 
 		panel_1.add(category);
 		panel_1.add(acategory);
 		panel_1.add(gearBoxType);
 		panel_1.add(agearBoxType);
 		panel_1.add(pricePerDay);
 		panel_1.add(apricePerDay);
 		panel_1.add(branch);
 		panel_1.add(abranch);
 		return panel_1;
     }
	 
	/**
	 * the method add items to the choices
	 */
	private void AddChoices() {
		 branches = Actions.read("branches.ser");
		 String[] cat = {"mini", "sedan", "executive", "suv"};
		 for(Branch b : branches) {
			 abranch.add(b.getBrnachNumber());
		 }
		 
		 for(int i = 2012; i <= 2022; i++) {
			 acreationYear.add(Integer.toString(i));
		 }
		 
		 for(int i = 0; i < cat.length; i++) {
			 acategory.add(cat[i]);
		 }
		 
		 agearBoxType.add("automatic");
		 agearBoxType.add("manually");
	 }
	
	/**
	 * the method chanes the font of all the components
	 */
	 private void AddStyle() {
		message.setFont(new Font("Calibri", Font.BOLD, 14));
		carNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		creationYear.setFont(new Font("Calibri", Font.BOLD, 14));
		model.setFont(new Font("Calibri", Font.BOLD, 14));
		subModel.setFont(new Font("Calibri", Font.BOLD, 14));
		category.setFont(new Font("Calibri", Font.BOLD, 14));
		gearBoxType.setFont(new Font("Calibri", Font.BOLD, 14));
		pricePerDay.setFont(new Font("Calibri", Font.BOLD, 14));
		branch.setFont(new Font("Calibri", Font.BOLD, 14));
		
		acarNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		apricePerDay.setFont(new Font("Calibri", Font.BOLD, 14));
		amodel.setFont(new Font("Calibri", Font.BOLD, 14));
		asubModel.setFont(new Font("Calibri", Font.BOLD, 14));
		acategory.setFont(new Font("Calibri", Font.BOLD, 14));
		agearBoxType.setFont(new Font("Calibri", Font.BOLD, 14));
		acreationYear.setFont(new Font("Calibri", Font.BOLD, 14));
		abranch.setFont(new Font("Calibri", Font.BOLD, 14));
		
		
		confirm.setFont(new Font("Calibri", Font.BOLD, 14));
		back.setFont(new Font("Calibri", Font.BOLD, 14));
	 }
	 
	 /**
	  * halding the events when the manager wants to add a car or he wants to go back to the last page
	  */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirm)) {
			if(acarNumber.getText().equals("") || amodel.getText().equals("") || asubModel.getText().equals("") || apricePerDay.getText().equals("")) {
				 message.setForeground(Color.RED);
				 message.setText("Missing fileds");
				 return;
			}
			
			if(Actions.isNumeric(acarNumber.getText()) == false) {
				 message.setForeground(Color.RED);
				 message.setText("car number need to be numeric");
				 return;
			}
			
			 for(Branch branch : branches) {
				 for(Car car : branch.getCarsOfBranch()) {
					 if(car.getCarNumber().equals(acarNumber.getText())) {
						 message.setForeground(Color.RED);
						 message.setText("The car is already exists");
						 return;
					 }
				 }
			 }	 
			 Car c = new Car(acarNumber.getText(), acreationYear.getSelectedItem(), amodel.getText(), asubModel.getText(), acategory.getSelectedItem()
					 , agearBoxType.getSelectedItem(), apricePerDay.getText());
			 branches.get((abranch.getSelectedIndex())).getCarsOfBranch().add(c);
			 Actions.write(branches, "branches.ser");
			 message.setForeground(Color.BLACK);
			 message.setText("succsessfull");
		}
		
		else {
			MangerOptions m=new MangerOptions();
			m.setVisible(true);
			this.dispose();
		}
	}
	

}
