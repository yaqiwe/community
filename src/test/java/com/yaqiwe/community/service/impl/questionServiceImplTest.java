package com.yaqiwe.community.service.impl;

import com.yaqiwe.community.Repostitory.questionRepository;
import com.yaqiwe.community.dto.QuestionDto;
import com.yaqiwe.community.entity.question;
import com.yaqiwe.community.service.questionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 15:35
 * @description：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class questionServiceImplTest {

    @Autowired
    private questionService questionS;

    @Autowired
    questionRepository questionR;

    @Test
    @Transactional
    public void createQuestion() {
        //创建成功
        question que = questionS.createQuestion("titleTest", "ProblemDescribe", "", 112233);
        Assert.assertNotNull(que);
    }
//
//    @Test
//    @Transactional
//    public void createQuestion1() {
//        //标题为空
//        boolean que = questionS.createQuestion(null, "ProblemDescribe", "", 112233);
//        Assert.assertFalse(que);
//    }
//
//    @Test
//    @Transactional
//    public void createQuestion2() {
//        //问题描述为空
//        boolean que = questionS.createQuestion("titleTest", null, "", 112233);
//        Assert.assertFalse(que);
//    }
//
//    @Test
//    @Transactional
//    public void createQuestion3() {
//        //标签为空
//        boolean que = questionS.createQuestion("titleTest", "ProblemDescribe", null, 112233);
//        Assert.assertTrue(que);
//    }
//
//    @Test
//    @Transactional
//    public void createQuestion4() {
//        //发起问题的人Id为空
//        boolean que = questionS.createQuestion("titleTest", "ProblemDescribe", "", null);
//        Assert.assertFalse(que);
//    }

    @Test
    public void questionListTest(){
        List<QuestionDto> dtoList = questionS.questionList(1,null);
        Sort sort=new Sort(Sort.Direction.DESC,"createTime");
        List<question> all = questionR.findAll(sort);
        for (int i = 0; i < dtoList.size(); i++) {
            log.info("questionListTest questionDto:{}",dtoList.get(i));
            log.info("questionListTest question:{}",all.get(i));
            Assert.assertEquals(dtoList.get(i).getTitle(),all.get(i).getTitle());
        }
    }
}