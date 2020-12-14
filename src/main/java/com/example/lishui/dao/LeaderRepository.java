package com.example.lishui.dao;

import com.example.lishui.dao.entity.Leader;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/10 下午4:15
 */
@Api(tags = "领导关怀接口")
public interface LeaderRepository extends JpaRepository<Leader,Long> {
}
