package com.example.lishui.dao;

import com.example.lishui.dao.entity.AnnouncementRule;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午4:01
 */
@Api(tags = {"公告规则接口"})
//@RepositoryRestResource()
public interface AnnouncementRuleRepository extends JpaRepository<AnnouncementRule,Long> {
    @Override
    @RestResource(exported = false)
    List<AnnouncementRule> findAll();

    @Override
    @RestResource(exported = false)
    <S extends AnnouncementRule> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends AnnouncementRule> Optional<S> findOne(Example<S> example);

    @Override
    //swagger显示的是用这个方法标记的
//    @Operation(hidden = true,summary = "根据id删除1")
    @RestResource(exported = false)
    //用ApiIgnore才能在swagger中隐藏
    @ApiIgnore
    void delete(AnnouncementRule entity);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);





}
