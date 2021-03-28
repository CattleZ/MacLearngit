package Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务器类
 * @author gorge
 */
public class ServerE {
	/** 服务器的ID*/
	int id ;
	/** 虚拟ID*/
	int xu_ID;
	/**服务器型号*/
	String name ;
	int cpu;
	int memory;
	/**服务器CPU A*/
	int Acpu = 0;
	/** 服务器CPU B*/
	int Bcpu = 0;
	/** 内存A*/
	int Amemory =0;
	/** 内存B*/
	int Bmemory = 0;
	/** 价格*/
    int Gprice ;
	/** 每天的能耗价格*/
	int Dprice =0;
	/** 每天实际的花费*/
	int Sprice = Dprice;
	/** 服务器所装载的虚拟机*/
	Map<Integer, Virtual_machine> srMap = null;
	
	public ServerE(String name, int acpu, int amemory, int gprice, int dprice) {
		super();
		this.name = name;
		this.cpu = acpu*2;
		this.memory = amemory*2;
		this.Acpu = acpu;
		this.Bcpu = acpu;
		this.Amemory = amemory;
		this.Bmemory = amemory;
		this.Gprice = gprice;
		this.Dprice = dprice;
		this.Sprice = Dprice;
		
		this.srMap = new HashMap<Integer, Virtual_machine>();
	}
	public ServerE(ServerE s) {
		super();
		this.name = s.getName();
		this.Acpu = s.getAcpu();
		this.cpu = s.getCpu();
		this.memory = s.getMemory();
		this.Bcpu = s.getBcpu();
		this.Amemory = s.getAmemory();
		this.Bmemory = s.getBmemory();
		this.Gprice = s.getGprice();
		this.Dprice = s.getDprice();
		this.Sprice = Dprice;
		this.srMap = new HashMap<Integer, Virtual_machine>();
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAcpu() {
		return this.Acpu;
	}
	public void setAcpu(int acpu) {
		this.Acpu = acpu;
	}
	public int getBcpu() {
		return this.Bcpu;
	}
	public void setBcpu(int bcpu) {
		this.Bcpu = bcpu;
	}
	public int getAmemory() {
		return this.Amemory;
	}
	public void setAmemory(int amemory) {
		this.Amemory = amemory;
	}
	public int getBmemory() {
		return this.Bmemory;
	}
	public void setBmemory(int bmemory) {
		this.Bmemory = bmemory;
	}
	public int getGprice() {
		return this.Gprice;
	}
	public void setGprice(int gprice) {
		this.Gprice = gprice;
	}
	public int getDprice() {
		return this.Dprice;
	}
	public void setDprice(int dprice) {
		this.Dprice = dprice;
	}
	public int getSprice() {
		return this.Sprice;
	}
	public void setSprice(int sprice) {
		this.Sprice = sprice;
	}
	//服务器添加虚拟机
	public void addMachine(int seri,Virtual_machine v) {	
		this.srMap.put(seri, v);
	}
	//获得map集合
	public Map<Integer,Virtual_machine> getMapV(){
		return this.srMap;
	}
	//服务器的ID
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpu() {
		return this.cpu;
	}
	public int getMemory() {
		return this.memory;
	}
	public int getXu_ID() {
		return xu_ID;
	}
	public void setXu_ID(int xu_ID) {
		this.xu_ID = xu_ID;
	}
	@Override
	public String toString() {
		return "ServerE [id=" + id + ", cpu=" + cpu + ", memory=" + memory + ", Acpu=" + Acpu + ", Bcpu=" + Bcpu
				+ ", Amemory=" + Amemory + ", Bmemory=" + Bmemory + ", Gprice=" + Gprice + ", Dprice=" + Dprice
				+ ", Sprice=" + Sprice + ", srMap=" + srMap + "]";
	}
	
	
}
