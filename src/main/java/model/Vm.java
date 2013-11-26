package model;

import org.opennebula.client.vm.VirtualMachine;

public class Vm {
	
	private String id;
	private VirtualMachine vm;
	private String statut;
	private String name;
	private String freeMem;
	private String usedMem;
	private String freeCPU;
	private String usedCPU;
	private String nameNodeParent;
	private String idNodeParent;

	//Build the instance
	public Vm(VirtualMachine vm){
		this.setVm(vm);
		this.id = vm.getId();
		this.statut = vm.lcmStateStr();
		this.name = vm.getName();
		this.freeMem = vm.xpath("HOST_SHARE/FREE_MEM");
		this.setUsedMem(vm.xpath("HOST_SHARE/USED_MEM"));
		this.setFreeCPU(vm.xpath("HOST_SHARE/FREE_CPU"));
		this.setUsedCPU(vm.xpath("HOST_SHARE/USED_CPU"));
		
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

	public String getFreeMem() {
		return freeMem;
	}

	public void setFreeMem(String freeMem) {
		this.freeMem = freeMem;
	}

	public String getNameNodeParent() {
		return nameNodeParent;
	}

	public void setNameNodeParent(String nameNodeParent) {
		this.nameNodeParent = nameNodeParent;
	}

	public String getIdNodeParent() {
		return idNodeParent;
	}

	public void setIdNodeParent(String idNodeParent) {
		this.idNodeParent = idNodeParent;
	}
	public VirtualMachine getVm() {
		return vm;
	}
	public void setVm(VirtualMachine vm) {
		this.vm = vm;
	}
	public String getUsedMem() {
		return usedMem;
	}
	public void setUsedMem(String usedMem) {
		this.usedMem = usedMem;
	}
	public String getFreeCPU() {
		return freeCPU;
	}
	public void setFreeCPU(String freeCPU) {
		this.freeCPU = freeCPU;
	}
	public String getUsedCPU() {
		return usedCPU;
	}
	public void setUsedCPU(String usedCPU) {
		this.usedCPU = usedCPU;
	}
	
	
	
}
