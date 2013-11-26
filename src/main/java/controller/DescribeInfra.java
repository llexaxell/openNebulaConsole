package controller;

import java.io.IOException;
import java.util.List;

import model.NodeImpl;
import model.Vm;

public class DescribeInfra {
	
	private static final String STATE_SUSPENDED = "SUSPENDED";
	private static final String  STATE_RUNNING = "RUNNING";
	private MainController mainController;
	
	public DescribeInfra(MainController mainController2) {
		this.mainController = mainController2;
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
		System.out.println("-------------------------------------");
		System.out.println("Nombre d'instances : "+vms.size()+"\n\n");
		if(vms.size()>0){
			for (Vm vm : vms){
				out += "----- VM (id: " + vm.getId() +")\n";
			    out += "Nom de la VM : " + vm.getName() +"\n";
			    out += "Statut de la VM : " + vm.getStatut() +"\n";
			    out += "--------------------------------------------------\n";
			    out += " + Mémoire : "+ vm.getMem() +"o | CPU : " +vm.getCPU() +"% +\n"; 
			    out += "--------------------------------------------------\n";
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
		System.out.println("-------------------------------------");
		System.out.println("Nombre d'instances ; "+nodes.size() +"\n");
		if(nodes.size()>0){
			for (NodeImpl node : nodes){
				out += "----- Node (id: " + node.getId() +")\n";
			    out += "Nom du noeud  : " + node.getName() +"\n";
			    out += "Statut du noeud : " + node.getStatut() +"\n";
			    out += "--------------------------------------------------------\n";
			    out += "+ Mémoire libre : "+ node.getMemoryFree() +"o | Mémoire utilisée : " +node.getMemoryUsed() +"o +\n"; 
			    out += "--------------------------------------------------------\n";
			    out += "+ Processeur libre : "+ node.getProcessorFree() +" % | Processeur utilisé : " +node.getProcessorUsed() +"%   +\n"; 
			    out += "--------------------------------------------------------\n";
			    out += "Hyperviseur : "+node.getHypervisor()+"\n";
			}
			System.out.println(out);
		}else {
			System.out.println("Pas de noeud");
		}
		mainController.showMenu();
	}

	/**
	 * Migration de la vm
	 * @param vmId
	 * @throws IOException
	 */
	public void migrateVm(String vmId) throws IOException {
		String nodes ="";
		for (NodeImpl node : this.mainController.getModel().getNodeParent().getNodeImpl()){
			nodes += node.getId()+" " ;
		}
		
		System.out.println("Nodes disponibles : " + nodes);
		String idNode = MainController.askQuestion("Vers quel noeud migrer la VM ?");
		
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId.equalsIgnoreCase(vm.getId())){
				vm.getVm().migrate(Integer.valueOf(idNode));
				System.out.println("Instance "+ vmId + " migrée vers le noeud "+idNode);
				break;
			} else {
				System.out.println("Instance non trouvée");
			}
		}
		mainController.showMenu();
	}

	/**
	 * Delete la VM
	 * @param vmId
	 * @throws IOException
	 */
	public void deleteVm(String vmId) throws IOException {
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId.equalsIgnoreCase(vm.getId())){
				vm.getVm().delete();
				System.out.println("Instance "+ vmId + " terminée");
				break;
			} else {
				System.out.println("Instance non trouvée");
			}
		}
		mainController.showMenu();
	}

	/**
	 * Resume the VM
	 * @param vmId
	 * @throws IOException
	 */
	public void unPauseActiviteVm(String vmId) throws IOException {
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			if (vmId.equalsIgnoreCase(vm.getId()) && !(vm.getVm().stateStr().equalsIgnoreCase(STATE_RUNNING))){
				vm.getVm().resume();
				System.out.println("Instance "+ vmId + " relachée");
				break;
			} else {
				System.out.println("Instance en cours ou non existante");
			}
		}
		mainController.showMenu();
	}

	/**
	 * Suspend the VM
	 * @param vmId
	 * @throws IOException
	 */
	public void breakActivityVm(String vmId) throws IOException {
		List<Vm> vms = this.mainController.getModel().getNodeParent().getVms();
		for (Vm vm : vms){
			System.out.println(vm.getId());
			System.out.println(vm.getVm().stateStr());
			if (vmId.equalsIgnoreCase(vm.getId()) && !STATE_SUSPENDED.equalsIgnoreCase(vm.getVm().stateStr())){
				vm.getVm().suspend();
				vm.setStatut(STATE_SUSPENDED);
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
