package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.User;
import org.springframework.stereotype.Component;

@Mapper//启动时会扫描该注解的接口，动态生成代理类
@Component//代理类注册到容器中
public interface UserMapper {

    User selectById(Integer id);
}
