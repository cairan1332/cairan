package com.caiRanSystem.service;

import com.caiRanSystem.entity.sys.Catalogue;
import com.caiRanSystem.entity.sys.User;

import java.util.List;

public interface CatalogueService {

    List<Catalogue> getCatalogueList(User user);

}
