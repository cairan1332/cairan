package com.feign.clients;

import com.feign.clients.fallback.SchedualServiceUserHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/7
 * 类说明：
 * 版本号： 1.0
 */
@FeignClient(value = "service-user",  fallback = SchedualServiceUserHystric.class)
public interface SchedualServiceUser {

    @RequestMapping(value = "/login")
    String login();
}
