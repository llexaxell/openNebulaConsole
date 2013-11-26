package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.NodeImpl;
import model.ServiceNode;
import model.User;
import model.Vm;

import org.opennebula.client.Client;
import org.opennebula.client.ClientConfigurationException;
import org.opennebula.client.host.Host;
import org.opennebula.client.host.HostPool;
import org.opennebula.client.vm.VirtualMachine;
import org.opennebula.client.vm.VirtualMachinePool;



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
			ServiceNode mainNode = this.mainController.getModel().getNodeParent();
			
			System.out.println("÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷");
			System.out.println("| OPEN NEBULA CONSOLE |");
			System.out.println("÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷");
			if(client.get_version().getErrorMessage()==null){
				System.out.println("Version =" +client.get_version().getMessage());
			} else {
				System.out.println("Error message = " +client.get_version().getErrorMessage());
			}
			if (client.get_version().getErrorMessage()!=null){
				System.out.println("Connexion error");
			} else {
				//Bind the instance properties to the model
				mainNode.setIp(HOST_ADRESS);
				exploreModel(client, mainNode);
				System.out.println("Connexion success !");
			} 
		} catch (ClientConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Explore the infrastructure
	 * @param client
	 * @param mainNode
	 */
	private void exploreModel(Client client, ServiceNode mainNode) {
		mainNode.setOpenNebulaVersion(client.get_version().getMessage());
		
		HostPool host = new HostPool(client);
		mainNode.setNumberVm(host.getLength());
		
		//mainNode.setMemoryFree(host.getById(0).xpath("HOST_SHARE/FREE_MEM"));

		//System.out.println("info : "+host.info().getMessage());
		// VirtualPoolMachine
		VirtualMachinePool pool = new VirtualMachinePool(client);
		//initialise the pool
		pool.info();
		//Bind the information for the nodes
		HostPool poolNode = new HostPool(client);
		//initialise the pool
		poolNode.info();
		//Bind the information for the vms
		Iterator<VirtualMachine> it = pool.iterator();
		List<Vm> listVm = new ArrayList<Vm>();
		//Instanciate the pool of vm 
		while (it.hasNext()) {
			VirtualMachine vm = it.next();
			Vm vmModel = new Vm(vm);
			listVm.add(vmModel);
		}
		mainNode.setVms(listVm);
		
		System.out.println(pool.info().getMessage());
		System.out.println(poolNode.info().getMessage());
		
		
		Iterator<Host> itHost = poolNode.iterator();
		List<NodeImpl> listNode = new ArrayList<NodeImpl>();
		while(itHost.hasNext()){
			Host h = itHost.next();
			NodeImpl impl = new NodeImpl(h);
			listNode.add(impl);
		}
		mainNode.setHypervisor(mainNode.getId());
		mainNode.setNodeImpl(listNode);
	}
}
