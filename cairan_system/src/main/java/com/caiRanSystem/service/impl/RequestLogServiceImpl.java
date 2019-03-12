package com.caiRanSystem.service.impl;

import com.caiRanSystem.dao.RequestLogDao;
import com.caiRanSystem.entity.sys.RequestLog;
import com.caiRanSystem.service.RequestLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RequestLogServiceImpl implements RequestLogService {
    @Resource
    RequestLogDao recordDao;

    @Override
    public void addRequestRecord(RequestLog record) {
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.exit(0);//退出程序
        }
        recordDao.addRequestRecord(record);
    }
}
