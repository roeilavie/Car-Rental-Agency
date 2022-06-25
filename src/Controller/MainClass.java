package Controller;
import Model.*;
import Views.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


/**
 * @author roei lavie, chen gershgorn
 */
public class MainClass {
	/**
	 * the manager of the company
	 */
	public static final Manager man=new Manager("roi@gmail.com","123");
	/**
	 * main class
	 * @param args .
	 */
	public static void main(String[] args) 
	{
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
	            break;
	        }
	    }
		MainFrame frame=new MainFrame();
		frame.setVisible(true);	
	}

}
