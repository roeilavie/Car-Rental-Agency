package Model;
/**
 * @author roei lavie, chen gershgorn
 * Manager class represents the manager
 */

public class Manager 
{
	/**
	 * @email represents the email
	 * @passWord represents the password
	 */
	private String email;
	private String passWord;
	
	/**
	 * 
	 * @param email represents the email
	 * @param passWord represents the password
	 */
	public Manager(String email, String passWord) {
		super();
		this.email = email;
		this.passWord = passWord;
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
	 * @return the password
	 */
	public String getPassWord() {
		return passWord;
	}
}

