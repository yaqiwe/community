package com.yaqiwe.community.service.impl;

import com.yaqiwe.community.entity.question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 15:35
 * @description：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class questionServiceImplTest {

    @Autowired
    private questionServiceImpl questionS;

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
}