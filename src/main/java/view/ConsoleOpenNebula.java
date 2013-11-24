package view;

import java.util.ResourceBundle;

import model.Infrastructure;
import controller.MainController;

/**
 * @author Axel
 *
 */
public class ConsoleOpenNebula {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainController controller = new MainController(); 
		Infrastructure model = new Infrastructure();
		ResourceBundle bundle1 = ResourceBundle.getBundle("language");
		controller.getUserControl().createUser();
		controller.getUserControl().connexion();
	}
}