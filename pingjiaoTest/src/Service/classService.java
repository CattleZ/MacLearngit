package Service;

import Dao.classDao;
import entity.Tclass;

public class classService {

	//删除班级的信息
	public boolean deleCLASS(int id) {
		classDao cdao = new classDao();
		int a = cdao.delCLass(id);
		if(a ==1) {
			return true;
		}
		return false;
	}
	//增加班级
	public boolean addClass(Tclass tc) {
		classDao cdao = new classDao();
		int a = cdao.addEntity(tc);
		if(a ==1) {
			return true;
		}
		return false;
	}
	
	//修改班级
	public boolean updateClass(Tclass tc) {
		classDao cdao = new classDao();
		int a = cdao.updataEntity(tc);
		if(a ==1) {
			return true;
		}
		return false;
	}
}
