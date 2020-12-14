package com.example.lishui.dao;

import com.example.lishui.dao.entity.AnnouncementRule;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午4:01
 */
//@Api(tags = {"公告规则接口"})
@RepositoryRestResource(exported = false)
@ApiIgnore
public interface AnnouncementRuleRepository extends JpaRepository<AnnouncementRule,Long> {
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    List<AnnouncementRule> findAll();
//
//
////    隐藏swagger中get集合接口
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    Page<AnnouncementRule> findAll(Pageable pageable);
//
////    隐藏swagger中post,put,patch接口
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    <S extends AnnouncementRule> S save(S entity);
//
////    隐藏swagger中delete接口
//    @Override
//    @RestResource(exported = false)
//    @ApiIgnore
//    void delete(AnnouncementRule entity);
//
//    @Override
//    @RestResource(exported = false)
//    void deleteById(Long id);
//
////    隐藏swagger中get单个接口
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    Optional<AnnouncementRule> findById(Long aLong);
}
