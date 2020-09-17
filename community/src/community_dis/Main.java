package community_dis;

import java.util.ArrayList;

public class Main {
	public static void main(String [] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(9);
		int ar[] = {4,2,4,5,1,8};
		for(int i=0;i<ar.length;i++) {
			int s = al.size();
			for(int j =0;j<s;j++) {
				
				if(ar[i]>=al.get(j)) {
					al.add(j,ar[i]);
					break;
				}else {
					al.add(ar[i]);
					break;
				}
				
				
			}
		}
				
		for(int i=0;i<al.size();i++) {
			System.out.print(al.get(i)+" ");
		}
		
	}
}
