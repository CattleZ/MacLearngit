package Total;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.URLDao;
import Tools.tool;


public class Test2 implements PageProcessor{
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000).setTimeOut(10000);
    public void process(Page page) {
    	URLDao ud = new URLDao();
    	try {
    		System.out.println("start");
			 conn = tool.getConn();
			 String sql = "INSERT INTO job1(J_Name,J_Dec,J_Intr,J_Rag,J_Natu,J_Money,J_Tel,J_Scar,J_Necc,J_Loa,J_Fname) values (?,?,?,?,?,?,?,?,?,?,?)";
			 page.putField("J_Name",page.getHtml().xpath("//div[@class='in']//h1/text()"));
			 
			 page.putField("J_Dec", page.getHtml().xpath("//div[@class='bmsg job_msg inbox']//*/text()").all());
			
			 page.putField("J_Intr", page.getHtml().xpath("//div[@class='tmsg inbox']/text()"));
			 
			 page.putField("J_Rag", page.getHtml().xpath("//p[@class='msg ltype']/text()"));
			
			 page.putField("J_Natu", page.getHtml().xpath("//p[@class='msg ltype']/text()"));
			
			 page.putField("J_Money", page.getHtml().xpath("//div[@class='cn']//strong/text()"));
			 System.out.println("end1");
			 page.putField("J_Tel", page.getHtml().xpath("//div[@class='bmsg inbox']/p/text()"));
			  System.out.println("end2");
			 page.putField("J_Scar", page.getHtml().xpath("//div[@class='jtag inbox']/p[@class='t2']/span/text()").all());
			 System.out.println("end3");
			 page.putField("J_Necc", page.getHtml().xpath("//div[@class='jtag inbox']/div[@class='t1']/*/text()").all());
			  System.out.println("end4");
			 page.putField("J_Loa", page.getHtml().xpath("//div[@class='cn']//span[@class='lname']/text()"));
			  System.out.println("end5");
			 page.putField("J_Fname", page.getHtml().xpath("//div[@class='cn']//p[@class='cname']/a/text()"));
			 
			 System.out.println("end6");
			 
			 
			 
		       String J_Name = page.getResultItems().get("J_Name").toString();
		       String J_Dec = page.getResultItems().get("J_Dec").toString();
		       String J_Intr = page.getResultItems().get("J_Intr").toString();
		       String J_Rag = page.getResultItems().get("J_Rag").toString();
		       String J_Natu = page.getResultItems().get("J_Natu").toString();
		       System.err.println("end14");
		       String J_Money = page.getResultItems().get("J_Money").toString();
		       
		       String J_Tel = page.getResultItems().get("J_Tel").toString();
		       
		       String J_Scar = page.getResultItems().get("J_Scar").toString();
		      
		       String J_Necc = page.getResultItems().get("J_Necc").toString();
		      
		       String J_Loa = page.getResultItems().get("J_Loa").toString();
		      
		       String J_Fname = page.getResultItems().get("J_Fname").toString();
		      
		       
		       stmt=conn.prepareStatement(sql);
		       stmt.setString(1, J_Name);
		       stmt.setString(2, J_Dec);
		       stmt.setString(3, J_Intr);
		       stmt.setString(4, J_Rag.split("\\|")[1]);
		       stmt.setString(5, J_Natu.split("\\|")[0]);
		      
		       stmt.setString(6, J_Money);
		       
		       stmt.setString(7, J_Tel);
		      
		       stmt.setString(8, J_Scar);
		       
		       stmt.setString(9, J_Necc);
		       
		       stmt.setString(10, J_Loa);
		      
		       stmt.setString(11, J_Fname);
		      
		       stmt.executeUpdate();
		      List<String> list = ud.getUrList();
		      page.addTargetRequests(list);
		       System.out.println("end");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}finally{
			tool.close(conn, stmt, rs);
		}
      

    }

    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {
        Spider.create(new Test2())
                .addUrl("http://jobs.51job.com/beijing-cyq/97919994.html?s=01&t=0")
               // .setScheduler(new FileCacheQueueScheduler("./51jobUrl"))
                .thread(5)
                .run();
    }
}
