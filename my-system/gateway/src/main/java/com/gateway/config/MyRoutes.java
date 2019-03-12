//package com.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 创建人： 蔡燃
// * 邮  箱： 792150181@qq.com
// * 日  期： 2019/3/11
// * 类说明： 网关路由配置
// * 版本号： 1.0
// */
//@Configuration
//public class MyRoutes {
//
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(r -> r.path("/baidu")
//                        .uri("http://baidu.com:80/")
//                )
//                .route("websocket_route", r -> r.path("/apitopic1/**")
//                        .uri("ws://127.0.0.1:6605"))
//                .route(r -> r.path("/userapi3/**")
//                        .filters(f -> f.addResponseHeader("X-AnotherHeader", "testapi3"))
//
//                        .uri("lb://user-service/")
//                )
//                .build();
//    }
//}
