package com.example.lishui.dao;

import com.example.lishui.dao.entity.Party;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/14 下午1:35
 */
@Api(tags = "党建引领接口")
public interface PartyRepository extends JpaRepository<Party,Long> {
}
