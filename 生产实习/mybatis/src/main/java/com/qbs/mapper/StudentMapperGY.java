package com.qbs.mapper;

import com.qbs.bean.Student;

/**
 * mapper.java 接口文件
 * 给定的就是操作数据库的方法
 */
public interface StudentMapperGY {
    //给定 id 查询用户信息
    public Student selectStudentById(Integer id);
    //插入数据：
    public int insertStudent(Student student);
    //删除数据：
    public int delStudentById(Integer id);
    //修改数据：
    public int updateNameById(Student studentGY);
}
