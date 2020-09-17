package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JdbcConn;
import entity.admin;
import entity.student;
import entity.teacher;

public class teaDao implements UntilInt<teacher> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
    //添加教师的操作
	@Override
	public int addEntity(teacher t) {
		// TODO Auto-generated method stub
		conn = new JdbcConn().getConn();
		String sql = "INSERT INTO teacher(tid,tname,tuser,tpwd,tage,gender) values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getTid());
			ps.setString(2, t.getTname());
			ps.setString(3, t.getTuser());
			ps.setString(4, t.getTpwd());
			ps.setString(6, t.getTgender());
			ps.setInt(5, t.getTage());
			int a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
    //删除教师
	@Override
	public int deleEntity(teacher t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<teacher> searchEntity(teacher t) {
		conn = new JdbcConn().getConn();
		List<teacher> list = new ArrayList<teacher>();
		teacher tea = null;
		String sql = "SELECT * FROM teacher WHERE tuser=? and tpwd =?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getTuser());
			ps.setString(2, t.getTpwd());
			rs = ps.executeQuery();
			while(rs.next()) {
				tea = new teacher();
				tea.setTid(rs.getInt(1));
				tea.setTname(rs.getString(2));
				tea.setTuser(rs.getString(3));
				tea.setTpwd(rs.getString(4));
				tea.setTage(rs.getInt(5));
				tea.setTgender(rs.getString(6));
				tea.setScore(rs.getInt(7));
				list.add(tea);
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    //更新教师的信息
	@Override
	public int updataEntity(teacher t) {
		// TODO Auto-generated method stub
		conn = new JdbcConn().getConn();
		String sql = "update teacher set tname=?,tuser=?,tpwd=?,gender=?,tage=?  where tid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getTname());
			ps.setString(2, t.getTuser());
			ps.setString(3, t.getTpwd());
			ps.setString(4, t.getTgender());
			ps.setInt(5, t.getTage());
			ps.setInt(6, t.getTid());
			int a =ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	//根据教师的id查找教师的信息
	public teacher searTeaById(int id) {
		conn = new JdbcConn().getConn();
		teacher tea = null;
		String sql = "SELECT * FROM teacher WHERE tid=?;";
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				rs = ps.executeQuery();
				while(rs.next()) {
					tea = new teacher();
					tea.setTid(rs.getInt(1));
					tea.setTname(rs.getString(2));
					tea.setTuser(rs.getString(3));
					tea.setTpwd(rs.getString(4));
					tea.setTage(rs.getInt(5));
					tea.setTgender(rs.getString(6));
					tea.setScore(rs.getInt(7));
					return tea;
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return tea;
	}
	//查询所有教师的信息
	public List<teacher> searchAllEntity() {
		conn = new JdbcConn().getConn();
		List<teacher> list = new ArrayList<teacher>();
		teacher tea = null;
		String sql = "SELECT * FROM teacher;";
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				tea = new teacher();
				tea.setTid(rs.getInt(1));
				tea.setTname(rs.getString(2));
				tea.setTuser(rs.getString(3));
				tea.setTpwd(rs.getString(4));
				tea.setTage(rs.getInt(5));
				tea.setTgender(rs.getString(6));
				tea.setScore(rs.getInt(7));
				list.add(tea);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//删除教师的信息
	public int deletTea(int sid) {
		conn = new JdbcConn().getConn();
		student stu = null;
		String sql = "DELETE FROM teacher WHERE tid=? ;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sid);
			int a=ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
}
