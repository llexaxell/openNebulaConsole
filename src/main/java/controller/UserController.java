package controller;

import org.opennebula.client.Client;
import org.opennebula.client.ClientConfigurationException;
import org.opennebula.client.OneResponse;
import org.opennebula.client.vm.VirtualMachine;

import utils.Util;

import model.User;


public class UserController {
	
	
	private MainController mainController;
//	private final static String HOST_ADRESS = Util.getPropertyFile("config").getProperty("my.nebulaNodeAdress");
	
	private final static String HOST_ADRESS = "http://192.168.56.101:4576/RPC2";
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
			Client client = new Client(user.getUserName()+":"+user.getPassWord(), HOST_ADRESS);
			
			OneResponse rc = client.call(HOST_ADRESS, "Sfre");
			System.out.println("Rc message ="+rc.getMessage());
			System.out.println("Version =" +client.get_version().getIntMessage());
			System.out.println("Connexion success !!!");
		} catch (ClientConfigurationException e) {
			e.printStackTrace();
		}
	}
}
