package controller;

import java.io.IOException;
import java.util.List;

import model.NodeImpl;
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
			    out += "Nom de la VM : " + vm.getName() +"\n";
			    out += "Statut de la VM : " + vm.getStatut() +"\n";
			    out += "Mémoire libre : "+ vm.getFreeMem() +" | Mémoire utilisé : " +vm.getUsedMem();
			}
			System.out.println(out);
		}else {
			System.out.println("Pas d'instance");
		}
		mainController.showVmMenu();
	}
	
	/**
	 * Get the number of node
	 * @throws IOException 
	 */
	public void getNumberOfNode() throws IOException {
		System.out.println("Nombre de nodes : "+this.mainController.getModel().getNodeParent().getNodeImpl().size());
		mainController.showMenu();
	}

	/**
	 * Describe all the instance
	 * @throws IOException
	 */
	public void describeAllNodes() throws IOException {
		String out = "";
		List<NodeImpl> nodes = this.mainController.getModel().getNodeParent().getNodeImpl();
		System.out.println("-------------------------------------");
		System.out.println("Descriptions des nodes");
		System.out.println("Nombre d'instances ; "+nodes.size());
		if(nodes.size()>0){
			for (NodeImpl node : nodes){
				out += "Node " + node.getId() +" -------------------\n";
			    out += "Nom du noeud  : " + node.getName() +"\n";
			    out += "Statut du noeud : " + node.getStatut() +"\n"; 
			    out += "Mémoire libre : "+ node.getMemoryFree() +" | Mémoire utilisé : " +node.getMemoryUsed() +"\n"; 
			    out += "Processeur libre : "+ node.getProcessorFree() +" | Processeur utilisé : " +node.getProcessorUsed() +"\n"; 
			}
			System.out.println(out);
		}else {
			System.out.println("Pas de noeud");
		}
		mainController.showMenu();
	}


	public void migrateVm(String vmId) throws IOException {
		String idNode = MainController.askQuestion("Vers quel noeud migrer la vm ? ");
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId == vm.getId()){
				vm.getVm().migrate(Integer.valueOf(idNode));
				System.out.println("Instance "+ vmId + "migrée vers le noeud "+idNode);
				break;
			} else {
				System.out.println("Instance non trouvée");
			}
		}
		mainController.showMenu();
	}


	public void deleteVm(String vmId) throws IOException {
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId == vm.getId()){
				vm.getVm().delete();
				System.out.println("Instance "+ vmId + "terminée");
				break;
			}
		}
		mainController.showMenu();
	}


	public void unPauseActiviteVm(String vmId) throws IOException {
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId == vm.getId() && vm.getVm().state()==0){
				vm.getVm().release();
				System.out.println("Instance "+ vmId + "relachée");
				break;
			} else {
				System.out.println("Instance en cours ou non existante");
			}
		}
		mainController.showMenu();
	}


	public void breakActivityVm(String vmId) throws IOException {
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId == vm.getId() && vm.getVm().state()==0){
				vm.getVm().hold();
				System.out.println("Instance "+ vmId + "en pause");
				break;
			} else {
				System.out.println("Instance déjà en pause ou non existante");
			}
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
