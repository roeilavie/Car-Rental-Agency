package Model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author roei lavie, chen gershgorn
 * Branch class represents the branch
 */
public class Branch implements Serializable
{	
	/**
	 * @branchNumber represents the branch number
	 * @location represents the location
	 * @openHours represents the branch open hours
	 * @closeHours represents the close hours
	 * @carsOfBranch represents the cars in the branch
	 */
	private static final long serialVersionUID = 8943738L;
	private String branchNumber;
	private String location;
	private String openHours;
	private String closeHours;
	private ArrayList<Car> carsOfBranch;
	
	/**
	 * @param branchNumber represents the branch number
	 * @param location represents the location
	 * @param openHours represents the branch open hours
	 * @param closeHours represents the close hours
	 */
	
	public Branch(String branchNumber, String location, String openHours, String closeHours) {
		super();
		this.branchNumber = branchNumber;
		this.location = location;
		this.openHours = openHours;
		this.closeHours = closeHours;
		carsOfBranch = new ArrayList<Car>();
	}
	/**
	 * 
	 * @return the branch number
	 */
	
	public String getBrnachNumber() {
		return branchNumber;
	}
	/**
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 
	 * @return the open hours
	 */
	public String getOpenHours() {
		return openHours;
	}
	/**
	 * 
	 * @return the close hours
	 */
	public String getCloseHours() {
		return closeHours;
	}
	/**
	 * 
	 * @return the cars in the branch
	 */
	public ArrayList<Car> getCarsOfBranch() {
		return carsOfBranch;
	}
	/**
	 * the method removes a car from the list
	 * @param carNumber represents the car number
	 */
	public void removeCar(String carNumber) {
		for(Car c : carsOfBranch) {
			if(c.getCarNumber().equals(carNumber)) {
				carsOfBranch.remove(c);
				return;
			}
		}
		
	}
}

