package com.example.lishui.service;

import com.example.lishui.dao.entity.AnnouncementRule;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/13 下午6:21
 */
public interface AnnouncementRuleService {
    AnnouncementRule updateAnnouncementRule(AnnouncementRule announcementRule);
    AnnouncementRule getAnnouncementRule();
}
