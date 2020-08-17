package com.zhaosoft.wrap.config;

import com.zhaosoft.wrap.service.WrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaosoft
 */
@Configuration
@ConditionalOnClass(WrapService.class)
@EnableConfigurationProperties(WrapProperties.class)
public class WrapServiceAutoConfiguration {
    @Autowired
    private WrapProperties wrapProperties;

    @Bean
    @ConditionalOnProperty(name = "wrap.service.enable", havingValue = "true", matchIfMissing = true)
    public WrapService wrapService() {
        return new WrapService(wrapProperties.getBefore(), wrapProperties.getAfter());
    }

    @Bean
    @ConditionalOnMissingBean
    public WrapService wrapServiceNo() {
        return new WrapService("", "");
    }

}
