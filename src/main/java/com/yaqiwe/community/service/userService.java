package com.yaqiwe.community.service;

import com.yaqiwe.community.dto.AccessTokenDto;
import com.yaqiwe.community.dto.GitHubUserDto;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 18:20
 * @description：用户登录的操作
 */
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
    GitHubUserDto getGithubUser(String token);
}
