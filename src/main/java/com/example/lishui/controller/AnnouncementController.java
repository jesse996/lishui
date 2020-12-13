package com.example.lishui.controller;

import com.example.lishui.dao.AnnouncementRepository;
import com.example.lishui.dao.entity.Announcement;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/12 下午5:44
 */
//@RestController
@Api(tags = "Announcement Entity")
public class AnnouncementController {
    @Autowired
    private AnnouncementRepository announcementRepository;

//    @RequestMapping(value = "api/announcements",method = RequestMethod.POST)
//    public Announcement insert(@RequestBody Announcement announcement){
//        System.out.print(announcement);
//        Optional<Integer> currentMaxSort=announcementRepository.findMaxSort();
////        System.out.println("max sort :"+currentMaxSort);
//        announcement.setSort(currentMaxSort.orElse(0)+1);
//        announcementRepository.save(announcement);
//        return announcement;
//    }

}
