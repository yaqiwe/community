package com.yaqiwe.community.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/18 10:28
 * @description：
 */
@Data
public class QuestionDto {

    private Integer id;     //问题主键

    private String title;   //问题标题

    private String problemDescribe;   //问题描述

    private Integer commentCount=0;   //评论数

    private Integer viewCount=0;   //阅读数

    private Integer likeCount=0;   //点赞数

    private String tags;   //标签，以,号分隔

    private Timestamp createTime;   //创建时间

    private Timestamp updateTime;   //修改时间

    private String name;    //发起人用户名

    private String avatarUrl; //用户头像地址

}
