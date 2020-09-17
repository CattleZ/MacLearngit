package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JdbcConn;
import entity.Tclass;

public class classDao implements UntilInt<Tclass> {
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      //增加班级
	@Override
	public int addEntity(Tclass t) {
		conn = new JdbcConn().getConn();
		String sql = "INSERT INTO class(classid,classname,cteacherid,cmathid,cchinaid,cEnglishid,ctotal,did) values(?,?,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getClassid());
			ps.setString(2, t.getClassname());
			ps.setInt(3, t.getCteacherid());
			ps.setInt(4, t.getCmathid());
			ps.setInt(5, t.getCchinaid());
			ps.setInt(6, t.getcEnglishid());
			ps.setInt(7, t.getCtotal());
			ps.setInt(8, t.getDid());
			int a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleEntity(Tclass t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tclass> searchEntity(Tclass t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updataEntity(Tclass t) {
		conn = new JdbcConn().getConn();
		String sql = "UPDATE class SET classname=?,cteacherid=?,cmathid=?,cchinaid=?,cEnglishid=?,ctotal=?,did=? WHERE classid=?";
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, t.getClassname());
			ps.setInt(2, t.getCteacherid());
			ps.setInt(3, t.getCmathid());
			ps.setInt(4, t.getCchinaid());
			ps.setInt(5, t.getcEnglishid());
			ps.setInt(6, t.getCtotal());
			ps.setInt(7, t.getDid());
			ps.setInt(8, t.getClassid());
			int a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//查询所有的班级信息
	public List<Tclass> searchAllEntity(){
		conn = new JdbcConn().getConn();
		String sql = "select * from class";
		List<Tclass> ls = new ArrayList<Tclass>();
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Tclass  tc = null;
			while(rs.next()) {
				tc = new Tclass();
				tc.setClassid(rs.getInt(1));
				tc.setClassname(rs.getString(2));
				tc.setCteacherid(rs.getInt(3));
				tc.setCmathid(rs.getInt(4));
				tc.setCchinaid(rs.getInt(5));
				tc.setcEnglishid(rs.getInt(6));
				tc.setCtotal(rs.getInt(7));
				ls.add(tc);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//删除班级信息
	public int delCLass(int cid) {
		conn = new JdbcConn().getConn();
		String sql = "delete from class where classid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cid);
		    int a = ps.executeUpdate();
		    return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}

}
