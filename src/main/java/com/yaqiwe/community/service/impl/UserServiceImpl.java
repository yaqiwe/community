package com.yaqiwe.community.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaqiwe.community.Repostitory.userRepository;
import com.yaqiwe.community.dto.AccessTokenDto;
import com.yaqiwe.community.dto.GitHubUserDto;
import com.yaqiwe.community.entity.user;
import com.yaqiwe.community.enums.exceptionEnum;
import com.yaqiwe.community.exception.comException;
import com.yaqiwe.community.service.userService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 18:22
 * @description：Github第三方登录
 */
@Slf4j
@Service
public class UserServiceImpl implements userService {
    @Autowired
    userRepository userR;

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
            throw new comException(exceptionEnum.GET_ACCESS_TOKEN_ERROR);
        }
    }

    @Override
    public String getGithubUser(String token) {
        String url="https://api.github.com/user?access_token="+token;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String resString = response.body().string();
            GitHubUserDto gitHubUserDto = JSON.parseObject(resString, GitHubUserDto.class);
            //存储到数据库
            String logToken = UUID.randomUUID().toString();
            if(gitHubUserDto!=null){
                user us=userR.findByAccountId(gitHubUserDto.getId());
                if(us==null){
                    us=new user();
                    us.setName(gitHubUserDto.getLogin());
                    us.setAccountId(gitHubUserDto.getId());
                    us.setBio(gitHubUserDto.getBio());
                }
                us.setToken(logToken);
                userR.save(us);
            }
            return logToken;
        } catch (IOException e) {
            throw  new comException(exceptionEnum.GET_USER_ERROR);
        }
    }

    @Override
    public user getUserByToken(Cookie[] cookies) {
        user us=null;
        for (Cookie co : cookies) {
            if (co.getName().equals("token")){
                us=userR.findByToken(co.getValue());
                break;
            }
        }
        return us;
    }


}
