package org.example.controller;

import org.example.example.AppException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex")
public class ExceptionController {

    @GetMapping("/1")
    public Object ex1() {
        int i = 0;
        int x = 1 / i;//执行到这会抛异常
        return new Object();
    }

    @GetMapping("/2")
    public Object ex2() {
        //抛自定义异常
        return new AppException("ex2","数据库出错");
    }
}
