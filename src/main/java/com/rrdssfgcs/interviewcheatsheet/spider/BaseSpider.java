package com.rrdssfgcs.interviewcheatsheet.spider;

import com.rrdssfgcs.interviewcheatsheet.entity.Article;

/**
 * 数据抓取抽象类
 *
 * @author parker
 * @time 2017-09-29 21:56
 **/
public abstract class BaseSpider {

    /**
     * 更新文章
     */
    public abstract void update();

    /**
     * 从某个url抓取并生成文章类
     *
     * @param url 指定的url
     * @return 文章类
     */
    public abstract Article getArticleFromUrl(String url);
}
