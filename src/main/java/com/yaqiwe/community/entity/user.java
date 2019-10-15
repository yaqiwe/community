package com.yaqiwe.community.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "account_id不能为空")
    private String accountId;   //github返回的account_id

    private String token;   //登录的状态标识

    private Timestamp createTime;   //创建时间——数据库创建不用传值

    private Timestamp updateTime; //更新时间——数据库更新不用传值
}
