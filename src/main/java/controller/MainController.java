package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Infrastructure;
import view.ConsoleOpenNebula;

public class MainController {
	private ConsoleOpenNebula consoleOpenNebula;
	private Infrastructure model;
	private UserController userControl;

	//Constructeurs
	
	public MainController(){
		this.userControl = new UserController(this);
		this.model = new Infrastructure(this);
	}
	
	public MainController(ConsoleOpenNebula console, Infrastructure model) {
		this.userControl = new UserController(this);
		this.consoleOpenNebula = console;
		this.model = model;
	}
	/**
	 * Show a message in the console
	 * @param message
	 */
	public void showMessage(String message){
		System.out.println(message);
	}
	
	/**
	 * Ask a question and get a clear answer
	 * @param question
	 * @return
	 */
	public String askQuestion(String question){
		System.out.println(question);
		String answer = "";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    answer = bufferRead.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return answer;
	}
	
	
	
//	Getter and setters
	
	public ConsoleOpenNebula getConsoleOpenNebula() {
		return consoleOpenNebula;
	}

	public void setConsoleOpenNebula(ConsoleOpenNebula consoleOpenNebula) {
		this.consoleOpenNebula = consoleOpenNebula;
	}

	public Infrastructure getModel() {
		return model;
	}

	public void setModel(Infrastructure model) {
		this.model = model;
	}

	public UserController getUserControl() {
		return userControl;
	}

	public void setUserControl(UserController userControl) {
		this.userControl = userControl;
	}
	
}
