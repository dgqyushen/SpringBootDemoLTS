//package com.qian.springbootlibrary.config;
//
//import com.qian.springbootlibrary.intercepter.MyInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Controller
//public class MyMvcConfig implements WebMvcConfigurer {
//    @Autowired
//    private MyInterceptor myInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myInterceptor);
//        interceptorRegistration.addPathPatterns("/**");
//        interceptorRegistration.excludePathPatterns("/", "/index.html", "/user/login", "/css/**", "/js/**", "/img/**","login.html");
//
//    }
//}
