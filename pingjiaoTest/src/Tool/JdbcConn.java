package Tool;

import java.sql.Connection;
import java.sql.DriverManager;

import Tool.JdbcConfig;

public class JdbcConn implements JdbcConfig {
	 public  Connection getConn(){
	    	Connection conn = null;
	    	try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return conn;
	    }

}

