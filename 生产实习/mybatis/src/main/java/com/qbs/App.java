package com.qbs;

import com.qbs.bean.Student;
import com.qbs.mapper.StudentMapperGY;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        //指定mybatis的全局配置文件
        String fileName= "mybatis-config.xml";
        //通过流的形式来读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过动态代理获取一个代理对象
        StudentMapperGY studentMapperGY = sqlSession.getMapper(StudentMapperGY.class);

        //查询操作：
        Student student = studentMapperGY.selectStudentById(21);
        System.out.println(student);

        //插入操作：
        /*Student student = new Student();
        student.setSID(2);
        student.setSname("hahewew");
        student.setSage(113);
        student.setSsex("he");
        studentMapperGY.insertStudent(student);
        sqlSession.commit();*/

        //删除操作
        /*studentMapperGY.delStudentById(2);
        sqlSession.commit();
*/
        //修改数据：
        /*Student student = new Student();
        student.setSID(2);
        student.setSname("GYSX");
        studentMapperGY.updateNameById(student);
        sqlSession.commit();*/
    }
}
