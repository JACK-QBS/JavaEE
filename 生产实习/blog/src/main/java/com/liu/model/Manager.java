package com.liu.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Manager {
    private Integer id;
    private String username;
    private String password;
}
