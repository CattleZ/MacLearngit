package Total;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class TestRun implements PageProcessor {
	
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	/**
	 * @param zhanghe
	 */
	@Override
	public void process(Page page) {
		System.out.println("222");
    }

    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
        Spider.create(new TestRun())
                .addUrl("http://search.51job.com/jobsearch/search_result.php?fromJs=1&keyword=%E5%A4%A7%E6%95%B0%E6%8D%AE&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9")
//                .setScheduler(new FileCacheQueueScheduler("./51jobUrl"))
                .thread(5)
                .run();
    }
}
