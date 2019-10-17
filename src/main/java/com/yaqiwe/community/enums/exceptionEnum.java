package com.yaqiwe.community.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/15 19:18
 * @description：错误类型枚举类
 */
@Getter
public enum  exceptionEnum {
    /*500-599服务端错误*/
    UNKNOWN_ERROR(501,"未知错误"),
    CREATE_QUESTION_ERROR(502,"发布文章错误"),

    /*400-499客户端错误*/
    PARAMETER_ERROR(401,"参数校验错误"),
    GET_ACCESS_TOKEN_ERROR(405,"请求AccessToken错误"),
    GET_USER_ERROR(406,"请求Github用户信息错误"),
    ;

    private Integer code;
    private String msg;

    exceptionEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
