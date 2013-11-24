package controller;


public class UserController {
	MainController mainController;
	
	public UserController(MainController controller){
		this.mainController = controller;
	} 
	
	/**
	 * Scenario of sign-in a new user
	 */
	public void createUser(){
		String userName = mainController.askQuestion("Username ?");
		String passWord = mainController.askQuestion("Password ?");
		System.out.println("User = "+userName);
		
	}
}
