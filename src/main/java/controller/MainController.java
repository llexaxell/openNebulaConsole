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
	private DescribeInfra describeInfra;
	
	//Constructeurs
	public MainController(){
		this.userControl = new UserController(this);
		this.describeInfra = new DescribeInfra(this);
		this.model = new Infrastructure(this);
	}
	
	public MainController(ConsoleOpenNebula console, Infrastructure model) {
		this.userControl = new UserController(this);
		this.describeInfra = new DescribeInfra(this);
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
	
	
	
	public void showMenu() throws IOException{
		Runtime.getRuntime().exec("clear");
		System.out.println("Que voulez faire ?");
		System.out.println("1) Afficher le nombre de machines virtuelles hébergées sur l’infrastructure");
		System.out.println("2) Afficher le détail de chaque machine virtuelle");
		System.out.println("3) Afficher le nombre de nœuds");
		System.out.println("4) Afficher le détail de chaque nœud");
		System.out.println("5) Suspendre et reprendre l’exécution d’une machine virtuelle donnée");
		System.out.println("6) Migrer à chaud une machine virtuelle donnée");
		System.out.println("7) Détruire une machine virtuelle donnée");
		
		String answer = askQuestion("Choix : ");
		launchQuery(answer);
	}
	
	
	
	private void launchQuery(String answer) throws IOException {
		int in  = Integer.parseInt(answer);
		switch (in) {
		//Afficher le nombre de machines virtuelles
		case 1:
			describeInfra.getNumberOfVm();
			break;
		case 2:
			describeInfra.describeAllVm();
			break;
		case 3:
			
			break;

		default:
			this.showMenu();
			break;
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

	public DescribeInfra getDescribeInfra() {
		return describeInfra;
	}

	public void setDescribeInfra(DescribeInfra describeInfra) {
		this.describeInfra = describeInfra;
	}
	
}
