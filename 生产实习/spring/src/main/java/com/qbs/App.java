package com.qbs;

import com.qbs.bean.StudentGX21;
import com.qbs.service.StudentServiceGX21;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //获取IOC容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        StudentServiceGX21 studentService = (StudentServiceGX21)applicationContext.getBean("studentService");
        studentService.allStudents();
    }
}
