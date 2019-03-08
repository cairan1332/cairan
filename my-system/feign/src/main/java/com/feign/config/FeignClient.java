//package com.feign.config;
//
//import feign.Retryer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static java.util.concurrent.TimeUnit.SECONDS;
//
///**
// * 创建人： 蔡燃
// * 邮  箱： 792150181@qq.com
// * 日  期： 2019/3/7
// * 类说明：
// * 版本号： 1.0
// */
//@Configuration
//public class FeignClient {
//
//    @Bean
//    public Retryer feignRetryer() {
//        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
//    }
//}
