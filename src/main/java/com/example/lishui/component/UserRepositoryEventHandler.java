package com.example.lishui.component;

import com.example.lishui.dao.OptionRepository;
import com.example.lishui.dao.entity.Option;
import com.example.lishui.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by jesse on 2020/11/19 上午11:10
 */
@Component
@Slf4j
@RepositoryEventHandler
@Async
public class UserRepositoryEventHandler {
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    ApplicationContext applicationContext;

    @HandleAfterCreate
    public void handleUserAfterCreate(User user) {
        log.info("Inside User After Create....");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            log.info("name= " + currentUserName);
            //新增添加新用户的记录
            optionRepository.save(new Option(null, currentUserName, "post", "添加新管理员:" + user.getUsername(), null));
        }
    }

    @HandleAfterSave
    public void handleUserAfterSave(User user) {
        log.info("Inside User After Save....");
        System.out.println(user.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            log.info("name= " + currentUserName);
            //新增添加新用户的记录
            optionRepository.save(new Option(null, currentUserName, "put", "修改管理员:" + user.getUsername(), null));
        }
    }
    @HandleAfterDelete
    public void handleUserAfterDelete(User user) {
        log.info("Inside User After Delete....");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            //新增添加新用户的记录
            optionRepository.save(new Option(null, currentUserName, "delete", "删除管理员:" + user.getUsername(), null));
        }

    }
}
