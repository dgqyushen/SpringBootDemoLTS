package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userServiceImpl;

//    @RequestMapping("/")
//    public String login(){
//        return "login";
//    }


    @RequestMapping("/login")
    public String dashBoard(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession httpSession){
        User user = userServiceImpl.getUserByUserName(username);
//        User user = new UserServiceImpl().getUserByUserName(username);
        if(user == null){
            httpSession.setAttribute("msg","无此用户");
            return "login";

        }
        if (user.getPassword().equals(password)){
           httpSession.setAttribute("user",user);
//           已在浏览器的session中放置了User对象
//            System.out.println((User)httpSession.getAttribute("user"));
            return "main";
        }else {
            httpSession.setAttribute("msg","密码输入错误");
            System.out.println("已存入model");
        }


        return "login";
    }

    @RequestMapping("/404")
    public String error(){
        return "404";
    }








}


//当时测试是否输入错误会存入session
//        User user1 = (User) httpSession.getAttribute("user");
//        if (user1 == null){
//            System.out.println("null");
//        }