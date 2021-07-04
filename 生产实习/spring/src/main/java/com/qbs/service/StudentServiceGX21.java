package com.qbs.service;

import com.qbs.bean.StudentGX21;
import com.qbs.mapper.StudentMapperGX21;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

//通过注解形式将该类交给spring管理
@Service(value = "studentService")
public class StudentServiceGX21 {
    //    注入依赖：注入mapper层依赖
    @Autowired
    private StudentMapperGX21 studentMapperGX21;

    public void allStudents() {
        List<StudentGX21> studentGX21s = studentMapperGX21.getAllStudent();
        Iterator<StudentGX21> iterator = studentGX21s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
