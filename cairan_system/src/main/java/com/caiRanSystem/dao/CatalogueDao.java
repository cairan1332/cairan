package com.caiRanSystem.dao;

import com.caiRanSystem.entity.sys.Catalogue;
import com.caiRanSystem.entity.sys.User;

import java.util.List;

public interface CatalogueDao {

    List<Catalogue> getCatalogueList(User user);
}
