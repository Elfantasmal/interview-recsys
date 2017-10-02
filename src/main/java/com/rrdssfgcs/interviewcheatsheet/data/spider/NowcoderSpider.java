package com.rrdssfgcs.interviewcheatsheet.data.spider;

import com.rrdssfgcs.interviewcheatsheet.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * 牛客网抓取类
 *
 * @author parker
 * @time 2017-09-29 22:09
 **/
public class NowcoderSpider extends BaseSpider {

    protected String getFromUrlAndSaveToFileByTitle(String url, String cssQueryTitle, String cssQueryContent) {
        if (StringUtils.isBlank(url) || StringUtils.isBlank(cssQueryTitle) || StringUtils.isBlank(cssQueryContent)) {
            return null;
        }
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements newsTitle = doc.select(cssQueryTitle);
        Elements newsText = doc.select(cssQueryContent);

        String path = "./" + newsTitle;
        //TODO 这里的文件名写入可能报错
        FileUtils.saveStringToFile(newsText.text(), path);

        return null;
    }

}
