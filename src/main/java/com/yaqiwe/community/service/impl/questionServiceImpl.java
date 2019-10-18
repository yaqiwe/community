package com.yaqiwe.community.service.impl;

import com.yaqiwe.community.Repostitory.questionRepository;
import com.yaqiwe.community.Repostitory.userRepository;
import com.yaqiwe.community.dto.QuestionDto;
import com.yaqiwe.community.entity.question;
import com.yaqiwe.community.entity.user;
import com.yaqiwe.community.enums.exceptionEnum;
import com.yaqiwe.community.exception.comException;
import com.yaqiwe.community.service.questionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 10:14
 * @description：
 */
@Service
public class questionServiceImpl implements questionService {
    @Autowired
    questionRepository questionR;

    @Autowired
    userRepository userR;


    @Override
    public question createQuestion(String title, String problemDescribe, String Tag,Integer creator) {
        question que = new question();
        que.setTitle(title);
        que.setProblemDescribe(problemDescribe);
        que.setTags(Tag);
        que.setCreator(creator);
        return questionR.save(que);
    }

    @Override
    public List<QuestionDto> questionList() {
        List<QuestionDto> dtoList=new ArrayList<>();
        List<question> queAll = questionR.findAll();
        for (question que : queAll) {
            QuestionDto dto = new QuestionDto();
            BeanUtils.copyProperties(que,dto);
            Optional<user> us = userR.findById(que.getCreator());
            dto.setName(us.get().getName());
            dto.setAvatarUrl(us.get().getAvatarUrl());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
