package community_dis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Graph {
	 /**
     * 图数据结构：邻接表
     * */
    private Map<String, ArrayList<String>> adjT;
    /**
     * 节点属性列表，维护节点的id和社区信息
     * */
    private Map<String, HashSet<String>> nodeCommunityInfoPast = new HashMap<>();
    private Map<String, HashSet<String>> nodeCommunityInfoNew = new HashMap<>();

    public Graph(){
        this.adjT = new HashMap<>();
    }

    public Graph(String edgePath){
        this.adjT = new HashMap<String, ArrayList<String>>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(edgePath));
            String lines = null;
            String line = null;
            while((lines=reader.readLine())!=null){
            	line = lines.substring(1, 4);
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
              //  System.out.println(line);

                if (! this.adjT.containsKey(item[0])){
                    this.adjT.put(item[0], new ArrayList<>());
                    this.nodeCommunityInfoNew.put(item[0], new HashSet<>());
                }
                if (! this.adjT.containsKey(item[1])){
                    this.adjT.put(item[1], new ArrayList<>());
                    this.nodeCommunityInfoNew.put(item[1], new HashSet<>());
                }

                if (! this.adjT.get(item[0]).contains(item[1])){
                    this.adjT.get(item[0]).add(item[1]);
                }
                if (! this.adjT.get(item[1]).contains(item[0])){
                    this.adjT.get(item[1]).add(item[0]);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 判断节点之间是否有边
     * */
    public boolean hasEdge(String v, String w){
        return this.adjT.get(v).contains(w);
    }

    /**
     * 获取节点的邻居节点
     * */
    public ArrayList<String> neighbors(String node){
        return this.adjT.get(node);
    }

    /**
     * 获取网络中的所有节点
     * */
    public Iterable<String> nodes(){
        return this.adjT.keySet();
    }

    /**
     * 获取所有节点的社区信息
     * */
    public Map<String, HashSet<String>> getNodeCommunityInfo() {
        return this.nodeCommunityInfoPast;
    }

    /**
     * 获取节点的社区信息
     * */
    public HashSet<String> getCommnityLabel(String node){
        return this.nodeCommunityInfoPast.get(node);
    }

    /**
     * 更新节点的社区信息
     * */
    public void updateNodeCommunityLabel(String node, String cLabel){
        this.nodeCommunityInfoNew.get(node).add(cLabel);
    }

    /**
     * 在社区信息一轮更新完成后，将原始的社区信息进行覆盖
     * */
    public void coverCommunityInfo(){
        this.nodeCommunityInfoPast.clear();
        for (Map.Entry<String, HashSet<String>> entry : this.nodeCommunityInfoNew.entrySet()){
            nodeCommunityInfoPast.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
        for (Map.Entry<String, HashSet<String>> entry : this.nodeCommunityInfoNew.entrySet()){
            entry.getValue().clear();
        }
    }
    /**
     * 两个节点之间的公共邻居节点
     */
    public HashSet<String> getCommNeb(String u,String v){
    	ArrayList<String> un = this.neighbors(u);
    	ArrayList<String> vn = this.neighbors(v);
    	HashSet<String>  hs = new HashSet<>();
    	Iterator<String> it = un.iterator();
        Iterator<String> it2 = vn.iterator();
    	while(it.hasNext()) {
    		hs.add(it.next());
    	}
    	while(it2.hasNext()) {
    		hs.add(it2.next());
    	}
    	return hs;
    }
    
    /**
     * 计算两个节点之间的相似度sim
     */
    
    public double Sim(String u,String v) {
    	ArrayList<String> un = this.neighbors(u);
    	ArrayList<String> vn = this.neighbors(v);
    	long a = un.size()+vn.size();
    	//System.out.println(a+":a");
    	HashSet<String>  hs = new HashSet<>();
    	Iterator<String> it = un.iterator();
        Iterator<String> it2 = vn.iterator();
    	while(it.hasNext()) {
    		hs.add(it.next());
    	}
    	while(it2.hasNext()) {
    		hs.add(it2.next());
    	}
    	long b = hs.size();
    	//System.out.println(b+":b");
    	double res = ((double)(a-b)/(double)a);
    	return res;
    }
    
    /**
     * definition2 计算节点的重要度
     */
    public double IM(String n) {
    	return this.neighbors(n).size()+this.LLS(n);
    }
    /**
     * definition 2 domain similarity of node u
     */
    public double LLS(String n) {
    	ArrayList<String> neigh = this.neighbors(n);
    	double res = 0.0;
    	Iterator<String> it = neigh.iterator();
    	while(it.hasNext()) {
    		res+=(1-this.Sim(n, it.next()));
    	}
    	return res;
    }
    /**
     * 建立两个点之间公共邻居节点的邻接矩阵
     * Aij
     */
    public int [][] getAd(String u,String v){
    	int a = this.getCommNeb(u, v).size();
    	int A[][] =  new int[a][a];
    	ArrayList<String> al = this.neighbors(u);
    	ArrayList<String> bl = this.neighbors(v);
    	for(int i=0;i<al.size();i++) {
    		for(int j=0;j<bl.size();j++) {
    			if(this.hasEdge(al.get(i), bl.get(j))) {
    				A[i][j] = 1;
    			}else {
    				A[i][j] = 0;
    			}
    		}
    	}
    	return A;
    }
    /**
     * 计算 link strength
     */
    public double getStrLin(String u,String v) {
    	double x = 0.01;
    	double res = 0.0;
    	long d = 0;
    	int  f = this.getCommNeb(u, v).size();
    	int A[][] =this.getAd(u, v);
    	for(int i=0;i<A.length;i++) {
    		for(int j =0;j<A[0].length;j++) {
    			d+=A[i][j];
    		}
    	}
    	res = this.Sim(u, v)+((double)d/(double)(f*(f-1)))+x;
    	return res;
    }
     /**
      * 计算归属度   al代表这某一个社区
      */
    public double getOS(String u,ArrayList<String> al) {
    	double res = 0.0;//分子
    	double dre = 0.0;//分母
        Iterator<String> it = al.iterator();
        while(it.hasNext()) {
        	String n = it.next();
        	res+=Sim(u,n);
            int A[][] = this.getAd(u, n);
            for(int i=0;i<A.length;i++) {
            	for(int j=0;j<A[0].length;j++) {
            		dre+=(double)A[i][j];
            	}
            }
        }
        return res/dre;
    }
    /**
     * The objective function
     * 0<CQ<1
     * Ec represent the total number of sides of the community C internal connection,
     * Ecb represents the total number of sides of the community C external connection
     */
    /**
     * @param al 代表一个社区
     * @return 社区的内部节点的链接数
     */
    public double getCQEc(ArrayList<String> al) {
    	if(al.isEmpty()) {
    		return 0.0;
    	}
    	double res = 0.0;
    	for(int i=0;i<al.size();i++) {
    		for(int j=0;j<al.size();j++) {
    			if(i!=j&&this.hasEdge(al.get(i), al.get(j))) {
    				res+=1.00;
    			}
    		}
    	}
    	return res;
    }
   /**
    * @param al 代表一个社区
    * @return res代表返回社区的向外链接的边的数量
    */
    
    public double getCQEcb(ArrayList<String> al) {
    	if(al.isEmpty()) {
    		return 0.0;
    	}
    	//用来存储所有节点社区外的邻居节点
    	HashSet<String>  hs = new HashSet<String>();
    	Iterator<String> it = al.iterator();
        while(it.hasNext()) {
        	//存储所有的邻居节点，包括社区内的
        	String node = it.next();
        	hs.addAll(this.neighbors(node));
        }
        HashSet<String> hhs = new HashSet<String>();
        hhs.addAll(hs);
    	//祛除重复的
        Iterator<String> ht = hs.iterator();
        while(ht.hasNext()) {
        	String elem = ht.next();
        	if(al.contains(elem)) {
        		hhs.remove(elem);
        		System.out.println("ssssss"+elem);
        	}
        }
        //返回社区内所有节点的向外链接的节点的边的数量
        double res = hhs.size();
    	return res;
    }
    
   /**
    * 计算CQ的值
    */
    public double getCQ(ArrayList<String> al) {
    	
    	double Ec = this.getCQEc(al);
    	double Ecb= this.getCQEcb(al);
    	
    	if((Ec+Ecb)==0.0||(Ec-Ecb)==0.0) {
    		return 0.0;
    	}
    	
    	return (Ec-Ecb)/(Ec+Ecb);
    }
}