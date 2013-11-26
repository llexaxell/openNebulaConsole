package model;

import java.util.List;

public class ServiceNode extends AbstractNode{
	private String openNebulaVersion;
	private int numberVm;
	private List<NodeImpl> nodeImpl;
	
	
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
	public List<NodeImpl> getNodeImpl() {
		return nodeImpl;
	}
	public void setNodeImpl(List<NodeImpl> nodeImpl) {
		this.nodeImpl = nodeImpl;
	}
	
	
}
