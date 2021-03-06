package model;

import org.opennebula.client.vm.VirtualMachine;

public class Vm {
	
	private String id;
	private VirtualMachine vm;
	private String statut;
	private String name;


	//Build the instance
	public Vm(VirtualMachine vm){
		this.setVm(vm);
		this.id = vm.getId();
		this.statut = vm.lcmStateStr();
		this.name = vm.getName();
	}
	//Actions on the instance
	/**
	 * Hold an instance
	 */
	public void pauseInstance (){
		this.vm.hold();
	}
	
	/**
	 * Release the instance
	 */
	public void unPauseInstance (){
		this.vm.release();
	}
	
	/**
	 * Migrate an instance to another host
	 * @param hostId
	 */
	public void migrateInstance(int hostId){
		this.vm.migrate(hostId);
	}
	
	/**
	 * Delete the instance
	 */
	public void killInstance(){
		this.vm.delete();
	}

	//Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameNodeParent() {
		return this.vm.xpath("HISTORY_RECORDS/HISTORY/HOSTNAME");
	}

	public String getIdNodeParent() {
		return this.vm.xpath("HISTORY_RECORDS/HISTORY/HID");
	}

	public VirtualMachine getVm() {
		return vm;
	}
	public void setVm(VirtualMachine vm) {
		this.vm = vm;
	}
	public String getMem() {
		return this.vm.xpath("MEMORY");
	}
	public void setMem(String mem) {
	}
	public String getCPU() {
		return this.vm.xpath("CPU");
	}
	public void setCPU(String cPU) {
	}
}
