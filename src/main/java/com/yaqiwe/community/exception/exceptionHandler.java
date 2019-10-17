//package com.yaqiwe.community.exception;
//
//import com.yaqiwe.community.enums.exceptionEnum;
//import com.yaqiwe.community.exception.comException;
//import com.yaqiwe.community.util.Resoult;
//import com.yaqiwe.community.util.ResoultUtil;
//import org.springframework.validation.BindException;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author ：yaqiwe
// * @date ：Created in 2019/10/15 19:22
// * @description：统一异常拦截
// */
//@ControllerAdvice
//public class exceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Resoult errorHandler(Exception e) {
//        /*自定义的错误类型*/
//        if (e instanceof comException) {
//            comException ce = (comException) e;
//            return ResoultUtil.error(ce.getCode(), ce.getMessage());
//        }
//        //其他异常，打印控制台
//        e.printStackTrace();
//        return ResoultUtil.error(exceptionEnum.UNKNOWN_ERROR);
//    }
//
//    /**
//     * 单个参数校验
//     * @param
//     * @return
//     */
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    @ResponseBody
//    public Resoult handleBindGetException(ConstraintViolationException ex){
//        List<String> defaultMsg = ex.getConstraintViolations()
//                .stream()
//                .map(ConstraintViolation::getMessage)
//                .collect(Collectors.toList());
//        return  ResoultUtil.error(exceptionEnum.PARAMETER_ERROR.getCode(),defaultMsg.toString());
//    }
//
//    /**
//     * 一般的参数绑定时候抛出的异常
//     * @param
//     * @return
//     */
//    @ExceptionHandler(value = BindException.class)
//    @ResponseBody
//    public Resoult handleBindException(BindException ex){
//        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
//                .stream()
//                .map(ObjectError::getDefaultMessage)
//                .collect(Collectors.toList());
//        return ResoultUtil.error(exceptionEnum.PARAMETER_ERROR.getCode(),defaultMsg.toString());
//    }
//}
