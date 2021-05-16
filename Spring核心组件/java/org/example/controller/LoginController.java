package org.example.controller;

import lombok.Getter;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

//注解：把一个对象注册到容器中
@Controller//注册一个id为类名首字母小写的 bean 对象
@Getter
public class LoginController {

    //组织依赖关系：属性 + 注解（以属性的方式注入）
    @Autowired
    private LoginService loginService;

    //注册一个返回值为 User 对象到容器，id = 方法名
    @Bean
    public User u1() {
        User user = new User();
        user.setName("帅哥");
        user.setPassword("gg");
        return user;
    }
    @Bean
    public User u2() {
        User user = new User();
        user.setName("美女");
        user.setPassword("mm");
        return user;
    }
    @Bean
    public User u3(User u2) {
        System.out.println(u2);
        User user = new User();
        user.setName("美女");
        user.setPassword("mm");
        return user;
    }
}
