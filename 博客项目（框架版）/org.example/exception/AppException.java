package org.example.exception;

import lombok.Getter;

/**
 * 自定义异常
 */

@Getter
public class AppException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;

    public AppException(String code,String message) {
        super(message);
        this.code = code;
    }

    public AppException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
