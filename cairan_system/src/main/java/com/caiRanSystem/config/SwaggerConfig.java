package com.caiRanSystem.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/2/13
 * 类说明： Swagger配置
 * 版本号： 1.0
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.caiRanSystem"})
@Log4j2
public class SwaggerConfig {

    @Bean
    public Docket pcDocket() {
        log.info("初始化Swagger配置");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户服务")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.userService.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
