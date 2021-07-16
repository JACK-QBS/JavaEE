package com.liu.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArticleTag {
    private Integer articleId;
    private Integer tagId;
    //新增属性，标签名称
    private String tagName;


}
