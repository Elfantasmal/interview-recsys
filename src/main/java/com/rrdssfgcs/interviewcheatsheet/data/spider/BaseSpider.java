package com.rrdssfgcs.interviewcheatsheet.data.spider;

import com.rrdssfgcs.interviewcheatsheet.entity.Article;

/**
 * 数据抓取抽象类
 *
 * @author parker
 * @time 2017-09-29 21:56
 **/
public abstract class BaseSpider {
    public abstract void update();

    public abstract Article getArticleFromUrl(String url);
}
