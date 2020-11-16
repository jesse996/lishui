package com.example.lishui.dao;

import com.example.lishui.dao.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jesse on 2020/11/16 下午5:11
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
