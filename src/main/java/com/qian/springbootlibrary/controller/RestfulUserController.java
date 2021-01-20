package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestfulUserController {

    @Autowired
    UserService userServiceImpl;

    @RequestMapping("/getallusers")
    public List<User> getAllUser(){
        List<User> allUser = userServiceImpl.getAllUser();
//        for (User user : allUser) {
//            System.out.println(user);
//        }
        return allUser;
    }
}
