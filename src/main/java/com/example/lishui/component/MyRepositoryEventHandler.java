package com.example.lishui.component;

import com.example.lishui.dao.AnnouncementRepository;
import com.example.lishui.dao.DepartmentRepository;
import com.example.lishui.dao.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by jesse on 2020/12/12 下午11:56
 */
@Component
@Slf4j
@Async
@RepositoryEventHandler
public class MyRepositoryEventHandler {
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MemberRepository memberRepository;

//    @HandleBeforeCreate
//    public void handleBeforeCreate(Announcement announcement){
//        log.info("新增公告");
//        log.info(announcement.toString());
//        var maxWeight = announcementRepository.findMaxWeight().orElse(0);
//        announcement.setWeight(maxWeight + 1);
//    }
//
//    @HandleBeforeCreate
//    public void handleBeforeCreate(Department department){
//        log.info("新增部门");
//        log.info(department.toString());
//        var maxWeight = announcementRepository.findMaxWeight().orElse(0);
//        department.setWeight(maxWeight + 1);
//    }
//    @HandleBeforeCreate
//    public void handleBeforeCreate(Member member){
//        log.info("新增成员");
//        log.info(member.toString());
//        var maxWeight = announcementRepository.findMaxWeight().orElse(0);
//        member.setWeight(maxWeight + 1);
//    }

//    @Autowired
//    ReformNewsRepository reformNewsRepository;
//    @Autowired
//    ReformNewsTagRepository reformNewsTagRepository;
//    //修改改革动态的tag的时候修改文章的tag
//    @HandleAfterSave
//    public void handleAfterSave(ReformNewsTag reformNewsTag) {
//        Long id = reformNewsTag.getId();
//        String oldName = reformNewsTagRepository.findById(id).get().getName();
//        String newName = reformNewsTag.getName();
//        List<ReformNews> list = reformNewsRepository.findAllByTagEquals(oldName);
//        list = list.stream().peek(x -> x.setTag(newName)).collect(Collectors.toList());
//        reformNewsRepository.saveAll(list);
//    }
}
