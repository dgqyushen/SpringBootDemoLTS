package com.qian.springbootlibrary;

import com.qian.springbootlibrary.mapper.BookMapper;
import com.qian.springbootlibrary.mapper.UserMapper;
import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class SpringbootlibraryApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User dgqyushen = userMapper.getUserByUserName("dgqyushen");
        System.out.println(dgqyushen);



    }

}
