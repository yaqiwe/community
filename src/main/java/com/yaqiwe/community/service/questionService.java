package com.yaqiwe.community.service;

import com.yaqiwe.community.entity.question;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 10:09
 * @description：问题相关操作
 */
public interface questionService {

    /**
     * 发布问题
     * @param title 问题标题
     * @param problemDescribe   问题描述
     * @param Tag 问题标签
     * @param creator 发起问题人的ID
     * @return
     */
    question createQuestion(String title,String problemDescribe,String Tag, Integer creator);
}
