package com.huawei.java.main.Entity;

public class Virtual_machine {
	/** 序列号*/
	int seri;
	/**型号名称*/
	String name;
	/**CPU核数*/
	int cpu;
	/** 内存大小*/
	int Memory;
	/** 单节点还是双节点部署 0 为单节点，1为双节点*/
	int node;
	/** 表示单节点部署的虚拟机 在节点A还是节点B上*/
	char atnode = ' ';
	/** from Atnode */
	char fromAtnode=' ';
	/** 所在服务器列表的index*/
	int atWhitchServer = -1;
	
	
	public int getAtWhitchServer() {
		return atWhitchServer;
	}
	public void setAtWhitchServer(int atWhitchServer) {
		this.atWhitchServer = atWhitchServer;
	}
	public char getFromAtnode() {
		return fromAtnode;
	}
	public void setFromAtnode(char fromAtnode) {
		this.fromAtnode = fromAtnode;
	}
	public Virtual_machine(String name, int cpu, int memory, int node) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.Memory = memory;
		this.node = node;
	}
	//从另一个虚拟机复制一个虚拟机出来
	public Virtual_machine(Virtual_machine v) {
		super();
		this.name = v.getName();
		this.cpu = v.getCpu();
		this.Memory = v.getMemory();
		this.node = v.getNode();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getMemory() {
		return Memory;
	}
	public void setMemory(int memory) {
		Memory = memory;
	}
	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	public char getAtnode() {
		return atnode;
	}
	public void setAtnode(char atnode) {
		this.atnode = atnode;
	}
	public int getSeri() {
		return seri;
	}
	public void setSeri(int seri) {
		this.seri = seri;
	}
	@Override
	public String toString() {
		return "Virtual_machine [seri=" + seri + ", name=" + name + ", cpu=" + cpu + ", Memory=" + Memory + ", node="
				+ node + ", atnode=" + atnode + ", fromAtnode=" + fromAtnode + "]";
	}
	
}
