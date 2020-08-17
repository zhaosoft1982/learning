package com.zhaosoft.wrap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("wrap.service")
public class WrapProperties {
    private String before;
    private String after;
}
