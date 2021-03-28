package com.huawei.java.main.Strategies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huawei.java.main.Entity.Cluster;
import com.huawei.java.main.Entity.ServerE;
import com.huawei.java.main.Entity.Virtual_machine;

public class FloodRout1 {
	// 服务器集群执行添加操作
	public void addVm(Cluster st, ServerE se) {
		st.addServler(se);
	}
	// 先判断集群上有没有可以利用的资源(有可用的资源就消耗掉资源，没有就返回null)
	public ServerE ServeIsAvalia(Cluster st, Virtual_machine vm) {
		List<ServerE> slEs = st.getCl();
		// 判断是单节点部署 还是双节点部署
		int sd = vm.getNode();
		// 双节点部署
		if (sd == 1) {
			for (int i = 0; i < slEs.size(); i++) {
				ServerE se = slEs.get(i);
				// 判断服务器的核 还有 内存是否同时够用
				if (se.getAcpu() >= vm.getCpu() / 2 && se.getBcpu() >= vm.getCpu() / 2
						&& se.getAmemory() >= vm.getMemory() / 2 && se.getBmemory() >= vm.getMemory() / 2) {
					se.setAcpu(se.getAcpu() - vm.getCpu() / 2);
					se.setBcpu(se.getBcpu() - vm.getCpu() / 2);
					se.setAmemory(se.getAmemory() - vm.getMemory() / 2);
					se.setBmemory(se.getBmemory() - vm.getMemory() / 2);
					se.setSprice(se.getDprice());
					vm.setAtWhitchServer(i);
					se.addMachine(vm.getSeri(), vm);
					st.addViToViMap(vm.getSeri(), vm);
					return se;
				}
			}
		}
		// 单节点部署
		if (sd == 0) {
			for (int i = 0; i < slEs.size(); i++) {
				ServerE se = slEs.get(i);
				// 内存大的优先部署
				int cho = se.getAmemory() >= se.getBmemory() ? 1 : 0;
				if (cho == 1) {
					// 首先检查A节点
					if (se.getAcpu() >= vm.getCpu() && se.getAmemory() >= vm.getMemory()) {
						se.setAcpu(se.getAcpu() - vm.getCpu());
						se.setAmemory(se.getAmemory() - vm.getMemory());
						vm.setAtnode('A');
						se.setSprice(se.getDprice());
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						st.addViToViMap(vm.getSeri(), vm);
						return se;
					}
					// 在检查B节点
					if (se.getBcpu() >= vm.getCpu() && se.getBmemory() >= vm.getMemory()) {
						se.setBcpu(se.getBcpu() - vm.getCpu());
						se.setBmemory(se.getBmemory() - vm.getMemory());
						vm.setAtnode('B');
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						st.addViToViMap(vm.getSeri(), vm);
						se.setSprice(se.getDprice());
						return se;
					}
				}
				if (cho == 0) {
					// 在检查B节点
					if (se.getBcpu() >= vm.getCpu() && se.getBmemory() >= vm.getMemory()) {
						se.setBcpu(se.getBcpu() - vm.getCpu());
						se.setBmemory(se.getBmemory() - vm.getMemory());
						vm.setAtnode('B');
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						st.addViToViMap(vm.getSeri(), vm);
						se.setSprice(se.getDprice());
						return se;
					}
					// 首先检查A节点
					if (se.getAcpu() >= vm.getCpu() && se.getAmemory() >= vm.getMemory()) {
						se.setAcpu(se.getAcpu() - vm.getCpu());
						se.setAmemory(se.getAmemory() - vm.getMemory());
						vm.setAtnode('A');
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						st.addViToViMap(vm.getSeri(), vm);
						se.setSprice(se.getDprice());
						return se;
					}
				}
				// 循环结束位置
			}
		}
		return null;
	}
	/////////////////////// 迁移部署方法（只有一台虚拟机的服务器 迁移的时候需要往 大于1的服务器上迁移）
	public ServerE ServeIsAvalia(List<ServerE> slEs, Virtual_machine vm, int sid) {
		// 判断是单节点部署 还是双节点部署
		int sd = vm.getNode();
		// 双节点部署
		if (sd == 1) {
			for (int i = 0; i <slEs.size(); i++) {
				ServerE se = slEs.get(i);
				if (se.getId() == sid) {
					continue;
				}
				// 判断服务器的核 还有 内存是否同时够用
				if (se.getAcpu() >= vm.getCpu() / 2 && se.getBcpu() >= vm.getCpu() / 2
						&& se.getAmemory() >= vm.getMemory() / 2 && se.getBmemory() >= vm.getMemory() / 2
						&& se.getMapV().size() >= 1) {
					se.setAcpu(se.getAcpu() - vm.getCpu() / 2);
					se.setBcpu(se.getBcpu() - vm.getCpu() / 2);
					se.setAmemory(se.getAmemory() - vm.getMemory() / 2);
					se.setBmemory(se.getBmemory() - vm.getMemory() / 2);
					se.setSprice(se.getDprice());
					vm.setAtWhitchServer(i);
					se.addMachine(vm.getSeri(), vm);
					return se;
				}
			}
		}
		// 单节点部署
		if (sd == 0) {
			for (int i = 0; i < slEs.size(); i++) {
				ServerE se = slEs.get(i);
				if (se.getId() == sid) {
					continue;
				}
				// 内存大的优先部署
				int cho = se.getAmemory() >= se.getBmemory() ? 1 : 0;
				if (cho == 1) {
					// 首先检查A节点
					if (se.getAcpu() >= vm.getCpu() && se.getAmemory() >= vm.getMemory() && se.getMapV().size() >= 1) {
						se.setAcpu(se.getAcpu() - vm.getCpu());
						se.setAmemory(se.getAmemory() - vm.getMemory());
						vm.setAtnode('A');
						se.setSprice(se.getDprice());
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						return se;
					}
					// 在检查B节点
					if (se.getBcpu() >= vm.getCpu() && se.getBmemory() >= vm.getMemory() && se.getMapV().size() >= 1) {
						se.setBcpu(se.getBcpu() - vm.getCpu());
						se.setBmemory(se.getBmemory() - vm.getMemory());
						vm.setAtnode('B');
						se.setSprice(se.getDprice());
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						return se;
					}
				}
				if (cho == 0) {
					// 在检查B节点
					if (se.getBcpu() >= vm.getCpu() && se.getBmemory() >= vm.getMemory() && se.getMapV().size() >= 1) {
						se.setBcpu(se.getBcpu() - vm.getCpu());
						se.setBmemory(se.getBmemory() - vm.getMemory());
						vm.setAtnode('B');
						se.setSprice(se.getDprice());
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						return se;
					}
					// 首先检查A节点
					if (se.getAcpu() >= vm.getCpu() && se.getAmemory() >= vm.getMemory() && se.getMapV().size() >= 1) {
						se.setAcpu(se.getAcpu() - vm.getCpu());
						se.setAmemory(se.getAmemory() - vm.getMemory());
						vm.setAtnode('A');
						se.setSprice(se.getDprice());
						vm.setAtWhitchServer(i);
						se.addMachine(vm.getSeri(), vm);
						return se;
					}
				}
				// 循环结束位置
			}
		}
		return null;
	}

