package com.rrdssfgcs.interviewcheatsheet.dao;


import com.rrdssfgcs.interviewcheatsheet.entity.Article;

/**
 * 文章数据操作类
 *
 * @author parker
 * @time 2017-10-04 13:57
 **/
public interface ArticleDao {
    Article selectArticleByDocid(String docid);

    void insertArticle(String docid, String title, String content, String author, String source, String url, String update_time, String insert_time);
}
