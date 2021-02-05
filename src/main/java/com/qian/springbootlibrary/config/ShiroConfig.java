//package com.qian.springbootlibrary.config;
//
//import com.qian.springbootlibrary.realm.UserRealm;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
////        map.put("","");
////        map.put("/test","authc");
//        map.put("/system/*","authc");
//        bean.setSecurityManager(defaultWebSecurityManager);
//        bean.setFilterChainDefinitionMap(map);
//        bean.setLoginUrl("/");
////        bean.setFilterChainDefinitionMap(map);
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
//}
