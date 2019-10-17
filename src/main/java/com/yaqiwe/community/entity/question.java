package com.yaqiwe.community.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 8:56
 * @description：发布问题表
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "问题标题不能为空")
    @Length(max = 49 ,message = "标题长度不能超过49个字")
    private String title;   //问题标题

    @NotEmpty(message = "问题描述不能为空")
    private String problemDescribe;   //问题描述

    @NotNull(message = "发起人id不能为空")
    private Integer creator;   //发起人id

    private Integer commentCount=0;   //评论数

    private Integer viewCount=0;   //阅读数

    private Integer likeCount=0;   //点赞数

    private String tags;   //标签，以,号分隔

    private Timestamp createTime;   //创建时间

    private Timestamp updateTime;   //修改时间
}
