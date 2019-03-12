package com.caiRanSystem.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/12
 * 类说明： 阿里巴巴Druid连接池配置
 * 版本号： 1.0
 */
@Configuration
@Primary
@Log4j2
public class DruidDataSourceConfig extends DataSourceProperties {
    @Primary //默认数据源 在同样的DataSource中，首先使用被标注的DataSource 
    @Bean(name = "dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource Construction() {
        DruidDataSource datasource = new DruidDataSource();
        // filter
        List<Filter> filters = new ArrayList<>();
        filters.add(wallFilter());
        datasource.setProxyFilters(filters);
        log.info("据库连接池配置完成,版本号：{}",datasource.getVersion());
        return datasource;
    }

    @Bean
    @DependsOn("wallConfig")
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }


    @Bean
    public WallConfig wallConfig() {
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);//允许一次执行多条语句
        wallConfig.setNoneBaseStatementAllow(true);//允许一次执行多条语句
        return wallConfig;
    }
}
