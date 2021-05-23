package org.example.controller;

import org.example.model.Article;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//所有请求方法都是设置到响应体
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/query")
    public Object query(HttpServletRequest req) {
        Map<String,Object> data = new HashMap<>();
        //需要返回用户信息（如果登录），及所有文章列表
        HttpSession session = req.getSession(false);
        if (session != null) {
            //session中拿到登录时保存的 user 对象，设置到响应数据中
            data.put("user",session.getAttribute("user"));
        }
        //设置文章列表数据：模拟数据
        List<Article> articles = articleService.query();
        data.put("article",articles);
        return data;
    }
}
