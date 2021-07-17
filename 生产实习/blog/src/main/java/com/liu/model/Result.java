package com.liu.model;

import lombok.*;

/**
 * 封装统一的结果集给前端
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Result {
    //操作结果
    private String resultCode;
    //错误信息
    private String errorInfo;
    //附属对象
    private Object object;

    public Result(String resultCode, String errorInfo) {
        this.resultCode = resultCode;
        this.errorInfo = errorInfo;
    }
}
