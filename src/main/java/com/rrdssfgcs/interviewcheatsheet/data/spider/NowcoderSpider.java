package com.rrdssfgcs.interviewcheatsheet.data.spider;

import com.rrdssfgcs.interviewcheatsheet.entity.Article;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//获取baseUrl的链接加入的包

/**
 * 牛客网抓取类
 *
 * @author parker
 * @time 2017-09-29 22:09
 **/

public class NowcoderSpider extends BaseSpider {

    @Override
    public void update() {

        List<String> urls = getUrls("");
        if (!CollectionUtils.isEmpty(urls)) {
//            urls.forEach(u -> saveArticleToDatabase(getArticleFromUrl(u)));
            for (String str : urls) {
                saveArticleToDatabase(getArticleFromUrl(str));
            }
        }
    }

    @Override
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
            article.setTitle(doc.select("title").text());
//            article.setTitle(doc.title());
            article.setContent(doc.select("div.post-topic-des").text());
            article.setAuthor(doc.select("a[data-card-uid]").text());
            article.setSource("nowcoder");
            article.setUrl(doc.baseUri());
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                System.out.println(df.format(day));
            article.setInsertTime(df.format(day));
            article.setUpdateTime(doc.select("span.post-time").text());
        }
        return article;
    }

    public List<String> getUrls(String baseUrl) {
        List<String> urls = new ArrayList<>();
        //TODO

        Document doc1 = null;
        try {
            doc1 = Jsoup.connect(baseUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //从获得的网页代码中找出第一个“面经”的链接地址
        Element doc2 = null;
        doc2 = doc1.select("div.discuss-main").get(0);//找到相关元素串
        Element link = doc2.select("a").first();//查找第一个a元素
        String linkHref = "www.nowcoder.com" + link.attr("href"); // 取得链接地址
        urls.add(linkHref);
        return urls;
    }

    private boolean saveArticleToDatabase(Article article) {
        if (article == null) {
            return false;
        }

        return true;
    }

}
