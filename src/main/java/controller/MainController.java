package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Infrastructure;
import view.ConsoleOpenNebula;

public class MainController {
	private ConsoleOpenNebula consoleOpenNebula;
	private Infrastructure model;
	private UserController userControl = new UserController(this);

	//Constructeurs
	
	public MainController(){}
	
	public MainController(ConsoleOpenNebula console, Infrastructure model) {
		this.consoleOpenNebula = console;
		this.model = model;
	}
	
	public void showMessage(String message){
		System.out.println(message+"\n");
	}
	
	public String askQuestion(String question){
		System.out.println(question+"\n");
		String answer ="";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    answer = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return answer;
	}
	
	public String askQuestionWithSecreteAnswer(String question){
		String password = "";
        ConsoleEraser consoleEraser = new ConsoleEraser();
        System.out.print(question);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        consoleEraser.start();
        try {
            password = in.readLine();
        }
        catch (IOException e){
            System.out.println("Error trying to read your password!");
            System.exit(1);
        }
 
        consoleEraser.halt();
        return password;
	}
	
	private static class ConsoleEraser extends Thread {
        private boolean running = true;
        public void run() {
            while (running) {
                System.out.print("\b ");
            }
        }
        public synchronized void halt() {
            running = false;
        }
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
