package com.rrdssfgcs.interviewcheatsheet.data.spider;

import java.io.Serializable;

/**
 * 面经文章类
 *
 * @author parker
 * @time 2017-10-03 20:47
 **/
public class Article implements Serializable {
    private String docid;
    private String title;
    private String content;
    private String author;
    private String source;
    private String url;

    private String updateTime;
    private String insertTime;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "docid='" + docid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", insertTime='" + insertTime + '\'' +
                '}';
    }
}
