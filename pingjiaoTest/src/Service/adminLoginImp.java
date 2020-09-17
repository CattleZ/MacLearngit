package Service;

import java.util.List;

import Dao.adminDao;
import entity.admin;

public class adminLoginImp implements LoginInt<admin>{

	@Override
	public boolean getLogin(admin t) {
		// TODO Auto-generated method stub
		adminDao dao = new adminDao();
		List<admin>  ls =dao.searchEntity(t);
		if(ls!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getRegist(admin t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getUpdate(admin t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getDel(admin t) {
		// TODO Auto-generated method stub
		return false;
	}

}
