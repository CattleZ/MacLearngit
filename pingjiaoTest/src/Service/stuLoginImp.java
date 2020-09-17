package Service;

import java.util.List;

import Dao.studentDao;
import entity.Tclass;
import entity.student;

public class stuLoginImp implements LoginInt<student>{

	@Override
	public boolean getLogin(student t) {
		// TODO Auto-generated method stub
		studentDao dao = new studentDao();
		List<student>  ls =dao.searchEntity(t);
		if(ls!=null) {
			return true;
		}
		return false;
	}
   //增加学生
	@Override
	public boolean getRegist(student t) {
		// TODO Auto-generated method stub
		//首先查找这个学生id是否存在了
		studentDao dao = new studentDao();
		student s = dao.searchStudentByID(t.getSid());
		if(s==null) {
			int a = dao.addEntity(t);
			if(a==1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getUpdate(student t) {
		// TODO Auto-generated method stub
		studentDao dao = new studentDao();
		student s = dao.searchStudentByID(t.getSid());
		if(s!=null) {
			int a =dao.updataEntity(t);
			if(a!=-1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getDel(student t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//根据用户名以及密码 获得学生对象
	 public student getStudent(student t) {
		 studentDao dao = new studentDao();
		List<student>  ls =dao.searchEntity(t);
		 return ls.get(0);
	 }
	 //根据班级号或者班级的名称
	 public Tclass getcName(int id) {
		 studentDao dao = new studentDao();
		  Tclass cTclass =dao.getClassName2(id);
		// System.out.println(cname);
		 return cTclass;
	 }
	 //根据班级ID查询学院的名称
	 public String getDname(int id) {
		 studentDao dao = new studentDao();
		 String dpname =dao.getDeptName2(id);
		 System.out.println(dpname);
		 return dpname;
	 }
	 
	 //根据学生的id删除学生的信息
	 public boolean deleStudent(int sid) {
		 studentDao dao = new studentDao();
		 int a = dao.deletStu(sid);
		 if(a==1) {
			 return true;
		 }
		 return false;
	 }
}