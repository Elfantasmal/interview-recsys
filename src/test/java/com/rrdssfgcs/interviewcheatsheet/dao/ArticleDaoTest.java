package com.rrdssfgcs.interviewcheatsheet.dao;

import com.rrdssfgcs.interviewcheatsheet.entity.Article;
import com.rrdssfgcs.interviewcheatsheet.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleDaoTest {

    private ArticleMapper articleMapper;

    @Test
    public void insertArticle() throws Exception {
        SqlSession session = SqlSessionFactoryUtil.openSession();
        ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
        Article article = new Article();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setInsertTime(df.format(day));
        articleMapper.insertArticle(article);
        session.commit();
        session.close();
    }

    @Test
    public void selectArticleByDocid() throws Exception {
        SqlSession session = SqlSessionFactoryUtil.openSession();
        ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
        Article article = articleMapper.selectArticleByDocid(7);
        session.close();
    }
}