	// 虚拟机添加到服务器
	// 服务器的选择
	public int ChooseServ(List<ServerE> ls, Virtual_machine v) {
		int index = 0;
		for (int i = ls.size() - 1; i >= 0; i--) {
			// 获得服务器
			ServerE s = ls.get(i);

			if (v.getNode() == 1) {
				// 服务器的性能与虚拟机的性能对比
				if (s.getCpu() >= v.getCpu() && s.getMemory() >= v.getMemory()) {
					index = i;
					return index;
				}
			}
			if (v.getNode() == 0) {
				// 服务器的性能与虚拟机的性能对比
				if (s.getAcpu() >= v.getCpu() && s.getAmemory() >= v.getMemory()) {
					index = i;
					return index;
				}
			}
		}
		return index;
	}

	// 执行del的时候的操纵
	public int dell(Cluster c, int vid) {
		// 首先查找到对应的id所在的服务器
		List<ServerE> ls = c.getCl();
		Map<Integer, Virtual_machine> allViMap = c.getAllViMap();
		int i = allViMap.get(vid).getAtWhitchServer();
		// 查找到id 在该服务器上所在的位置
		ServerE se = ls.get(i);
		if (se.getMapV().containsKey(vid)) {
			// 先获得vid对应的虚拟机
			Virtual_machine vi = se.getMapV().get(vid);
			int node = vi.getNode();
			// 释放服务器的cpu以及内存
			if (node == 0) {
				char atnode = vi.getAtnode();
				if ('A' == atnode) {
					se.setAcpu(se.getAcpu() + vi.getCpu());
					se.setAmemory(se.getAmemory() + vi.getMemory());

				}
				if ('B' == atnode) {
					se.setBcpu(se.getBcpu() + vi.getCpu());
					se.setBmemory(se.getBmemory() + vi.getMemory());

				}
			}
			// 如果是双节点 就对两个节点进行增加
			if (node == 1) {
				se.setAcpu(se.getAcpu() + vi.getCpu() / 2);
				se.setBcpu(se.getBcpu() + vi.getCpu() / 2);
				se.setAmemory(se.getAmemory() + vi.getMemory() / 2);
				se.setBmemory(se.getBmemory() + vi.getMemory() / 2);

			}
			// 判断服务器是否节点停止
			if ((se.getAcpu() + se.getBcpu()) == se.getCpu() && (se.getAmemory() + se.getBmemory()) == se.getMemory()) {
				se.setSprice(0);
			}
			// 释放完内存后 将虚拟机移除
			se.getMapV().remove(vid);
			c.removeViFromViMap(vid);
			return i;
		}
		return -1;
	}

