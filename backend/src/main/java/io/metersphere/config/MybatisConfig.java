package io.metersphere.config;

import com.github.pagehelper.PageInterceptor;
import io.metersphere.commons.utils.MybatisInterceptorConfig;
import io.metersphere.interceptor.MybatisInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "io.metersphere.base.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class MybatisConfig {

    @Bean
    @ConditionalOnMissingBean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("pageSizeZero", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean
    @ConditionalOnMissingBean
    public MybatisInterceptor dbInterceptor() {
        MybatisInterceptor interceptor = new MybatisInterceptor();
        List<MybatisInterceptorConfig> configList = new ArrayList<>();
        configList.add(new MybatisInterceptorConfig("io.metersphere.base.domain.FileContent", "file", "io.metersphere.commons.utils.CompressUtils", "zip", "unzip"));
        interceptor.setInterceptorConfigList(configList);
        return interceptor;
    }
}