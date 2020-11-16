package com.example.lishui.service;

import com.example.lishui.dao.entity.PageInfo;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/15 下午8:45
 */
public interface PageInfoService {
    PageInfo addPageInfo(PageInfo pageInfo);

    void deletePageInfo(Long id);

    PageInfo updatePageInfo(PageInfo pageInfo);

    List<PageInfo> listAll();

    Optional<PageInfo> findById(Long id);
}
