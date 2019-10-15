package com.yaqiwe.community.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 21:07
 * @description：请求GitHub的Dto
 */
@Data
@ConfigurationProperties(prefix = "github")
public class AccessTokenDto {
    private String client_id;
    private String redirect_uri;
    private String client_secret;
    private String state;
    private String code;
}
