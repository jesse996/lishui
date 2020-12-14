package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformNumber;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/11 下午7:59
 */
@Api(tags = "改革指数接口")
public interface ReformNumberRepository extends JpaRepository<ReformNumber,Long> {
}