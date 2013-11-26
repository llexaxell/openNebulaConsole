package model;

import java.util.List;

import controller.MainController;

public class Infrastructure {
	
	private User user;
	private ServiceNode nodeParent;
	private List<NodeImpl> nodesChildren;
	private MainController controller;
	
	//Constructors
	
	public Infrastructure() {
		this.user = null;
		this.nodeParent = null;
		this.nodesChildren = null;
		this.controller = null;
	}


	public Infrastructure(MainController controller){
		this.user = null;
		this.nodeParent = new ServiceNode();
		this.nodesChildren = null;
		this.controller = controller;
	}
	
	//Getters and setters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServiceNode getNodeParent() {
		return nodeParent;
	}

	public void setNodeParent(ServiceNode nodeParent) {
		this.nodeParent = nodeParent;
	}

	public List<NodeImpl> getNodesChildren() {
		return nodesChildren;
	}

	public void setNodesChildren(List<NodeImpl> nodesChildren) {
		this.nodesChildren = nodesChildren;
	}

	public MainController getController() {
		return controller;
	}


	public void setController(MainController controller) {
		this.controller = controller;
	}
}
