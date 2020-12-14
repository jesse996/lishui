package com.example.lishui.dao;

import com.example.lishui.dao.entity.Org;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/10 下午3:41
 */
@Api(tags = "机构简介接口")
@RepositoryRestResource(exported = false)
@ApiIgnore
public interface OrgRepository extends JpaRepository<Org,Long> {

//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    Page<Org> findAll(Pageable pageable);
//
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    <S extends Org> S save(S entity);
//
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    void delete(Org entity);
//
//    @Override
//    @RestResource(exported = false)
//    void deleteById(Long aLong);
//
//    @Override
//    @ApiIgnore
//    @RestResource(exported = false)
//    Optional<Org> findById(Long aLong);
}
