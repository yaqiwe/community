package com.yaqiwe.community.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 22:07
 * @description：gitHub放回的用户信息Dto
 */
@Data
public class GitHubUserDto {
    //用户姓名
    @JsonProperty("name")
    private String login;
    //用户ID
    private Integer id;
    //用户描述
    private String bio;
}
