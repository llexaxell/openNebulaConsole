package controller;

import model.User;

import org.opennebula.client.Client;
import org.opennebula.client.ClientConfigurationException;


public class UserController {
	
	
	private MainController mainController;
//	private final static String HOST_ADRESS = Util.getPropertyFile("config").getProperty("my.nebulaNodeAdress");
	
	private final static String HOST_ADRESS = "http://192.168.56.101:2633/RPC2";
	public UserController(MainController controller){
		this.mainController = controller;
	} 
	
	/**
	 * Scenario of sign-in a new user
	 */
	public void createUser(){
		String userName = mainController.askQuestion("Username ?");
		String passWord = mainController.askQuestion("Password ?");
		User user = new User(userName, passWord);
		mainController.getModel().setUser(user);
	}
	
	public void connexion(){
		User user = mainController.getModel().getUser();
		
		try {
			System.out.println(user.getUserName()+":"+user.getPassWord());
			Client client = new Client(user.getUserName()+":"+user.getPassWord(), HOST_ADRESS);
			
			System.out.println("Version =" +client.get_version().getMessage());
			System.out.println("Error message = " +client.get_version().getErrorMessage());
			if (client.get_version().getErrorMessage()!=null){
				System.out.println("Connexion error");
			}else {
				System.out.println("Connexion success !!!");
			}
		} catch (ClientConfigurationException e) {
			e.printStackTrace();
		}
	}
}
