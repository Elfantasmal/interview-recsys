package com.rrdssfgcs.interviewcheatsheet.data.spider;

import com.rrdssfgcs.interviewcheatsheet.entity.Article;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 牛客网抓取类
 *
 * @author parker
 * @time 2017-09-29 22:09
 **/

public class NowcoderSpider extends BaseSpider {

    public void update() {

        List<String> urls = getUrls("");
        if (!CollectionUtils.isEmpty(urls)) {
            urls.forEach(u -> saveArticleToDatabase(getArticleFromUrl(u)));
        }
    }

    public Article getArticleFromUrl(String url) {
        Article article = new Article();
        if (StringUtils.isBlank(url)) {
            return article;
        }
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {
            article.setTitle(doc.select("").text());
            //TODO
//            article.setContent();
//            article.setContent();
//            article.setContent();
//            article.setContent();
//            article.setContent();
//            article.setUpdateTime(LocalDate.now());
        }
        return article;
    }

    private List<String> getUrls(String baseUrl) {
        List<String> urls = new ArrayList<>();
        //TODO
        urls.add("asdasd");
        return urls;
    }

    private boolean saveArticleToDatabase(Article article) {
        if (article == null) {
            return false;
        }

        return true;
    }

}
