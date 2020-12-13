package com.example.lishui.service.impl;

import com.example.lishui.dao.AnnouncementRuleRepository;
import com.example.lishui.dao.entity.AnnouncementRule;
import com.example.lishui.service.AnnouncementRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/13 下午6:23
 */
@Service
public class AnnouncementRuleServiceImpl implements AnnouncementRuleService {
    @Autowired
    AnnouncementRuleRepository announcementRuleRepository;

    @Override
    public AnnouncementRule updateAnnouncementRule(AnnouncementRule announcementRule) {
        announcementRule.setId(1L);
        return announcementRuleRepository.save(announcementRule);
    }

    @Override
    public AnnouncementRule getAnnouncementRule() {
        Optional<AnnouncementRule> optional = announcementRuleRepository.findById(1L);
        if (optional.isEmpty()) {
            return announcementRuleRepository.save(new AnnouncementRule(1L, 1));
        }else {
            return optional.get();
        }
    }
}
