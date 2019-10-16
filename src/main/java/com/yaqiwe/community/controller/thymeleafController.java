package com.yaqiwe.community.controller;

import com.yaqiwe.community.dto.AccessTokenDto;
import com.yaqiwe.community.entity.user;
import com.yaqiwe.community.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/14 16:36
 * @description：访问链接时跳转到对应的html
 */
@Controller
@Slf4j
public class thymeleafController {
    @Autowired
    private userService users;

    @Autowired
    private AccessTokenDto accessTokenDto;
    /*访问主页时跳转到index.html
    * 并设置登录GitHub时的属性
    * */
    @GetMapping(value ={"/","/index",""})
    public String index(Map<String,String> map,
                        HttpServletRequest request){
        map.put("logInUrl","https://github.com/login/oauth/authorize");
        map.put("client_id",accessTokenDto.getClient_id());
        map.put("redirect_uri",accessTokenDto.getRedirect_uri());
        map.put("state",accessTokenDto.getState());
        user us = users.getUserByToken(request.getCookies());
        request.getSession().setAttribute("user",us);
        return "index";
    }

    /**
     *github登录
     * @param code 第一次登录时GitHub放回的code
     * @return
     */
    @GetMapping(value = "/callBack")
    public String callBack(@RequestParam(value = "code") String code,
                           @RequestParam(value = "state") String state,
                           HttpServletResponse response){
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        String access_token = users.getAccessToken(accessTokenDto);
        String logInToken = users.getGithubUser(access_token);
//        response.addCookie(new Cookie("token",logInToken));
//        log.info("callBack githubUser:{}",githubUser);
        response.addCookie(new Cookie("token",logInToken));
        return "redirect:/index";
    }
}
