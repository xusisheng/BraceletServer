package com.aw.braceletserver.config;

import com.aw.braceletserver.interceptor.LoginInterceptor;
import com.aw.braceletserver.resolver.UserInfoMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 在web的配置文件中，实例化登陆的拦截器，并添加规则
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor loginInterceptor1() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor1())
                .addPathPatterns("/**")
                .excludePathPatterns("/iot/**", "/api/ExceptionMessage/**", "/error");
    }

    @Bean
    public UserInfoMethodArgumentResolver userInfoMethodArgumentResolver() {
        return new UserInfoMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userInfoMethodArgumentResolver());
    }
}
