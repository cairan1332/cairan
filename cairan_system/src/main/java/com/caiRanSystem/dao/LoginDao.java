package com.caiRanSystem.dao;

import com.caiRanSystem.entity.sys.LoginLog;
import com.caiRanSystem.entity.sys.User;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {

    User login(@Param("userName") String userName, @Param("password") String password);

    void addLoginLog(LoginLog loginLog);


    void logoutLog(LoginLog loginLog);
}
