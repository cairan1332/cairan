package com.caiRanSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds=36000)//开启spring session支持
@EnableAsync // 开启异步任务支持
@MapperScan({"com.caiRanSystem.dao"})//扫描dao
@ServletComponentScan//扫描Servlet
@SpringBootApplication
public class CairanSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CairanSystemApplication.class, args);
    }

}
