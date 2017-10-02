package com.rrdssfgcs.interviewcheatsheet.data.spider;

/**
 * 数据抓取抽象类
 *
 * @author parker
 * @time 2017-09-29 21:56
 **/
public abstract class BaseSpider {
    protected abstract String getFromUrlAndSaveToFileByTitle(String url, String cssQueryTitle, String cssQueryContent);
}
