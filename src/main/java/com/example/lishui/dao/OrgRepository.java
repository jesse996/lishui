package com.example.lishui.dao;

import com.example.lishui.dao.entity.Org;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by jesse on 2020/12/10 下午3:41
 */
@Api(tags = "机构简介接口")
@RepositoryRestResource(exported = false)
@ApiIgnore
public interface OrgRepository extends JpaRepository<Org,Long> {
}
