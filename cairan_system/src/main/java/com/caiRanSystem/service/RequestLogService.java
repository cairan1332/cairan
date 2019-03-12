package com.caiRanSystem.service;

import com.caiRanSystem.entity.sys.RequestLog;
import org.springframework.scheduling.annotation.Async;

public interface RequestLogService {

    @Async
    void addRequestRecord(RequestLog record);
}
