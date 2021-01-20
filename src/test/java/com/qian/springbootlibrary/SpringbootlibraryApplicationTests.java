package com.qian.springbootlibrary;

import com.qian.springbootlibrary.mapper.UserMapper;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class SpringbootlibraryApplicationTests {

    @Autowired
    UserService userServiceImpl;


    @Test
    void contextLoads() {
        Map map = new ConcurrentHashMap<String,Integer>();
        map.put("personal_id",1);
        map.put("id",3);
        int i = userServiceImpl.setUserPersonalId(map);
        System.out.println(i);


    }

}
