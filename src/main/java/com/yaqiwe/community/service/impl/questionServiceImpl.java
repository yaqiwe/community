package com.yaqiwe.community.service.impl;

import com.yaqiwe.community.Repostitory.questionRepository;
import com.yaqiwe.community.entity.question;
import com.yaqiwe.community.enums.exceptionEnum;
import com.yaqiwe.community.exception.comException;
import com.yaqiwe.community.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 10:14
 * @description：
 */
@Service
public class questionServiceImpl implements questionService {
    @Autowired
    questionRepository questionR;


    @Override
    public question createQuestion(String title, String problemDescribe, String Tag,Integer creator) {
        question que = new question();
        que.setTitle(title);
        que.setProblemDescribe(problemDescribe);
        que.setTags(Tag);
        que.setCreator(creator);
        return questionR.save(que);
    }
}
