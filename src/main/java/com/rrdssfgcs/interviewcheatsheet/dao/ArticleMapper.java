package com.rrdssfgcs.interviewcheatsheet.dao;


import com.rrdssfgcs.interviewcheatsheet.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 文章数据操作类
 *
 * @author parker
 * @time 2017-10-04 13:57
 **/
public interface ArticleMapper {

    /**
     * 根据文章id从数据库中取得文章类
     *
     * @param id
     * @return 文章类
     */
    @Select("SELECT * FROM article WHERE id = #{id}")
    @Results({
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "insertTime", column = "insert_time"),
    })
    Article selectArticleByDocid(int id);

    /**
     * 向数据库中插入文章
     *
     * @param article
     */
    @Insert("insert into article (docid,title,content,author,source,url,update_time,insert_time) values (#{docid},#{title},#{content},#{author},#{source},#{url},#{updateTime},#{insertTime})")
    void insertArticle(Article article);
}
