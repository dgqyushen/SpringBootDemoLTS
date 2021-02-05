package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {

    @Autowired
    UserService userServiceImpl;
    @Autowired
    User user;

    @RequestMapping("/setuserinfo")
    public String setUserInfo(@ModelAttribute(value = "userinfo") UserInfo userInfo,HttpSession httpSession){
        //为了获取用户的id
        Map map = new ConcurrentHashMap<String,Integer>();
        User user = (User) httpSession.getAttribute("user");
        if (user.getPersonal_id()>0){
            map.put("id",user.getId());
            map.put("city",userInfo.getCity());
            map.put("email",userInfo.getEmail());
            map.put("sex",userInfo.getSex());
            System.out.println(userInfo);
            userServiceImpl.updateUserInfo(map);
            httpSession.setAttribute("msg","修改用户信息成功");
            return "/system/main";
        }
        userInfo.setId(user.getId());
        map.put("personal_id",user.getId());
        map.put("id",user.getId());
//        System.out.println(userInfo);
        userServiceImpl.addUserInfo(userInfo);
        userServiceImpl.setUserPersonalId(map);
        httpSession.setAttribute("msg","添加用户信息成功");
        return "/system/main";
    }


    @RequestMapping("/register")
    public String getRegister(@ModelAttribute(value = "userinfo") RegisterUser registerUser,HttpSession httpSession){
//        System.out.println(registerUser);
        if (!registerUser.getPassword().equals(registerUser.getRePassword())){
            httpSession.setAttribute("msg","两次密码不一致");
            return "login";
        }
        user.setUsername(registerUser.getUsername());
        user.setPassword(registerUser.getPassword());
        user.setRoot(false);
//        System.out.println(user);
        userServiceImpl.addUser(user);
        httpSession.setAttribute("create","创建用户成功");
        httpSession.setAttribute("msg",null);
        return "login";
    }

    @RequestMapping("/resetuserinfo")
    public String resetUserInfo(@ModelAttribute(value = "userinfo") UserInfo userInfo, HttpSession httpSession){
        HashMap<String, Object> map = new HashMap<>();
        Integer id = (Integer) httpSession.getAttribute("id");
        map.put("id",id);
        map.put("city",userInfo.getCity());
        map.put("email",userInfo.getEmail());
        map.put("sex",userInfo.getSex());
        userServiceImpl.updateUserInfo(map);
        httpSession.setAttribute("msg","修改用户信息成功");
        return "/system/manageusertables";
    }
















}
