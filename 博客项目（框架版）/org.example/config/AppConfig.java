package org.example.config;

import org.example.config.web.RedirectLoginInterceptor;
import org.example.config.web.RequestResponseBodyMethodProcessorWrapper;
import org.example.config.web.UnauthorizedInterceptor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer, InitializingBean {

    @Resource
    private RequestMappingHandlerAdapter adapter;

    //之前以@ControllerAdvice+实现ResponseBodyAdvice接口，完成统一处理返回数据包装：无法解决返回值为null需要包装
    //改用现在这种方式，可以解决返回null包装为自定义类型
    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        for(int i=0; i<handlers.size(); i++){
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if(handler instanceof RequestResponseBodyMethodProcessor){
                handlers.set(i, new RequestResponseBodyMethodProcessorWrapper(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //添加路径前缀
        configurer.addPathPrefix("api",c->true);
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //后端敏感接口拦截器（后端接口排除 登录、注册、注销，其他接口都是敏感接口）
        registry.addInterceptor(new UnauthorizedInterceptor())
                .addPathPatterns("/api/**")//添加敏感接口
                .excludePathPatterns("/api/article/query")
                .excludePathPatterns("/api/user/login")//排除登录接口
                .excludePathPatterns("/api/user/register")//排除注册接口
                .excludePathPatterns("/api/user/logout");//排除注销接口


        //前端敏感资源拦截器
        registry.addInterceptor(new RedirectLoginInterceptor())
                //添加敏感页面
                .addPathPatterns("/views/article.html")
                .addPathPatterns("/views/my_articles.html");
    }
}
