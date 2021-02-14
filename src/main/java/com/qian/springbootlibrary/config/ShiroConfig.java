package com.qian.springbootlibrary.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qian.springbootlibrary.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        Map<String, String> map = new LinkedHashMap<>();
        //静态资源过滤
        map.put("/static/**","anon");
        map.put("/login","anon");
        map.put("/main.html","anon");
        //权限资源过滤
        map.put("/system/toedituserinfo","perms[user:isRoot]");
        map.put("/system/tomangeusertables","perms[user:isRoot]");
        map.put("/system/todeletebook","perms[user:isRoot]");
        map.put("/system/toaddbook","perms[user:isRoot]");
        //认证资源过滤
        map.put("/system/**","authc");
        bean.setSecurityManager(defaultWebSecurityManager);
        bean.setLoginUrl("/");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }



    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);

        return securityManager;
    }


    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
