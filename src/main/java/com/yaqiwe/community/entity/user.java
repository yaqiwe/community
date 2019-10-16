package com.yaqiwe.community.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/15 19:07
 * @description：用户表
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String name;    //用户名
    @NotNull(message = "account_id不能为空")
    private Integer accountId;   //github返回的id

    private String token;   //登录的状态标识

    private String bio; //用户描述

    private Timestamp createTime;   //创建时间——数据库创建不用传值

    private Timestamp updateTime; //更新时间——数据库更新不用传值
}
