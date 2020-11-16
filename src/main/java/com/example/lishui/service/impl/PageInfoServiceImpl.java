package com.example.lishui.service.impl;

import com.example.lishui.dao.PageInfoRepository;
import com.example.lishui.dao.entity.PageInfo;
import com.example.lishui.service.PageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/15 下午8:45
 */
@Service
public class PageInfoServiceImpl implements PageInfoService {
    @Autowired
    PageInfoRepository pageInfoRepository;

    @Override
    public PageInfo addPageInfo(PageInfo pageInfo) {
        return pageInfoRepository.save(pageInfo);
    }

    @Override
    public void deletePageInfo(Long id) {
        pageInfoRepository.deleteById(id);
    }

    @Override
    public PageInfo updatePageInfo(PageInfo pageInfo) {
        return pageInfoRepository.save(pageInfo);
    }

    @Override
    public List<PageInfo> listAll() {
        return pageInfoRepository.findAll();
    }

    @Override
    public Optional<PageInfo> findById(Long id) {
        return pageInfoRepository.findById(id);
    }
}
