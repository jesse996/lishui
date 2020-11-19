package com.example.lishui.component;

import com.example.lishui.dao.OptionRepository;
import com.example.lishui.dao.entity.Option;
import com.example.lishui.dao.entity.PageInfo;
import com.example.lishui.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by jesse on 2020/11/19 上午11:46
 */
@Component
@Slf4j
@RepositoryEventHandler
@Async
public class PageRepositoryEventHandler {
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    ApplicationContext applicationContext;

    @HandleAfterCreate
    public void handlePageAfterCreate(PageInfo pageInfo) {
        log.info("Inside Page After Create....");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            log.info("name= " + currentUserName);
            //新增添加页面的记录
            optionRepository.save(new Option(null, currentUserName, "post", "添加页面:" + pageInfo.getName(), null));
        }
    }

    @HandleAfterSave
    public void handlePageAfterSave(PageInfo pageInfo) {
        log.info("Inside Page After Save....");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            log.info("name= " + currentUserName);
            //新增添加页面的记录
            optionRepository.save(new Option(null, currentUserName, "put", "修改页面:" + pageInfo.getName(), null));
        }
    }

    @HandleAfterDelete
    public void handlePageAfterDelete(PageInfo pageInfo) {
        log.info("Inside Page After Delete....");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            //新增添加页面的记录
            optionRepository.save(new Option(null, currentUserName, "delete", "删除页面:" + pageInfo.getName(), null));
        }

    }
}
