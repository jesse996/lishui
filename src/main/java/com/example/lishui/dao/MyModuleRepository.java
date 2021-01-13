package com.example.lishui.dao;

import com.example.lishui.dao.entity.MyModule;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by jesse on 2020/12/11 下午7:58
 */
@Api(tags = "大屏模块接口")
@RepositoryRestResource
public interface MyModuleRepository extends JpaRepository<MyModule,Long> {
}
