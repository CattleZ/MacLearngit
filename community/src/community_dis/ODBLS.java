package community_dis;

import java.util.ArrayList;
import java.util.Iterator;

public class ODBLS {
	
	public static void main(String [] args) {
		Graph graph = new Graph("/Users/gorge/Desktop/timedata/test.csv");
		/**
		 * 测试
		 */
		Iterable<String> it = graph.nodes();
		Iterator<String> s = it.iterator();
		//用来存储节点的重要度的map 数字与节点的顺序是一样的
		ArrayList<Double> nums = new ArrayList<Double>();
		ArrayList<String> nodes = new ArrayList<String>();//用来存储重要的节点的集合
		
		while(s.hasNext()) {
			String node = s.next();
			//节点的重要性
			double num = graph.IM(node);
			//System.out.println(node+":"+num);
			//初始化数列
		
			if(nodes.isEmpty()) {
				nums.add(num);
				nodes.add(node);
			}else {
				//遍历节点的数字序列比较大小并且插入节点
				int len = nums.size();
				if(len==1) {
					if(num>=nums.get(0)) {
						nums.add(0,num);
						nodes.add(0,node);
					}else {
						nums.add(num);
						nodes.add(node);
					}
				}else {
					for(int i=1;i<len;i++) {
						if(num>=nums.get(i)&&num<nums.get(i-1)) {
							nums.add(i,num);
							nodes.add(i,node);
							break;
						}
						if(i==len-1) {
							nums.add(num);
							nodes.add(node);
						}
					}
				}
			}
		}
		/**
		 * 输出节点的重要度
		 */
		for(int i=0;i<nodes.size();i++) {
			System.out.println(nodes.get(i)+":"+nums.get(i));
		}
		//输入图
		//返回一个社区集合 ArrayList  一个小的社区就是一个小的图
		ArrayList<ArrayList<String>> P = new ArrayList<ArrayList<String>>();
		//初始化社区
		Iterator<String> ImpoNode = nodes.iterator();
		
		ArrayList<String> NR= new ArrayList<>();
		while(ImpoNode.hasNext()) {
			System.out.println("--------------------------------");
			String node = ImpoNode.next();
			if(!NR.isEmpty()&&NR.contains(node)) {
				continue;
			}
			//初始化社区
			ArrayList<String> C = new ArrayList<String>();
			C.add(node);
			
			//初始化社区的邻居节点
			NR = graph.neighbors(node);
			
			Iterator<String> nrt = NR.iterator();
			//用来存储邻居节点的重要度
			//用来存储邻居节点
			ArrayList<Double> nums2 = new ArrayList<Double>();
			ArrayList<String> nodes2 = new ArrayList<String>();
			//计算邻居节点的归属度，并按从大到小的顺序排列
			while(nrt.hasNext()) {
				String node2 = nrt.next();
				System.out.println(node2);
				double num = graph.getOS(node2, C);
				
				if(nodes2.isEmpty()) {
					nums2.add(num);
					nodes2.add(node2);
				}else {
					//遍历节点的数字序列比较大小并且插入节点
					int len = nums2.size();
					if(len==1) {
						if(num>=nums2.get(0)) {
							nums2.add(0,num);
							nodes2.add(0,node2);
						}else {
							nums2.add(num);
							nodes2.add(node2);
						}
					}else {
						for(int i=1;i<len;i++) {
							if(num>=nums2.get(i)&&num<nums2.get(i-1)) {
								nums2.add(i,num);
								nodes2.add(i,node2);
								break;
							}
							if(i==len-1) {
								nums2.add(num);
								nodes2.add(node2);
							}
						}
					}
				}
			}
		/**
		 * 输出根据重要节点计算邻居节点的链接强度
		 */
			for(int i=0;i<nodes2.size();i++) {
			System.out.println(node+":"+nums2.get(i)+":"+nodes2.get(i));
		}
			
			
			//计算邻居节点的CQ值 看是不是能够归属到社区里面
			/**
			 * 经过这部分的处理的邻居节点剩下的只应该是能够归属到社区中的邻居节点
			 */
			  Iterator<String> itr = nodes2.iterator();
			  while(itr.hasNext()) {
				  //遍历下一个邻居节点
				  String nn = itr.next();
				  //没有新添加社区节点的CQ值
				  double a = graph.getCQ(C);
				  //计算新加入节点之后的CQ值
				  C.add(nn);
				  double b = graph.getCQ(C);
				  //输出
				  System.out.println(node+":"+nn+":"+a+":"+b);
				  
				  if(a>b) {
					  System.out.println(nn+" -----");
					 System.out.println(C.remove(nn));
				  }
				  if(a<=b) {
					 //ImpoNode.remove();
				  }
				  System.out.println("****************");
			  }
			P.add(C);
		}
		System.out.println("The result is ...");
		for(int i=0;i<P.size();i++) {
			System.out.println(P.get(i));
		}
	System.out.println("ending");
	}
	
}
