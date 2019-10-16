package com.yaqiwe.community.util;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/15 19:23
 * @description：统一返回格式
 */
@Data
public class Resoult <T>{
    private Integer code;
    private String msg;
    private T data;
}
