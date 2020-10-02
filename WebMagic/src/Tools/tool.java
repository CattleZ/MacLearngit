package Tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * jdbc�Ĺ�����
 * @author hp
 *
 */
public class tool {
	
	private static String url = null;
	private static String user = null;
	private static String pwd = null;
	private static String driverClass = null;
	static{
		
		 Properties props = new Properties();
		 try {
				InputStream in = tool.class.getResourceAsStream("/db.properties");
			props.load(in);
		    url=props.getProperty("url");
		    user= props.getProperty("user");
		    pwd = props.getProperty("pwd");
		    driverClass= props.getProperty("driverClass");
		 } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ע������
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 /**a
  * ��ȡ��ȡ���Ӷ���ķ���
  * @throws Exception 
  */
	public static Connection getConn() throws Exception{
		Connection conn = DriverManager.getConnection(url,user,pwd);
		return conn;
	}
	
	
	/**
	 * �ͷ���Դ�ķ���
	 */
	public static void close(Connection conn,Statement stat,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(stat!=null)
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
