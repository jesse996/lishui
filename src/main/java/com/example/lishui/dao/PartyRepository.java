package com.example.lishui.dao;

import com.example.lishui.dao.entity.Party;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by jesse on 2020/12/14 下午1:35
 */
@Api(tags = "党建引领接口")
public interface PartyRepository extends JpaRepository<Party,Long> {
    @Override
    @Query(value = "select u from #{#entityName} u order by u.weight asc")
    Page<Party> findAll(Pageable pageable);
}
