package com.example.lishui.dao;

import com.example.lishui.dao.entity.Honor;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/14 下午12:59
 */
@Api(tags = "荣誉展示接口")
public interface HonorRepository extends JpaRepository<Honor,Long> {
}
