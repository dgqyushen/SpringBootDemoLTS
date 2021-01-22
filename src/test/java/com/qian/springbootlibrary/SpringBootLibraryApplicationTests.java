package com.qian.springbootlibrary;

import com.qian.springbootlibrary.mapper.UserMapper;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.ViewUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class SpringBootLibraryApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {
        List<ViewUser> allViewUser = userMapper.getAllViewUser();
        for (ViewUser viewUser : allViewUser) {
            System.out.println(viewUser);
        }


    }

}
