//package com.qian.springbootlibrary.config;
//
//import com.qian.springbootlibrary.realm.UserRealm;
//
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.mgt.RememberMeManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
//@Configuration
//public class ShiroConfig {
//
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
//        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        HashMap<String, String> map = new LinkedHashMap<>();
//        //拦截非登录请求
////        map.put("/system/*","authc");
////        map.put("/static/**","anon");
//        bean.setSecurityManager(defaultWebSecurityManager);
//        bean.setFilterChainDefinitionMap(map);
//        bean.setLoginUrl("/");
//        return bean;
//    }
//
//    @Bean
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        defaultWebSecurityManager.setRealm(userRealm);
//        return defaultWebSecurityManager;
//    }
//
//    @Bean
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
//
//    @Bean
//    public RememberMeManager rememberMeManager(){
//        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        simpleCookie.setHttpOnly(true);
//        simpleCookie.setMaxAge(604800);
//        rememberMeManager.setCookie(simpleCookie);
//        return rememberMeManager;
//    }
//
//    @Bean
//    public CookieRememberMeManager cookieRememberMeManager() {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        simpleCookie.setMaxAge(259200000);
//        cookieRememberMeManager.setCookie(simpleCookie);
//        cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
//        return cookieRememberMeManager;
//    }
//}
