package com.caiRanSystem.entity.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统用户
 */
@Data
public class User implements Serializable {

    private int userId;

    private String userName;

    private String nickName;

    private String mobile;

    private String email;

    private String qq;

    private String token;
}
