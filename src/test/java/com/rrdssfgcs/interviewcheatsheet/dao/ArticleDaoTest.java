package com.rrdssfgcs.interviewcheatsheet.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.rrdssfgcs.interviewcheatsheet.entity.Article;
import com.rrdssfgcs.interviewcheatsheet.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDaoTest {
    @Test
    public void selectArticleByDocid() throws Exception {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/rrdssfgcs";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = 0;
        String sql = "select * from rrdssfgcs.article where docid= 'abc'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        Article article = sqlSession.selectOne("selectArticleByDocid", 1);
        article.getDocid();

//        ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
//        articleDao
//        String id = "abc";
//        Article curUser = articleDao.selectArticleByDocid(id);
//        if(curUser!=null){
//            System.out.println("HelloWorld:"+curUser.getDocid());
//        }
    }

}