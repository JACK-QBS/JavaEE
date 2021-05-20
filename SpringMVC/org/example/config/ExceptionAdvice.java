package org.example.config;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.example.example.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
//增强类
public class ExceptionAdvice {
    //处理自定义异常：
    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Object handle(AppException e) {
        log.debug("自定义异常",e);//打印堆栈信息（日志框架）
        Map<String,Object> map = new HashMap<>();
        map.put("ok",false);
        map.put("code",e.getCode());
        map.put("msg",e.getMessage());
        return map;
    }

    //处理非自定义异常：
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle2(Exception e) {
        log.debug("非自定义异常",e);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",false);
        map.put("code","ERR000");
        map.put("msg","未知错误");
        return map;
    }

}
