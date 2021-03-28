package Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Entity.Cluster;
import Entity.ServerE;
import Entity.Virtual_machine;
import Strategies.FloodRout1;

public class Main {
	public static void main(String[] args) {
		long tt1 = System.currentTimeMillis();
		/** 初始化服务器的类型以及数据 */
		List<ServerE> serverEs = new ArrayList<ServerE>();
		/** 初始化虚拟机的类型以及数据 */
		Map<String, Virtual_machine> vms = new HashMap<String, Virtual_machine>();
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for (int i = N; i >= 1; i--) {
			String line = sc.nextLine();
			String[] lines = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
			// 先构造一个服务器对象
			ServerE s = new ServerE(lines[0], Integer.parseInt(lines[1]) / 2, Integer.parseInt(lines[2]) / 2,
					Integer.parseInt(lines[3]), Integer.parseInt(lines[4]));
			serverEs.add(s);
		}

		int M = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < M; i++) {
			String line = sc.nextLine().replaceAll(" ", "");
			String[] lines = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(",");
			// 构造一个虚拟机类型
			Virtual_machine vm = new Virtual_machine(lines[0], Integer.parseInt(lines[1]), Integer.parseInt(lines[2]),
					Integer.parseInt(lines[3]));
			vms.put(lines[0], vm);
		}
		// 创建服务器集群
		Cluster st = new Cluster();
		// 工具集
		FloodRout1 fr = new FloodRout1();
		// 输入指令
		int T = Integer.parseInt(sc.nextLine());
		// 排序 按照价格 从大到小
		Collections.sort(serverEs, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				ServerE s1 = (ServerE) o1;
				ServerE s2 = (ServerE) o2;
				// 日均花费少的优先考虑
				int xc = (s1.getGprice() + s1.getDprice() * T) / T;
				int xc1 = (s2.getGprice() + s2.getDprice() * T) / T;
				// 容量大 内核多 价格低 的优先考虑 1313970458
				return xc1 - xc;
			}
		});
		int DianFei = 0;
		// 需要购买服务的ID编号
		int NB = 0;
		// 这个用来存储在一天开始之前已经有多少台服务器了
		int nnb = 0;
		// 部署一个服务器真实ID 与 按照另外一种顺序生成的ID的对应
		Map<Integer, Integer> id_id = new HashMap<Integer, Integer>();
		// 已经购买的虚拟机的ID 对应的商店服务器列表的index
		Map<String, Integer> which_v_id_s_index = new HashMap<String, Integer>();
		for (int i = 0; i < T; i++) {
			List<String> migraMingList = null;
			if (i != 0) {
				migraMingList = fr.migrationVm(st);
			}
			int R = Integer.parseInt(sc.nextLine());
			// 初始化 当天购买服务器的情况
			Map<String, Integer> Sdmap = new HashMap<String, Integer>();
			// 将今天购买的服务器放置在这个列表里面
			List<ServerE> ssss = new ArrayList<ServerE>();
			// 初始化当天执行的创建请求的命令
			List<String> als = new ArrayList<String>();
			for (int j = 0; j < R; j++) {
				String line = sc.nextLine().replaceAll(" ", "");
				String[] lines = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(",");
				// 指令
				String Instru = lines[0];
				// 虚拟机
				String Vname = null;
				// 虚拟机ID
				int sid = 0;
				if (lines.length == 3) {
					Vname = lines[1];
					sid = Integer.parseInt(lines[2]);
				}
				if (lines.length == 2) {
					sid = Integer.parseInt(lines[1]);
				}
				// 执行添加操作
				if ("add".equals(Instru)) {
					// 需要从虚拟机商店复制一个虚拟机出来
					Virtual_machine nvm = new Virtual_machine(vms.get(Vname));
					nvm.setSeri(sid);
					ServerE isBuy = fr.ServeIsAvalia(st, nvm);
					// 获得服务器的index
					int index = 0;
					if (isBuy == null) {
						if (which_v_id_s_index.containsKey(Vname)) {
							index = which_v_id_s_index.get(Vname);
						} else {
							// 找到一个合适的服务器进行购买
							index = fr.ChooseServ(serverEs, nvm);
							which_v_id_s_index.put(Vname, index);
						}

						// 获得服务器 并将虚拟机添加到服务器上 ，将服务器添加到集群上
						// 从服务器上复制一个服务器出来
						ServerE se = new ServerE(serverEs.get(index));
						if (!Sdmap.containsKey(se.getName())) {
							Sdmap.put(se.getName(), 1);
						} else {
							Sdmap.replace(se.getName(), Sdmap.get(se.getName()) + 1);
						}
						NB++;
						se.setId(NB);
						id_id.put(NB, 0);
						// 将服务器添加到服务器集群上
						st.addServler(se);
						// 将购买服务器放在今天的服务器添加列表中
						ssss.add(se);
						// 购买完服务器之后，对新的虚拟机进行部署
						ServerE isBuy2 = fr.ServeIsAvalia(st, nvm);
						// 添加当前的添加命令
						if (!" ".equals(String.valueOf(nvm.getAtnode()))) {
							String co = isBuy2.getId() + ", " + nvm.getAtnode();
							als.add(co);
						} else {
							String co = String.valueOf(se.getId());
							als.add(co);
						}
					} else {
						// 添加当前的添加命令
						if (!" ".equals(String.valueOf(nvm.getAtnode()))) {
							String co = isBuy.getId() + ", " + nvm.getAtnode();
							als.add(co);
						} else {
							String co = String.valueOf(isBuy.getId());
							als.add(co);
						}
					}
				}
				// 如果是执行删除操作
				if ("del".equals(Instru)) {
					// 服务器释放内核 服务器释放空间
					fr.dell(st, sid);
				}
			}

			// 计算这一天的耗电量
			List<ServerE> ser = st.getCl();
			for (ServerE s : ser) {
				DianFei += s.getSprice();

			}
			// 输出总的数量
			System.out.println("(purchase, " + Sdmap.size() + ")");
			// 输出类型种类
			Set<String> keySet = Sdmap.keySet();
			int xxx = nnb;
			for (String key : keySet) {
				System.out.println("(" + key + ", " + Sdmap.get(key) + ")");
				// 寻找当天服务器名称与key相同的 服务器 ，然后更改id_id的映射
				for (int ii = 0; ii < ssss.size(); ii++) {
					ServerE ss = ssss.get(ii);
					if (ss.getName().equals(key)) {
						xxx++;
						id_id.put(ss.getId(), xxx - 1);
						ss.setXu_ID(xxx - 1);
					}
				}
			}

			nnb = NB;
			if (migraMingList == null) {
				// 输出迁移情况
				System.out.println("(migration, " + 0 + ")");
			} else {
				System.out.println(migraMingList.get(migraMingList.size() - 1));
				for (int z = 0; z < migraMingList.size() - 1; z++) {
					System.out.println(migraMingList.get(z));
				}
			}
			// 输出服务器的部署情况
			for (int z = 0; z < als.size(); z++) {
				// 获得正确的操作顺序
				String lString = als.get(z);
				// 查看一下 是双节点部署的指令还是单节点部署的指令
				int dinde = lString.indexOf(", ");
				if (dinde != -1) {
					String xs[] = lString.split(", ");
					int dinde_x = Integer.parseInt(xs[0]);

					System.out.println("(" + id_id.get(dinde_x) + ", " + xs[1] + ")");
				} else {
					int dinde_x = Integer.parseInt(lString);
					System.out.println("(" + id_id.get(dinde_x) + ")");
				}
			}

		}
		// 计算总的花费是多少
		long TotalMoney = 0;
		List<ServerE> ser = st.getCl();
		int totalmemo = 0;
		int totalCpu = 0;
		for (ServerE s : ser) {
			TotalMoney += s.getGprice();
		}
		System.out.println(TotalMoney + DianFei);
		long tt2 = System.currentTimeMillis();
		long r = tt2 - tt1;
		System.out.println(r);
	}
}
