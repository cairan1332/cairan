package com.caiRanSystem.entity.sys;

import lombok.Data;

/**
 * 组
 */
@Data
public class Group {
    private int groupId;//组Id

    private String groupName;//组名称

    private String description;//组描述

    private String createUser;//创建人

    private String createTime;//创建时间


}
