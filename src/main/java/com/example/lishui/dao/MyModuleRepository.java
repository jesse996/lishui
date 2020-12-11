package com.example.lishui.dao;

import com.example.lishui.dao.entity.MyModule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jesse on 2020/12/11 下午7:58
 */
public interface MyModuleRepository extends JpaRepository<MyModule,Long> {
}
