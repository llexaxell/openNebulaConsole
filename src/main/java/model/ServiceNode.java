package model;

public class ServiceNode extends AbstractNode{
	private String openNebulaVersion;
	private int numberVm;
	
	
	
	public String getOpenNebulaVersion() {
		return openNebulaVersion;
	}
	public void setOpenNebulaVersion(String openNebulaVersion) {
		this.openNebulaVersion = openNebulaVersion;
	}
	public int getNumberVm() {
		return numberVm;
	}
	public void setNumberVm(int numberVm) {
		this.numberVm = numberVm;
	}
	
	
}
