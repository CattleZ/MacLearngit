package Total;

import java.util.List;

import Dao.URLDao;

public class ceshi {
public static void main(String[] args) {
	URLDao ud = new URLDao();
	List<String> list = ud.getUrList();
	System.out.println("length"+list.size());
	for(int i=0;i<20;i++){
		System.out.println(list.get(i));
	}
}
}
