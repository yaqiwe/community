package com.yaqiwe.community.Repostitory;

import com.yaqiwe.community.entity.question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 9:36
 * @description：测试question持久层
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class questionRepositoryTest {
    @Autowired
    questionRepository questionR;

    @Test
    @Transactional
   public void testSave(){
        question que=new question();
        que.setTitle("titleTest");
        que.setProblemDescribe("ProblemDescribeTest");
        que.setCreator(112233);
        question save = questionR.save(que);
        Assert.assertNotNull(save);
    }
}