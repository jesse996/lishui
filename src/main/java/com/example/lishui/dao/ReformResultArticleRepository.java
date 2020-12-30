package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformResultArticle;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

@Api(tags = "改革成果文章接口")
public interface ReformResultArticleRepository extends JpaRepository<ReformResultArticle,Long> {
}
