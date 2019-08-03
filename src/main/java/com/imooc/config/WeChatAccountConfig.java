package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by TongHaiJun
 * 2019/8/4 0:43
 */
@Data
@Component
@ConfigurationProperties(prefix = "weChat")
public class WeChatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;
}
