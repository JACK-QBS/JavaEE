package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.AppException;
import org.example.model.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Slf4j//日志（后台记录异常）
public class ExceptionAdvice {
    /**
     * 处理自定义异常（返回 JSON数据）
     */
    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Object handle(AppException e) {
        log.debug("自定义异常",e);
        Response resp = new Response();
        resp.setCode(e.getCode());
        resp.setMsg(e.getMessage());
        return resp;
    }

    /**
     * 处理非自定义异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e) {
        log.error("非自定义异常",e);
        Response resp = new Response();
        resp.setCode("ERR000");
        resp.setMsg("未知错误，请联系管理员");
        return resp;
    }

}
