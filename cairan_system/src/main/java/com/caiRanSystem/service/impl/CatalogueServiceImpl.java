package com.caiRanSystem.service.impl;

import com.caiRanSystem.dao.CatalogueDao;
import com.caiRanSystem.entity.sys.Catalogue;
import com.caiRanSystem.entity.sys.User;
import com.caiRanSystem.service.CatalogueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService {
    @Resource
    CatalogueDao catalogueDao;

    @Override
    public List<Catalogue> getCatalogueList(User user) {
        return catalogueDao.getCatalogueList(user);
    }
}
