package com.rrdssfgcs.interviewcheatsheet.spider;

import com.rrdssfgcs.interviewcheatsheet.dao.ArticleMapper;
import com.rrdssfgcs.interviewcheatsheet.entity.Article;
import com.rrdssfgcs.interviewcheatsheet.utils.ConfigUtil;
import com.rrdssfgcs.interviewcheatsheet.utils.SqlSessionFactoryUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        String baseurl = ConfigUtil.getNowcoderSpiderUrl();
        if (!StringUtils.isBlank(baseurl)) {
            List<String> urls = getUrls(baseurl);
            if (!CollectionUtils.isEmpty(urls)) {
                for (String str : urls) {
                    saveArticleToDatabase(getArticleFromUrl(str));
                }
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
            article.setDocid("N-" + UUID.randomUUID());
            article.setTitle(doc.select("title").text());
            article.setContent(doc.select("div.post-topic-des").text());
            article.setAuthor(doc.select("a[data-card-uid]").text());
            article.setSource("nowcoder");
            article.setUrl(doc.baseUri());
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            article.setInsertTime(df.format(day));
            article.setUpdateTime(doc.select("span.post-time").text().substring(4));
        }
        return article;
    }

    public List<String> getUrls(String baseUrl) {
        List<String> urls = new ArrayList<>();
        Document doc1 = null;
        try {
            doc1 = Jsoup.connect(baseUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //从获得的网页代码中找出第一个“面经”的链接地址
        Element doc2 = null;
        //找到相关元素串
        doc2 = doc1 != null ? doc1.select("div.discuss-main").get(0) : null;
        //查找第一个a元素
        Element link = doc2.select("a").first();
        // 取得链接地址
        String linkHref = "http://www.nowcoder.com" + link.attr("href");
        urls.add(linkHref);
        return urls;
    }

    private boolean saveArticleToDatabase(Article article) {
        if (article == null) {
            return false;
        }
        try (SqlSession session = SqlSessionFactoryUtil.openSession()) {
            ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
            articleMapper.insertArticle(article);
            session.commit();
        }
        System.out.println(article.toString());
        return true;
    }
}
