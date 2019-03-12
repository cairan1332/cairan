package com.caiRanSystem.service.impl;


import com.caiRanSystem.dao.LoginDao;
import com.caiRanSystem.entity.sys.LoginLog;
import com.caiRanSystem.entity.sys.User;
import com.caiRanSystem.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginDao loginDao;


    @Override
    public User login(String userName, String password) {
        return loginDao.login(userName, password);
    }

    @Override
    public void addLoginLog(LoginLog loginLog) {
         loginDao.addLoginLog(loginLog);
    }

    @Override
    public void logoutLog(LoginLog loginLog) {
         loginDao.logoutLog(loginLog);
    }
}
