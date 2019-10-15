package com.yaqiwe.community.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaqiwe.community.dto.AccessTokenDto;
import com.yaqiwe.community.dto.GitHubUserDto;
import com.yaqiwe.community.service.userService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 18:22
 * @description：Github第三方登录
 */
@Slf4j
@Service
public class UserServiceImpl implements userService {
    @Override
    public String getAccessToken(AccessTokenDto token) {
        MediaType mediaType= MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(token));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //string="access_token=053f62588d40cc458f3152bfa2ca8cb44e1883a9&scope=&token_type=bearer";
            //剪切Github返回的字符串获取access_token的值
            return string.split("&")[0].split("=")[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GitHubUserDto getGithubUser(String token) {
        String url="https://api.github.com/user?access_token="+token;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String resString = response.body().string();
//            log.info("getGithubUser_resString:{}",resString);
            return JSON.parseObject(resString,GitHubUserDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
