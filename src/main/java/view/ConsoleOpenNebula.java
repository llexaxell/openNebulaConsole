package view;

import java.io.IOException;

import controller.MainController;

/**
 * @author Axel
 *
 */
public class ConsoleOpenNebula {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		MainController controller = new MainController(); 
		controller.getUserControl().createUser();
		if(controller.getUserControl().connexion()){
			controller.showMenu();
		} else {
			controller.getUserControl().createUser();
			controller.getUserControl().connexion();
			controller.showMenu();
		}
	}
}