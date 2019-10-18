package com.yaqiwe.community.service;

import com.yaqiwe.community.dto.AccessTokenDto;
import com.yaqiwe.community.dto.GitHubUserDto;
import com.yaqiwe.community.entity.user;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.Cookie;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 18:20
 * @description：用户登录的操作
 */
@Validated
public interface userService {
    /**
     * 模拟post，请求GitHub获取AccessToken
     * @return
     */
    String getAccessToken(AccessTokenDto token);

    /**
     * 从Github获取用户信息
     * @param token github返回的AccessToken
     * @return
     */
    String getGithubUser(@NotEmpty(message = "AccessToken不能为空") String token);

    /**
     * 根据登录token获取用户信息
     * @param cookies 请求时传递的cookie列表
     * @return
     */
    user getUserByToken(@NotNull(message = "cookies不能为空") Cookie[] cookies);
}
