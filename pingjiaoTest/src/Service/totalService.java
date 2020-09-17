package Service;

import java.util.List;

import Dao.totalDao;
import entity.PingTerm;

public class totalService {
// 获得所有界面 并且放在界面中
	public List<PingTerm> getAllTerms(){
	totalDao to = new totalDao();
	List<PingTerm> ls = to.searchEntity(null);
	return ls;
	}
	//判断界面是否成功更新
	public boolean updateTerm(PingTerm t) {
		totalDao to = new totalDao();
		int a  = to.updataEntity(t);
		if(a==1) {
			return true;
		}else {
			return false;
		}
	}
}
