package com.rrdssfgcs.interviewcheatsheet.spider;

import org.junit.Test;

public class NowcoderSpiderTest {
    private NowcoderSpider nowcoderSpider = new NowcoderSpider();

    @Test
    public void update() throws Exception {
        nowcoderSpider.update();
    }

    @Test
    public void getUrls() throws Exception {
        System.out.println(nowcoderSpider.getUrls("https://www.nowcoder.com/discuss/community/645?type=2"));
    }


    @Test
    public void getArticleFromUrl() throws Exception {
        //TODO
        System.out.println(nowcoderSpider.getArticleFromUrl("http://www.nowcoder.com/discuss/52113?type=2&order=0&pos=9&page=1").toString());
    }


}
