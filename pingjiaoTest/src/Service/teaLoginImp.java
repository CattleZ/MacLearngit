package Service;

import java.util.List;

import Dao.teaDao;
import entity.teacher;
import jdk.nashorn.internal.ir.Flags;

public class teaLoginImp implements LoginInt<teacher> {

	@Override
	public boolean getLogin(teacher t) {
		// TODO Auto-generated method stub
				teaDao dao = new teaDao();
				List<teacher>  ls =dao.searchEntity(t);
				if(ls!=null) {
					return true;
				}
				return false;
	}

	//添加教师的操作
	@Override
	public boolean getRegist(teacher t) {
		// TODO Auto-generated method stub
		teaDao dao = new teaDao();
		int a  = dao.addEntity(t);
		if(a==1) {
			return true;
		}
		return false;
	}

	//教师修改自己的信息
	@Override
	public boolean getUpdate(teacher t) {
		// TODO Auto-generated method stub
		//首先查找数据库中是否存在这个信息 如果存在就更行
		teaDao dao = new teaDao();
		teacher ls = dao.searTeaById(t.getTid());
		if(ls!=null) {
			int a =dao.updataEntity(t);
			if(a==1) {
				return true;
			}
		}
		//如果不存在就不更新
		return false;
	}

	@Override
	public boolean getDel(teacher t) {
		// TODO Auto-generated method stub
		return false;
	}
	//根据教师id删除教师
	public boolean getDelTea(int tid) {
		teaDao dao = new teaDao();
		teacher ls = dao.searTeaById(tid);
		if(ls!=null) {
			int a = dao.deletTea(tid);
			if(a==1) {
				return true;
			}
		}
		//如果不存在就不删除
		return false;
	}

}
