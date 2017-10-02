package com.rrdssfgcs.interviewcheatsheet.data.spider;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 牛客网抓取类
 *
 * @author parker
 * @time 2017-09-29 22:09
 **/
public class NowcoderSpider extends BaseSpider {
//    private static final Logger logger = LogManager.getLogger(NowcoderSpider.class);

    public static void main(String[] args) {
        NowcoderSpider nowcoderSpider = new NowcoderSpider();
        nowcoderSpider.getFromUrl("https://www.nowcoder.com/discuss/52113?type=2&order=0&pos=9&page=1");
    }

    protected String getFromUrl(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
//            logger.error(e);
        }

        Elements newsTitle = doc.select("title");
        Elements newsText = doc.select("div.post-topic-des");

        //命令窗口打印输出
        System.out.println(newsTitle);
        System.out.println(newsText);

        //获取文本内容并打印输出
        String newsTitle1 = newsTitle.text();
        String newsText1 = newsText.text();
        System.out.println(newsTitle1);
        System.out.println(newsText1);

        //保存文件
        String fullFilename1 = "E:/Duty/ZZ/" + newsTitle1 + ".txt";

        try {
            File newTextFile = new File(fullFilename1);
            FileWriter fw1;
            fw1 = new FileWriter(newTextFile);
            fw1.write(newsText1);
            fw1.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
