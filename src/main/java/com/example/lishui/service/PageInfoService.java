package com.example.lishui.service;

import com.example.lishui.dao.entity.PageInfo;

import java.util.List;

/**
 * Created by jesse on 2020/11/15 下午8:45
 */
public interface PageInfoService {
    boolean addPageInfo(PageInfo pageInfo);

    boolean deletePageInfo(Long id);

    boolean updatePageInfo(PageInfo pageInfo);

    List<PageInfo> listAll();
}
