package com.qian.springbootlibrary.utils;

import org.springframework.context.ConfigurableApplicationContext;

public class BeanUtil {
    public static ConfigurableApplicationContext applicationContext;

    public static <T> T getBean(Class<T> c){
        return applicationContext.getBean(c);
    }
}
