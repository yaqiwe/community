package com.yaqiwe.community.exception;

import com.yaqiwe.community.enums.exceptionEnum;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/15 19:17
 * @description：自定义的错误类型
 */
@Data
public class comException extends RuntimeException {
    private Integer code;

    public comException(exceptionEnum enums){
        super(enums.getMsg());
        code=enums.getCode();
    }

}
