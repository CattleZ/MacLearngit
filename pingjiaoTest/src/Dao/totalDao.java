package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JdbcConn;
import entity.PingTerm;

public class totalDao implements UntilInt<PingTerm>{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	@Override
	public int addEntity(PingTerm t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleEntity(PingTerm t) {
		// TODO Auto-generated method stub
		return 0;
	}
    //查询所有的项目
	@Override
	public List<PingTerm> searchEntity(PingTerm t) {
		// TODO Auto-generated method stub
		conn = new JdbcConn().getConn();
		String sql = "select * from term where id=1";
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			List<PingTerm>  ls = new ArrayList<PingTerm>();
			PingTerm pp = null;
			while(rs.next()) {
				pp= new PingTerm();
				pp.setTerm1(rs.getString(2));
				pp.setTerm2(rs.getString(3));
				pp.setTerm3(rs.getString(4));
				pp.setTerm4(rs.getString(5));
				pp.setTerm5(rs.getString(6));
				pp.setTerm6(rs.getString(7));
				pp.setTerm7(rs.getString(8));
				pp.setTerm8(rs.getString(9));
				pp.setTerm9(rs.getString(10));
				pp.setTerm10(rs.getString(11));
				ls.add(pp);
				return ls;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updataEntity(PingTerm t) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				conn = new JdbcConn().getConn();
				String sql = "UPDATE term SET term1=?,term2=?,term3=?,term4=?,term5=?,term6=?,term7=?,term8=?,term9=?,term10=? WHERE id=1";
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1, t.getTerm1());
					ps.setString(2, t.getTerm2());
					ps.setString(3, t.getTerm3());
					ps.setString(4, t.getTerm4());
					ps.setString(5, t.getTerm5());
					ps.setString(6, t.getTerm6());
					ps.setString(7, t.getTerm7());
					ps.setString(8, t.getTerm8());
					ps.setString(9, t.getTerm9());
					ps.setString(10, t.getTerm10());
					int a = ps.executeUpdate();
					return a;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return 0;
	}

}
