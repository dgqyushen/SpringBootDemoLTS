//package com.qian.springbootlibrary.controller;
//
//import com.qian.springbootlibrary.pojo.User;
//import com.qian.springbootlibrary.service.UserService;
//import com.qian.springbootlibrary.utils.BeanUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpSession;
//
//@RestController
//public class RestUserController {
//
//    @Autowired
//    UserService userServiceImpl;
//
//    @RequestMapping("/login")
//    public String login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession httpSession) {
//        User user = userServiceImpl.getUserByUserName(username);
//        if (user.getPassword().equals(password)){
//            httpSession.setAttribute("user",user);
//            return "succeed";
//        }
//
//
//
//        return "fail";
//
//    }
//
//    @RequestMapping("/hello")
//    public String error(HttpSession httpSession){
//        User user = (User) httpSession.getAttribute("user");
//        System.out.println(user);
//        return "test";
//    }
//}
