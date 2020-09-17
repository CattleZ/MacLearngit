package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JdbcConn;
import entity.Tclass;
import entity.student;

public class studentDao implements UntilInt<student>{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//增加学生
	@Override
	public int addEntity(student t) {
		// TODO Auto-generated method stub
		conn = new JdbcConn().getConn();
		String sql = "INSERT INTO student(sid,sname,spwd,classid,sgender,sage,saddress) values(?,?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getSid());
			ps.setString(2, t.getSname());
			ps.setString(3, t.getSpwd());
			ps.setInt(4, t.getClassid());
			ps.setString(5, t.getSgender());
			ps.setInt(6, t.getSage());
			ps.setString(7, t.getSaddress());
			int a =ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleEntity(student t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<student> searchEntity(student t) {
		// TODO Auto-generated method stub
				conn = new JdbcConn().getConn();
				List<student> list = new ArrayList<student>();
				student stu = null;
				String sql = "SELECT * FROM student WHERE sid=? and spwd =?;";
				try {
					ps=conn.prepareStatement(sql);
					ps.setInt(1, t.getSid());
					ps.setString(2, t.getSpwd());
					rs = ps.executeQuery();
					while(rs.next()) {
						stu = new student();
						stu.setSid(rs.getInt("sid"));
						stu.setSname(rs.getString("sname"));
						stu.setSpwd(rs.getString("spwd"));
						stu.setClassid(rs.getInt("classid"));
						stu.setSgender(rs.getString("sgender"));
						stu.setSage(rs.getInt("sage"));
						stu.setSaddress(rs.getString("saddress"));
						list.add(stu);
						return list;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}

	@Override
	public int updataEntity(student t) {
		// TODO Auto-generated method stub
		conn = new JdbcConn().getConn();
		String sql = "update student set sname=?,spwd=?,sgender=?,sage=?,saddress=?  where sid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getSname());
			ps.setString(2, t.getSpwd());
			ps.setString(3, t.getSgender());
			ps.setInt(4, t.getSage());
			ps.setString(5, t.getSaddress());
			ps.setInt(6, t.getSid());
			int a=ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	//根据学生的班级ID 查找班级信息
	public Tclass getClassName2(int id) {
		conn = new JdbcConn().getConn();
		String sql = "select * from class where classid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			Tclass cTclass = null;
			while(rs.next()) {
				cTclass= new Tclass();
				cTclass.setClassid(rs.getInt(1));
				cTclass.setClassname(rs.getString("classname"));
				cTclass.setCteacherid(rs.getInt(3));
				cTclass.setCmathid(rs.getInt(4));
				cTclass.setCchinaid(rs.getInt(5));
				cTclass.setcEnglishid(rs.getInt(6));
				cTclass.setCtotal(rs.getInt(7));
				cTclass.setDid(rs.getInt(8));
				//System.out.println(name);
				return cTclass;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据学生的学院id查找学院的名称
	public String getDeptName2(int id) {
		conn = new JdbcConn().getConn();
		String sql = "select * from dept where did=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("dname");
				//System.out.println(name);
				return name;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据学生的id查询学生的信息
	public student searchStudentByID(int id) {
		conn = new JdbcConn().getConn();
		student stu = null;
		String sql = "SELECT * FROM student WHERE sid=?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				stu = new student();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setSpwd(rs.getString("spwd"));
				stu.setClassid(rs.getInt("classid"));
				stu.setSgender(rs.getString("sgender"));
				stu.setSage(rs.getInt("sage"));
				stu.setSaddress(rs.getString("saddress"));
				return stu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//教师查询自己班级的学生
		public List<student> searchOnlyEntity(int id) {
			// TODO Auto-generated method stub
					conn = new JdbcConn().getConn();
					List<student> list = new ArrayList<student>();
					student stu = null;
					String sql = "SELECT * FROM student where classid"
							+ " in (select classid from class where cmathid=? or cchinaid =? or cEnglishid = ? )";
					try {
						ps=conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.setInt(2, id);
						ps.setInt(3, id);
						rs = ps.executeQuery();
						while(rs.next()) {
							stu = new student();
							stu.setSid(rs.getInt("sid"));
							stu.setSname(rs.getString("sname"));
							stu.setSpwd(rs.getString("spwd"));
							stu.setClassid(rs.getInt("classid"));
							stu.setSgender(rs.getString("sgender"));
							stu.setSage(rs.getInt("sage"));
							stu.setSaddress(rs.getString("saddress"));
							list.add(stu);
						}
						return list;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
		}
	
	
	//查询所有的学生 
	public List<student> searchAllEntity() {
		// TODO Auto-generated method stub
				conn = new JdbcConn().getConn();
				List<student> list = new ArrayList<student>();
				student stu = null;
				String sql = "SELECT * FROM student";
				try {
					ps=conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						stu = new student();
						stu.setSid(rs.getInt("sid"));
						stu.setSname(rs.getString("sname"));
						stu.setSpwd(rs.getString("spwd"));
						stu.setClassid(rs.getInt("classid"));
						stu.setSgender(rs.getString("sgender"));
						stu.setSage(rs.getInt("sage"));
						stu.setSaddress(rs.getString("saddress"));
						list.add(stu);
					}
					return list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}
	//根据学生id 删除学生信息
	public int deletStu(int sid) {
		conn = new JdbcConn().getConn();
		student stu = null;
		String sql = "DELETE FROM student WHERE sid=? ;";
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
