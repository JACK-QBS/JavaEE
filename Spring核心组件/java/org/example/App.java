package org.example;

import org.example.config.AppConfig;
import org.example.controller.LoginController;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//启动类：
public class App {

    public static void main(String[] args) {
        //根据Spring配置文件路径创建容器：应用上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //从容器中拿对象
        LoginController loginController = (LoginController) context.getBean("loginController");
        System.out.println(loginController);
        System.out.println(loginController.getLoginService());

        //通过 id 获取
        User user = (User) context.getBean("u1");
        System.out.println(user);
        //一个类型有多个 id 注册到容器中，通过 类型 获取，容器不知道返回哪个对象报错
        /*User user2 = context.getBean(User.class);
        System.out.println(user2);*/

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);

        User u = (User) context.getBean("byFactoryBean");
        System.out.println(u);

        LoginService loginService = context.getBean(LoginService.class);
        System.out.println(loginService.getLoginRepository());

        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}