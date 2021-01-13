package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformResult;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/29 下午8:09
 */
@Api(tags = "改革成果接口")
public interface ReformResultRepository extends JpaRepository<ReformResult,Long> {
}
