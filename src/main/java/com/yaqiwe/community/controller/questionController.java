package com.yaqiwe.community.controller;

import com.yaqiwe.community.entity.user;
import com.yaqiwe.community.service.questionService;
import com.yaqiwe.community.service.userService;
import com.yaqiwe.community.util.Resoult;
import com.yaqiwe.community.util.ResoultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 10:24
 * @description：问题操作相关接口
 */
@RestController
public class questionController {
    @Autowired
    questionService questionS;
    @Autowired
    userService userS;

    @PostMapping(value = "/createQuestion")
    public String createQuestion(@RequestParam(value = "title")String title,
                                  @RequestParam(value = "problemDescribe")String problemDescribe,
                                  @RequestParam(value = "Tag", required = false)String Tag,
                                  HttpServletRequest request){
        user us = userS.getUserByToken(request.getCookies());
        questionS.createQuestion(title, problemDescribe, Tag, us.getId());
        return "redirect:/index";
    }

}