	// 虚拟机迁移的时候的删除操作
	// 执行del的时候的操纵
	public int dell(Cluster c, int vid, int sid) {
		// 首先查找到对应的id所在的服务器
		List<ServerE> ls = c.getCl();
		// 查找到id 在该服务器上所在的位置
		ServerE se = ls.get(sid - 1);
		if (se.getMapV().containsKey(vid)) {
			// 先获得vid对应的虚拟机
			Virtual_machine vi = se.getMapV().get(vid);
			int node = vi.getNode();
			// 释放服务器的cpu以及内存
			if (node == 0) {
				char atnode = vi.getFromAtnode();
				if ('A' == atnode) {
					se.setAcpu(se.getAcpu() + vi.getCpu());
					se.setAmemory(se.getAmemory() + vi.getMemory());

				}
				if ('B' == atnode) {
					se.setBcpu(se.getBcpu() + vi.getCpu());
					se.setBmemory(se.getBmemory() + vi.getMemory());

				}
			}
			// 如果是双节点 就对两个节点进行增加
			if (node == 1) {
				se.setAcpu(se.getAcpu() + vi.getCpu() / 2);
				se.setBcpu(se.getBcpu() + vi.getCpu() / 2);
				se.setAmemory(se.getAmemory() + vi.getMemory() / 2);
				se.setBmemory(se.getBmemory() + vi.getMemory() / 2);

			}
			// 判断服务器是否节点停止
			if ((se.getAcpu() + se.getBcpu()) == se.getCpu() && (se.getAmemory() + se.getBmemory()) == se.getMemory()) {
				se.setSprice(0);

			}
			// 释放完内存后 将虚拟机从该服务器上移除
			se.getMapV().remove(vid);
			return sid - 1;
		}
		return -1;
	}

