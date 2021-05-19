package org.example.controller;

import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//用户的所有操作
@Controller
@RequestMapping("/user")//服务路径
public class UserController {

    //method：提供的方法（只支持Post方法）
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login() {
        //1、请求转发：
        //return "/index.html";
        //2、重定向：
        return "redirect:/index.html";
    }

    @RequestMapping("/xxx")
    @ResponseBody//将返回的字符串作为响应体
    public String xxx() {
        return "/login";
    }

    @RequestMapping("/t1")
    @ResponseBody
    public Object t1() {
        Map<String,String> map = new HashMap<>();
        map.put("猪八戒","高老庄");
        map.put("孙悟空","花果山");
        return map;
    }

    @RequestMapping("/t2/{id}")
    @ResponseBody
    public Object t2(@PathVariable Integer id) {
        Map<String,String> map = new HashMap<>();
        map.put("猪八戒","高老庄"+id);
        map.put("孙悟空","花果山");
        return map;
    }

    @RequestMapping("/login2")
    @ResponseBody
    public Object login2(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam(required = false) Integer i,
                         @RequestParam(required = false)MultipartFile f) {
        //required表示可选项（可写可不写）
        Map<String,String> map = new HashMap<>();
        map.put("1",username);
        map.put("2",password);
        return map;
    }

    @RequestMapping("/login3")
    @ResponseBody
    public Object login3(User user) {
        return user;
    }

    //模拟登录过程：
    @RequestMapping("/login4")
    @ResponseBody
    //请求数据格式
    public Object login4(@RequestBody User user, HttpServletRequest seq) {
        Map<String,Object> map = new HashMap<>();
        if ("abc".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            HttpSession session = seq.getSession();
            session.setAttribute("user",user);
            map.put("OK",true);
            map.put("msg","登录成功");
        } else {
            map.put("Fail",false);
            map.put("msg","用户名或密码错误");
        }
        return map;
    }
}
