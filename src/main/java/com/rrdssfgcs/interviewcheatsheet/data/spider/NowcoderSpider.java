package com.rrdssfgcs.interviewcheatsheet.data.spider;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(NowcoderSpider.class);

    protected String getFromUrl(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        Document doc = null;
        try {
            doc = Jsoup.connect("http://en.wikipedia.org/").get();
        } catch (IOException e) {
            logger.error(e);
        }
        Elements newsHeadlines = doc.select("#mp-itn b a");
        return null;
    }
}
