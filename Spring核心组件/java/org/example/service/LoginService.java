package org.example.service;

import lombok.Getter;
import org.example.dao.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class LoginService {

    private LoginRepository loginRepository;
    //采用 构造方法 注入：
    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
}