	// 虚拟机的迁移
	public List<String> migrationVm(Cluster c1) {
		// 迁移命令列表
		List<String> mingLing = new ArrayList<String>();
		// 服务器的列表
		List<ServerE> ses = c1.getCl();
		FloodRout1 fRou = new FloodRout1();
		// 存储当天迁移了多少台虚拟机(这是对只有一台虚拟机的服务器进行迁移)
		for (int i = ses.size() - 1; i >= 0; i--) {
			if ((mingLing.size() + 2) < c1.getAllViMapSize() * 0.005) {
				ServerE se = ses.get(i);
				// 该服务器装载的虚拟机列表
				Map<Integer, Virtual_machine> vms = se.getMapV();
				// 存储一台服务器上可以迁移的虚拟机然后释放节点
				List<Virtual_machine> devmList = new ArrayList<Virtual_machine>();
				if (vms.size()==1) {
					Iterator<Integer> set = vms.keySet().iterator();
					while (set.hasNext()) {
						int k = set.next();
						Virtual_machine sv = vms.get(k);
						sv.setFromAtnode(sv.getAtnode());
						// 迁移(对该虚拟机重新部署)
						if ((mingLing.size() + 2) < c1.getAllViMapSize() * 0.005) {
							ServerE xE = fRou.ServeIsAvalia(ses, sv, se.getId());
							if (xE != null) {
								// 删除
								devmList.add(sv);
								if (sv.getNode() == 1) {
									String line = "(" + sv.getSeri() + ", " + xE.getXu_ID() + ")";
									mingLing.add(line);
								} else {
									String line = "(" + sv.getSeri() + ", " + xE.getXu_ID() + ", " + sv.getAtnode()
											+ ")";
									mingLing.add(line);
								}
							}
						} else {
							break;
						}
					}
				}
				// 进行内存的释放
				for (int j = 0; j < devmList.size(); j++) {
					dell(c1, devmList.get(j).getSeri(), se.getId());
				}
			} else {
				break;
			}
		}
		// 这是对有两天虚拟机的服务器进行迁移
		for (int i = ses.size() - 1; i >= ses.size()/3; i--) {
			if ((mingLing.size() + 2) < c1.getAllViMapSize() * 0.005) {
				ServerE se = ses.get(i);
				// 该服务器装载的虚拟机列表
				Map<Integer, Virtual_machine> vms = se.getMapV();
				// 存储一台服务器上可以迁移的虚拟机然后释放节点
				List<Virtual_machine> devmList = new ArrayList<Virtual_machine>();
				if (vms.size()==2) {
					Iterator<Integer> set = vms.keySet().iterator();
					while (set.hasNext()) {
						int k = set.next();
						Virtual_machine sv = vms.get(k);
						sv.setFromAtnode(sv.getAtnode());
						// 迁移(对该虚拟机重新部署)
						if ((mingLing.size() + 2) < c1.getAllViMapSize() * 0.005) {
							ServerE xE = fRou.ServeIsAvalia(ses, sv, se.getId());
							if (xE != null) {
								// 删除
								devmList.add(sv);
								if (sv.getNode() == 1) {
									String line = "(" + sv.getSeri() + ", " + xE.getXu_ID() + ")";
									mingLing.add(line);
								} else {
									String line = "(" + sv.getSeri() + ", " + xE.getXu_ID() + ", " + sv.getAtnode()
											+ ")";
									mingLing.add(line);
								}
							}
						} else {
							break;
						}
					}
				}
				// 进行内存的释放
				for (int j = 0; j < devmList.size(); j++) {
					dell(c1, devmList.get(j).getSeri(), se.getId());
				}
			} else {
				break;
			}
		}
		
		mingLing.add("(migration, " + mingLing.size() + ")");
		return mingLing;

	}
}
