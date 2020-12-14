package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformNews;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/14 下午2:05
 */
@Api(tags = "改革动态接口")
public interface ReformNewsRepository extends JpaRepository<ReformNews,Long> {
}
