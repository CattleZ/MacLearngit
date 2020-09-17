package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JdbcConn;
import entity.Score;

public class ScoreDao {
   Connection conn = null;
   PreparedStatement ps = null;
   ResultSet rs = null;
	
	//将学生提交的评教数据插入到数据库中
	public int insertScore(Score SC) {
		conn = new JdbcConn().getConn();
		String sql = "INSERT INTO Score(sid,scient,term1,term2,term3,term4,term5,term6,term7,term8,term9,term10,others) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, SC.getSid());
			ps.setString(2, SC.getScient());
			ps.setInt(3,SC.getTerm1());
			ps.setInt(4,SC.getTerm2());
			ps.setInt(5,SC.getTerm3());
			ps.setInt(6,SC.getTerm4());
			ps.setInt(7,SC.getTerm5());
			ps.setInt(8,SC.getTerm6());
			ps.setInt(9,SC.getTerm7());
			ps.setInt(10,SC.getTerm8());
			ps.setInt(11,SC.getTerm9());
			ps.setInt(12,SC.getTerm10());
			ps.setString(13, SC.getOthers());
			int a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	//根据学生id查找 该学生是否已经评教 （防止重复评教）
	public Score searScore(int sid) {
		conn = new JdbcConn().getConn();
		String sql = "select * from Score where sid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			Score sc =null;
			while(rs.next()) {
				sc = new Score();
				sc.setSid(rs.getInt(1));
				sc.setScient(rs.getString(2));
				sc.setTerm1(rs.getInt(3));
				sc.setTerm2(rs.getInt(4));
				sc.setTerm3(rs.getInt(5));
				sc.setTerm4(rs.getInt(6));
				sc.setTerm5(rs.getInt(7));
				sc.setTerm6(rs.getInt(8));
				sc.setTerm7(rs.getInt(9));
				sc.setTerm8(rs.getInt(10));
				sc.setTerm9(rs.getInt(11));
				sc.setTerm10(rs.getInt(12));
				sc.setOthers(rs.getString(13));
				return sc;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//教师根据 教师的编号 以及所教科目查询本班学生的 评教信息
	public List<Score> seScorebyTeacher(int tid,String sci) {
		conn = new JdbcConn().getConn();
		String sql = "SELECT * FROM  score WHERE sid in" + 
				"(SELECT  sid  FROM student WHERE classid in" + 
				" (SELECT  classid FROM class  WHERE (cteacherid =? or cchinaid=?  or cmathid=? or cEnglishid =? )))" + 
				"and scient =?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setInt(2, tid);
			ps.setInt(3, tid);
			ps.setInt(4, tid);
			ps.setString(5, sci);
			rs = ps.executeQuery();
			List<Score> lS = new ArrayList<Score>();
			Score sc = null;
			while(rs.next()) {
				sc = new Score();
				sc.setSid(rs.getInt(1));
				sc.setScient(rs.getString(2));
				sc.setTerm1(rs.getInt(3));
				sc.setTerm2(rs.getInt(4));
				sc.setTerm3(rs.getInt(5));
				sc.setTerm4(rs.getInt(6));
				sc.setTerm5(rs.getInt(7));
				sc.setTerm6(rs.getInt(8));
				sc.setTerm7(rs.getInt(9));
				sc.setTerm8(rs.getInt(10));
				sc.setTerm9(rs.getInt(11));
				sc.setTerm10(rs.getInt(12));
				sc.setOthers(rs.getString(13));
				lS.add(sc);
			}
			return lS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询所有的评教信息
	public List<Score> seAllScore() {
		conn = new JdbcConn().getConn();
		String sql = "SELECT * FROM  score ";
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Score> lS = new ArrayList<Score>();
			Score sc = null;
			while(rs.next()) {
				sc = new Score();
				sc.setSid(rs.getInt(1));
				sc.setScient(rs.getString(2));
				sc.setTerm1(rs.getInt(3));
				sc.setTerm2(rs.getInt(4));
				sc.setTerm3(rs.getInt(5));
				sc.setTerm4(rs.getInt(6));
				sc.setTerm5(rs.getInt(7));
				sc.setTerm6(rs.getInt(8));
				sc.setTerm7(rs.getInt(9));
				sc.setTerm8(rs.getInt(10));
				sc.setTerm9(rs.getInt(11));
				sc.setTerm10(rs.getInt(12));
				sc.setOthers(rs.getString(13));
				lS.add(sc);
			}
			return lS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据学科查询该学科的评教信息
		public List<Score> seAllScoreBySci(String sci) {
			conn = new JdbcConn().getConn();
			String sql = "SELECT * FROM  score where scient =?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, sci);
				rs = ps.executeQuery();
				List<Score> lS = new ArrayList<Score>();
				Score sc = null;
				while(rs.next()) {
					sc = new Score();
					sc.setSid(rs.getInt(1));
					sc.setScient(rs.getString(2));
					sc.setTerm1(rs.getInt(3));
					sc.setTerm2(rs.getInt(4));
					sc.setTerm3(rs.getInt(5));
					sc.setTerm4(rs.getInt(6));
					sc.setTerm5(rs.getInt(7));
					sc.setTerm6(rs.getInt(8));
					sc.setTerm7(rs.getInt(9));
					sc.setTerm8(rs.getInt(10));
					sc.setTerm9(rs.getInt(11));
					sc.setTerm10(rs.getInt(12));
					sc.setOthers(rs.getString(13));
					lS.add(sc);
				}
				return lS;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

}
