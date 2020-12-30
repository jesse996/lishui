package com.example.lishui.dao;

import com.example.lishui.dao.entity.OutstandingCaseArticle;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

@Api(tags = "优秀案例文章接口")
public interface OutstandingCaseArticleRepository extends JpaRepository<OutstandingCaseArticle,Long> {
}
