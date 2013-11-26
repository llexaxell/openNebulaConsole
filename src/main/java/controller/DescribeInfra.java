package controller;

import java.io.IOException;
import java.util.List;

import model.Vm;

public class DescribeInfra {
	
	private MainController mainController;
	
	public DescribeInfra(MainController mainController2) {
		this.setMainController(mainController2);
	}

	
	/**
	 * Get the number of vms
	 * @return
	 * @throws IOException 
	 */
	public void getNumberOfVm() throws IOException{
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		System.out.println("Nombre de machines virtuelles hébergées sur l’infrastructure");
		System.out.println("Nombre de VMs : "+vms.size());
		mainController.showMenu();
	}
	
	/**
	 * Describe all the vm in the main
	 * @param id
	 * @return
	 * @throws IOException 
	 */
	public void describeAllVm () throws IOException{
		String out = "";
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		System.out.println("-------------------------------------");
		System.out.println("Descriptions des instances");
		System.out.println("Nombre d'instances ; "+vms.size());
		if(vms.size()>0){
			for (Vm vm : vms){
				out += "VM " + vm.getId() +" -------------------\n";
			    out += "Nom de la VM : " + vm.getName() +"\n";;
			    out += "Statut de la VM : " + vm.getStatut() +"\n";; 
			    out += "Mémoire libre : "+ vm.getFreeMem();
			}
			System.out.println(out);
		}else {
			System.out.println("Pas d'instance");
		}
		mainController.showMenu();
	}
	
	//Getters and settters
	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	
}
