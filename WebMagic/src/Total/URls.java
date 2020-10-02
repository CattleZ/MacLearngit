package Total;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;
import Tools.tool;

public class URls implements PageProcessor {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000).setTimeOut(10000);
    public void process(Page page) {
    	try {
    		System.out.println("start");
			 conn = tool.getConn();
			 String sql = "INSERT INTO url(url) values (?)";
			 page.putField("url",page.getHtml().xpath("//div[@class='el']//p[@class='t1']/span/a/@href").all());
			 System.out.println("end1");
			
		       String  a = page.getResultItems().get("url").toString();
		       System.out.println("url"+a);
		       stmt=conn.prepareStatement(sql);
		       String [] arr = a.substring(1, a.lastIndexOf("]")).split("\\,");
		       for(int i=0;i<arr.length;i++){
		    	    stmt.setString(1, arr[i]);
		            stmt.executeUpdate();
		       }
		      
		       List<String> list = new ArrayList<String>();
		       for(int i=4;i<=2000;i++){
		    	   list.add("http://search.51job.com/list/010000,000000,0000,00,9,99,%2B,2,"+i+".html?lang=c&amp;stype=1&amp;postchannel=0000&amp;workyear=99&amp;cotype=01&amp;degreefrom=99&amp;jobterm=99&amp;companysize=99&amp;lonlat=0%2C0&amp;radius=-1&amp;ord_field=0&amp;confirmdate=9&amp;fromType=&amp;dibiaoid=0&amp;address=&amp;line=&amp;specialarea=00&amp;from=&amp;welfare=");
		      }
		       
		       page.addTargetRequests(list);
		       System.out.println("end");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}finally{
			tool.close(conn, stmt, rs);
		}
    }

    public List<String> getUrl(Page page){
        List<String> urls = page.getHtml()
                .xpath("//*[@id=\"resultList\"]/").links().all();
        return urls;
    }

    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {
        Spider.create(new URls())
                .addUrl("http://search.51job.com/list/010000,000000,0000,00,9,99,%2B,2,3.html?lang=c&amp;stype=1&amp;postchannel=0000&amp;workyear=99&amp;cotype=99&amp;degreefrom=99&amp;jobterm=99&amp;companysize=99&amp;lonlat=0%2C0&amp;radius=-1&amp;ord_field=0&amp;confirmdate=9&amp;fromType=&amp;dibiaoid=0&amp;address=&amp;line=&amp;specialarea=00&amp;from=&amp;welfare=")
                .setScheduler(new FileCacheQueueScheduler("./51jobUrl"))
                .thread(5)
                .run();
    }
}

