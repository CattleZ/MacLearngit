package com.huawei.java.main.Entity;
/**
 * 购买的服务器组成的集群
 * @author gorge
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Cluster {
	List<ServerE> cl = new ArrayList<ServerE>();
	//所有虚拟机的map（键是 虚拟机的id 值是该虚拟机）
	Map<Integer,Virtual_machine> allViMap = new HashMap<Integer, Virtual_machine>();
	
	public Map<Integer, Virtual_machine> getAllViMap() {
		return allViMap;
	}
	
	//增加一台服务器
	public void addServler(ServerE e) {
		cl.add(e);
	}
	public List<ServerE> getCl() {
		return cl;
	}
	//停止一台服务器
	public void stopServ(ServerE e) {
		e.setSprice(0);
	}
	//开启一台服务器
	public void startServ(ServerE e) {
		e.setSprice(e.getDprice());
	}
	public void addViToViMap(int id,Virtual_machine vi) {
		this.allViMap.put(id,vi);
	}
	public void removeViFromViMap(int id) {
		this.allViMap.remove(id);
	}
	//获得虚拟机的长度
	public int getAllViMapSize() {
		return this.allViMap.size();
	}
}
