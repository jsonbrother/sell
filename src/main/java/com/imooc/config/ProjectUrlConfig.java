package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by TongHaiJun
 * 2019/8/15 21:52
 */
@Data
@ConfigurationProperties(prefix = "project-url")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权url
     */
    private String wxChatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    private String wxChatOpenAuthorize;

    /**
     * 点餐系统
     */
    private String sell;
}
