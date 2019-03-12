package com.feign.clients.fallback;

import com.feign.clients.SchedualServiceUser;
import org.springframework.stereotype.Component;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/7
 * 类说明：
 * 版本号： 1.0
 */
@Component
public class SchedualServiceUserHystric implements SchedualServiceUser {

    @Override
    public String login() {
        return "                                                     ";
    }
}
