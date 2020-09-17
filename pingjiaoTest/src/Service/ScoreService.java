package Service;

import Dao.ScoreDao;
import entity.Score;

public class ScoreService {
	//将评教信息插入到数据库中的业务逻辑
	public boolean insertScore(Score sc) {
		System.out.println(sc.toString());
		ScoreDao scoreDao = new ScoreDao();
		//首先查看该学生是否已经评教
		Score rScore = scoreDao.searScore(sc.getSid());
		if(rScore!=null) {
		if(sc.getSid()!=rScore.getSid()|| !sc.getScient().equals(rScore.getScient())) {
			int a = scoreDao.insertScore(sc);
			if(a!=-1) return true;
			return false;
		}
		}else {
			int a = scoreDao.insertScore(sc);
			if(a!=-1) return true;
			return false;
		}
		return false;
	}

}
