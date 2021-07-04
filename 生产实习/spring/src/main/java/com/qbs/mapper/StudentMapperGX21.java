package com.qbs.mapper;

import com.qbs.bean.StudentGX21;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface StudentMapperGX21 {
    public List<StudentGX21> getAllStudent();
}
