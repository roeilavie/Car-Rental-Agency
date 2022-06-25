package Model;
import java.io.Serializable;
import java.util.Date;

/**
 * @author roei lavie, chen gershgorn
 * Customer class represents the the customer
 */
public class Customer implements Serializable
{
	/**
	 * 
	 * @fname represents the first name
	 * @sname represents the surname
	 * @id represents the id
	 * @email represents the email
	 * @licenseYear represents the driving license year
	 * @passWord represents the password
	 * @birthDay represents the birthday
	 */
	private static final long serialVersionUID = 6723462L;
	private String fname;
	private String sname;
	private String id;
	private String email;
	private String licenseYear;
	private String passWord;
	private Date birthDay;
	
	/**
	 * 
	 * @param fname represents the first name
	 * @param sname represents the surname
	 * @param id represents the id
	 * @param email represents the email
	 * @param licenseYear represents the driving license year
	 * @param passWord represents the password
	 * @param birthDay represents the birthday
	 */
	public Customer(String fname, String sname, String id, String email,  String licenseYear,
			String passWord, Date birthDay) {
		super();
		this.birthDay = birthDay;
		this.fname = fname;
		this.sname = sname;
		this.id = id;
		this.email = email;
		this.licenseYear = licenseYear;
		this.passWord =passWord;
	}
	/**
	 * 
	 * @return the birth day
	 */
	public Date getBirthDay() {
		return birthDay;
	}
	/**
	 * 
	 * @return the first name
	 */

	public String getFname() {
		return fname;
	}
	/**
	 * 
	 * @return the surname
	 */

	public String getSname() {
		return sname;
	}
	
	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @return the driving license year
	 */
	public String getLicenseYear() {
		return licenseYear;
	}
	/**
	 * 
	 * @return the password
	 */
	public String getPassWord() {
		return passWord;
	}
}

