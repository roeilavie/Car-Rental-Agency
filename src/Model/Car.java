package Model;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author roei lavie, chen gershgorn
 * Car class represents the car
 */
public class Car implements Serializable
{
	/**
	 * @carNumber represents the car number
	 * @creationYear represents the creation year
	 * @model represents the model
	 * @subModel represents the sub model
	 * @category represents the categort
	 * @gearBoxType represents the gear box type
	 * @pricePerDay represents the price per day
	 * @dates represents the Arraylist of dates
	 */
	private static final long serialVersionUID = 126732129L;
	private String carNumber;
	private String creationYear;
	private String model;
	private String subModel;
	private String category;
	private String gearBoxType;
	private String pricePerDay;
	private ArrayList<Date[]> dates;

	/**
	 * 
	 * @param carNumber represents the car number
	 * @param creationYear represents the creation year
	 * @param model represents the model
	 * @param subModel represents the sub model
	 * @param category represents the categort
	 * @param gearBoxType represents the gear box type
	 * @param pricePerDay represents the price per day
	 */
	
	public Car(String carNumber, String creationYear, String model, String subModel, String category,
			String gearBoxType, String pricePerDay) {
		super();
		this.carNumber = carNumber;
		this.creationYear = creationYear;
		this.model = model;
		this.subModel = subModel;
		this.category = category;
		this.gearBoxType = gearBoxType;
		this.pricePerDay = pricePerDay;
		dates= new ArrayList<Date[]>();
	}
	/**
	 * 
	 * @return ArrayList of the dates, start date and end date represents cell in the array inside the ArrayList
	 */
	public ArrayList<Date[]> getDates() 
	{
		return dates;
	}
	/**
	 * 
	 * @return the car number
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * 
	 * @return the creation year
	 */
	public String getCreationYear() {
		return creationYear;
	}
	/**
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 
	 * @return the sub model
	 */
	public String getSubModel() {
		return subModel;
	}
	/**
	 * 
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 
	 * @return the gear box type
	 */
	public String getGearBoxType() {
		return gearBoxType;
	}
	/**
	 * 
	 * @return the price per day
	 */
	public String getPricePerDay() {
		return pricePerDay;
	}
	
	/**
	 * the method checks if the dates the user insert are availble for rent
	 * @param start represents the start date
	 * @param end represents the end date
	 * @return true or not if the dates are available for rent
	 */
	public boolean checkDate(Date start, Date end)
	{
		if(dates.size()==0)
			return true;
		if(dates.get(0)[0].after(end))
			return true;
		if(dates.get(dates.size()-1)[1].before(start))
			return true;
		for(int i=0;i<dates.size()-1;i++)
		{
			if(dates.get(i)[1].before(start) && dates.get(i+1)[0].after(end))
				return true;
		}
		return false;
	}	
}
