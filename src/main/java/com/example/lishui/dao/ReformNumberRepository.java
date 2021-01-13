package com.example.lishui.dao;

import com.example.lishui.dao.entity.ReformNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by jesse on 2020/12/11 下午7:59
 */
//@Api(tags = "改革指数接口")
@RepositoryRestResource(exported = false)
@ApiIgnore
public interface ReformNumberRepository extends JpaRepository<ReformNumber, Long> {
}
