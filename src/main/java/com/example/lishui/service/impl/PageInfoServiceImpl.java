package com.example.lishui.service.impl;

import com.example.lishui.dao.PageInfoRepository;
import com.example.lishui.dao.entity.PageInfo;
import com.example.lishui.service.PageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jesse on 2020/11/15 下午8:45
 */
@Service
public class PageInfoServiceImpl implements PageInfoService {
    @Autowired
    PageInfoRepository pageInfoRepository;

    @Override
    public boolean addPageInfo(PageInfo pageInfo) {
        pageInfoRepository.save(pageInfo);
        return true;
    }

    @Override
    public boolean deletePageInfo(Long id) {
        pageInfoRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updatePageInfo(PageInfo pageInfo) {
        pageInfoRepository.save(pageInfo);
        return true;
    }

    @Override
    public List<PageInfo> listAll() {
        return pageInfoRepository.findAll();
    }
}
