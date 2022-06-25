package Controller;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Actions static class for actions in the views package
 * @author roei lavie, chen gershgorn
 */
public class Actions
{
	/**
	 * the method writes a file and save it in our project
	 * @param generics represents the ArrayList we choose to write
	 * @param filename represents the name of the file
	 */
	public static <T> void write(ArrayList<T> generics, String filename)
	{
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(generics);
			out.close();
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}

    }
	
	/**
	 * the method reads the file from our project
	 * @param filename represents the name of the file
	 * @return the ArrayList we are reading from the file  
	 */
	public static <T> ArrayList<T> read(String filename)
	{
		ArrayList<T> generics = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			generics=(ArrayList<T>)in.readObject();
			in.close();
		}
		catch(IOException ex) 
		{
			ex.getStackTrace();
		} catch (ClassNotFoundException e1) 
		{
			
			e1.printStackTrace();
		}
		return generics;
	}
	
	
	/**
	 * the method converts the password to string
	 * @param password represents the password of the user
	 * @return the password in string
	 */
	 public static String ConvertToString(char[] password) {
		 String pass = "";
		 for(int i =0; i < password.length; i++) {
			 pass += password[i];
		 }
		 return pass;
	 }
	 
	/**
	* the method checks if there is there is letters in the string
	* @param name represents the field we want to check
	* @return true or false
	*/
	 public static boolean isAlpha(String name) 
	 {
		    return name.matches("[a-zA-Z]+");
	 }
	 
	 
	/**
	* the method checks if there is numbers in the string
	* @param str represents the field we want to check
	* @return true or false
	*/
	 public static boolean isNumeric(String str) {
		  return str.matches("[+-]?\\d*(\\.\\d+)?");
		}
	 
	 
	/**
	* the method checks if the email is valid
	* @param email represents the field we want to check
	* @return true or false
	*/
	 public static boolean isValidEmailAddress(String email) 
	 {
	        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	        java.util.regex.Matcher m = p.matcher(email);
	        return m.matches();
	 }
	 
	/**
	* the method sets components in the panel
	* @param panel represents the panel
	* @param confirm represents the component
	* @param back represents the component
	* @return the panel
	*/
	 
	 public static JPanel addButton(JPanel panel, JButton confirm, JButton back)
     {
    	 panel=new JPanel(new FlowLayout());
    	 panel.add(confirm);
    	 panel.add(back);
 		 return panel;
     }
	 
	/**
	* the method sets components in the panel
	* @param panel represents the panel
	* @param message represents the component
	* @return the panel
	*/
	 
	 public static JPanel addMessage(JPanel panel, JLabel message)
     {
    	 panel=new JPanel(new FlowLayout());
    	 panel.add(message);
 		 return panel;
     }
	 
	/**
	* the method resizes the image
	* @param width represents the width of the image we want
	* @param height represents the height of the image we want
	* @param path represents the location of the image
	* @return image after resize
	*/
	 
	 public static ImageIcon addImage(int width, int height, String path) {
		 ImageIcon icon = new ImageIcon(path);
		 Image scaleImage = icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
		 ImageIcon image_resize = new ImageIcon(scaleImage);
		 return image_resize;
		 
	 }

}
