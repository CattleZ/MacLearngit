package Tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
	
	
	
	public static void main(String[] args) {
		
		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		Collections.sort(x,new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return ((Integer)o2 - (Integer)o1);
			}
		});
		System.out.println(x);
	}

}
