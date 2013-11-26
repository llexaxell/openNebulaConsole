package model;

import java.util.List;

public abstract class AbstractNode {

	private String id;
	private String ip;
	private String name;
	private String statut;
	private String hypervisor;
	private String processorInformation;
	private String memoryInformation;
	private String processorUsed;
	private String memoryUsed;
	private String processorFree;
	private String memoryFree;
	private List<Vm> vms;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getProcessorInformation() {
		return processorInformation;
	}
	public void setProcessorInformation(String processorInformation) {
		this.processorInformation = processorInformation;
	}
	public String getMemoryInformation() {
		return memoryInformation;
	}
	public void setMemoryInformation(String memoryInformation) {
		this.memoryInformation = memoryInformation;
	}
	public String getProcessorUsed() {
		return processorUsed;
	}
	public void setProcessorUsed(String processorUsed) {
		this.processorUsed = processorUsed;
	}
	public String getMemoryUsed() {
		return memoryUsed;
	}
	public void setMemoryUsed(String memoryUsed) {
		this.memoryUsed = memoryUsed;
	}
	public String getProcessorFree() {
		return processorFree;
	}
	public void setProcessorFree(String processorFree) {
		this.processorFree = processorFree;
	}
	public String getMemoryFree() {
		return memoryFree;
	}
	public void setMemoryFree(String memoryFree) {
		this.memoryFree = memoryFree;
	}
	public List<Vm> getVms() {
		return vms;
	}
	public void setVms(List<Vm> listVm) {
		this.vms = listVm;
	}
	
}
