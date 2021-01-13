package com.example.lishui.dao;

import com.example.lishui.dao.entity.OutstandingCase;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/29 下午8:10
 */
@Api(tags = "优秀案例接口")
public interface OutstandingCaseRepository extends JpaRepository<OutstandingCase,Long> {
}
