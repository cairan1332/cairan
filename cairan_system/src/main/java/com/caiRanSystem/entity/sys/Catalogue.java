package com.caiRanSystem.entity.sys;

import lombok.Data;

import java.util.List;

/**
 * 目录
 */
@Data
public class Catalogue {

    private int catalogueId;//目录ID

    private String catalogueName;//目录名称

    private String icon;//图标

    private String path;//访问地址

    private boolean page;//目录类型

    private String target;//打开位置

    private String ruleCode;//规则编号

    private List<Catalogue> childrenCatalogueList = null;//子目录


}
