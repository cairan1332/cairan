package com.caiRanSystem.service;

import com.caiRanSystem.entity.sys.LoginLog;
import com.caiRanSystem.entity.sys.User;
import org.springframework.scheduling.annotation.Async;

public interface LoginService {

    User login(String userName, String password);

    @Async
    void addLoginLog(LoginLog loginLog);

    @Async
    void logoutLog(LoginLog loginLog);
}
