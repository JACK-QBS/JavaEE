package org.example.config.web;

import org.example.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 返回 401 状态码
 */
public class UnauthorizedInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取 session，如果获取不到，返回null
        HttpSession session = request.getSession(false);
        if (session != null) {
            //获取存放的用户信息
            User user = (User) session.getAttribute("user");
            if (user != null) {
                return true;
            }
        }
        //设置响应状态码：
        //后端敏感资源，没有登录时，直接返回401状态码
        response.setStatus(401);
        return false;
    }
}
