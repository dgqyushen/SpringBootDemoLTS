package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

//只关注登录登出 不关注具体拦截的路径
@Controller
public class LoginController {

    @Autowired
    UserService userServiceImpl;

    //登录
    @RequestMapping("/login")
    public String dashBoard(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession httpSession){

        Subject subject = SecurityUtils.getSubject();
        User user = userServiceImpl.getUserByUserName(username);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(false);

        try {
            subject.login(token);
            if (user!=null){
                httpSession.setAttribute("user",user);
                httpSession.setAttribute("username",user.getUsername());
            }
            httpSession.setAttribute("osName",System.getProperty("os.name"));
            httpSession.setAttribute("osVersion",System.getProperty("os.version"));
            return "system/main";
        }catch (UnknownAccountException e){
            httpSession.setAttribute("msg","无此用户");
            return "login";
        }catch (IncorrectCredentialsException e){
            httpSession.setAttribute("msg","密码输入错误");
            return "login";
        }




//        Map<String, Object> map = userServiceImpl.isUserLogin(username, password);
//        User user = (User) map.get("user");
//        if((boolean)map.get("isUserExist")){
//            if ((boolean)map.get("isPasswordCorrect")){
//                httpSession.setAttribute("user",user);
//                httpSession.setAttribute("username",user.getUsername());
//                httpSession.setAttribute("osName",System.getProperty("os.name"));
//                httpSession.setAttribute("osVersion",System.getProperty("os.version"));
//
//                return "system/main";
//            }
//            httpSession.setAttribute("msg","密码输入错误");
//            return "login";
//        }else {
//            httpSession.setAttribute("msg","无此用户");
//            httpSession.setAttribute("create",null);
//            return "login";
//        }

    }

    //登出
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        session.setAttribute("logout","登出成功");
        session.setAttribute("msg",null);
        return "login";
    }
}
