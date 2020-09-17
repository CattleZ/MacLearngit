package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JdbcConn;
import entity.admin;

public class adminDao implements UntilInt<admin> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public int addEntity(admin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleEntity(admin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<admin> searchEntity(admin t) {
		// TODO Auto-generated method stub
		conn = new JdbcConn().getConn();
		List<admin> list = new ArrayList<admin>();
		admin admin = null;
		String sql = "SELECT * FROM admin_table WHERE admin_name=? and admin_pwd =?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getAdmin_name());
			ps.setString(2, t.getAdmin_pwd());
			rs = ps.executeQuery();
			while(rs.next()) {
				admin = new admin();
				admin.setAdmin_count(rs.getInt(1));
				admin.setAdmin_id(rs.getInt(2));
				admin.setAdmin_name(rs.getString(3));
				admin.setAdmin_pwd(rs.getString(4));
				list.add(admin);
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updataEntity(admin t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
