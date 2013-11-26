package model;

import org.opennebula.client.host.Host;


public class NodeImpl extends AbstractNode {
	Host host;
	
	public NodeImpl (Host host){
		this.host = host;
		this.setId(host.getId());
		this.setName(host.getName());
		this.setStatut(host.stateStr());
		this.setMemoryFree(host.xpath("HOST_SHARE/FREE_MEM"));
		this.setProcessorFree(host.xpath("HOST_SHARE/FREE_CPU"));
		this.setMemoryUsed(host.xpath("HOST_SHARE/USED_MEM"));
		this.setProcessorUsed(host.xpath("HOST_SHARE/USED_CPU"));
		this.setMemoryInformation(host.xpath("HOST_SHARE/MAX_MEM"));
		this.setProcessorInformation(host.xpath("HOST_SHARE/MAX_CPU"));
	}
}
