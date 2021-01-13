package com.example.lishui.dao;

import com.example.lishui.dao.entity.Highlight;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午4:08
 */
@Api(tags = "闪光时刻接口")
public interface HighlightRepository extends JpaRepository<Highlight,Long> {
}
