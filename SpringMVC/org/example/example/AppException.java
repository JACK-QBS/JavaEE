package org.example.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//自定义异常
public class AppException extends RuntimeException{
    private String code;//错误码

    public AppException(String code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
