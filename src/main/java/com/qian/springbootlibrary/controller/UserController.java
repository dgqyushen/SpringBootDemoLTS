package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {

    @Autowired
    UserService userServiceImpl;
    @Autowired
    User user;

    //登录
    @RequestMapping("/login")
    public String dashBoard(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession httpSession){
//        userServiceImpl.isUserLogin(username,)
//        User user = userServiceImpl.getUserByUserName(username);
//        if(user == null){
//            httpSession.setAttribute("msg","无此用户");
//            httpSession.setAttribute("create",null);
//            return "login";
//        }
//        if (user.getPassword().equals(password)){
//           httpSession.setAttribute("user",user);
//           httpSession.setAttribute("username",user.getUsername());
//           httpSession.setAttribute("osName",System.getProperty("os.name"));
//           httpSession.setAttribute("osVersion",System.getProperty("os.version"));
//           return "main";
//        }else {
//            httpSession.setAttribute("msg","密码输入错误");
////            System.out.println("已存入model");
//        }
//        return "login";
        Map<String, Object> map = userServiceImpl.isUserLogin(username, password);
        User user = (User) map.get("user");
        if((boolean)map.get("isUserExist")){
             if ((boolean)map.get("isPasswordCorrect")){
                 httpSession.setAttribute("user",user);
                 httpSession.setAttribute("username",user.getUsername());
                 httpSession.setAttribute("osName",System.getProperty("os.name"));
                 httpSession.setAttribute("osVersion",System.getProperty("os.version"));
                 return "main";
             }
             httpSession.setAttribute("msg","密码输入错误");
             return "login";
         }else {
            httpSession.setAttribute("msg","无此用户");
            httpSession.setAttribute("create",null);
            return "login";
        }
    }
    //登出
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        session.setAttribute("logout","登出成功");
        session.setAttribute("msg",null);
        return "login";
    }

    @RequestMapping("/tousertables")
    public String userTables(){
        return "usertables";
    }

    @RequestMapping("/touserinfo")
    public String toSetPersonInformation(Model model){
        model.addAttribute("userinfo",new UserInfo());
        return "userinfo";
    }

    @RequestMapping("/setuserinfo")
    public String setUserInfo(@ModelAttribute(value = "userinfo") UserInfo userInfo,HttpSession httpSession){
        //为了获取用户的id
        Map map = new ConcurrentHashMap<String,Integer>();
        User user = (User) httpSession.getAttribute("user");
        userInfo.setId(user.getId());
        map.put("personal_id",user.getId());
        map.put("id",user.getId());
//        System.out.println(userInfo);
        userServiceImpl.addUserInfo(userInfo);
        userServiceImpl.setUserPersonalId(map);
        httpSession.setAttribute("msg","添加用户信息成功");
        return "main";
    }

    @RequestMapping("/toregister")
    public String toRegister(Model model){
        model.addAttribute("userinfo",new RegisterUser());
        return "register";
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
















}
