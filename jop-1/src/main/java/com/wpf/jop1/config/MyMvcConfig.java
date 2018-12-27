package com.wpf.jop1.config;

import com.wpf.jop1.component.LoginHandlerinterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @outhor wpf
 * @date 2018/12/25 - 13:34
 *
 * 视图映射
 */
//说明这是一个配置类扩展springmvc,不用写空方法，直接视图映射就可以了
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
    }

    //注册拦截器，拦截那些，放行那些
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerinterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/index.html","/","/login","webjar","/druid/*");
    }
}
