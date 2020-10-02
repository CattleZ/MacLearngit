package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Tools.tool;


public class URLDao {
      private Connection conn=null;
      private PreparedStatement stmt = null;
      private ResultSet  rs = null;
       public List<String> getUrList(){
    	   List<String> list = new ArrayList<String>();
    	   try {
			conn=tool.getConn();
			 String sql = "SELECT url FROM url ";
			 stmt=conn.prepareStatement(sql);
			 rs=stmt.executeQuery();
			 while(rs.next()){
				 String url = rs.getString("url");
			    list.add(url);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}finally{
			tool.close(conn, stmt, rs);
		}
    	  
    	   return list;
       }
    }
