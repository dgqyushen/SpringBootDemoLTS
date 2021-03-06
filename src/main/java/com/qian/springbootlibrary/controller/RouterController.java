package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/system")
@Controller
public class RouterController {

    @Autowired
    UserService userServiceImpl;
    @Autowired
    User user;

//    @ResponseBody
    @RequestMapping("/tomain")
    public String main(){
        return "system/main";
    }

    //登录


//    @RequestMapping("/login")
//    public String dashBoard(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession httpSession){
//        System.out.println("进来了");
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
//        Subject subject = SecurityUtils.getSubject();
//        User user = userServiceImpl.getUserByUserName(username);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
//
//        try {
//            subject.login(token);
//            if (user!=null){
//                httpSession.setAttribute("user",user);
//                httpSession.setAttribute("username",user.getUsername());
//            }
//            httpSession.setAttribute("osName",System.getProperty("os.name"));
//            httpSession.setAttribute("osVersion",System.getProperty("os.version"));
//            return "system/main";
//        }catch (UnknownAccountException e){
//            httpSession.setAttribute("msg","无此用户");
//            return "login";
//        }catch (IncorrectCredentialsException e){
//            httpSession.setAttribute("msg","密码输入错误");
//            return "login";
//        }

//    }
//    //登出
//    @RequestMapping("/logout")
//    public String logOut(HttpSession session){
//        session.removeAttribute("user");
//        session.setAttribute("logout","登出成功");
//        session.setAttribute("msg",null);
//        return "login";
//    }

    @RequestMapping("/tousertables")
    public String toUserTables(){
        return "system/usertables";
    }

    @RequestMapping("/touserinfo")
    public String toSetPersonInformation(Model model){
        model.addAttribute("userinfo",new UserInfo());
        return "system/userinfo";
    }

    @RequestMapping("/toregister")
    public String toRegister(Model model){
        model.addAttribute("userinfo",new RegisterUser());
        return "register";
    }

    @RequestMapping("/tomangeusertables")
    public String toManageUserTables(){
        return "system/manageusertables";
    }

    //管理员修改其他人的信息
    @RequestMapping("/toedituserinfo")
    public String toEditUserInfo(int id, HttpSession httpSession){
        System.out.println(id);
        httpSession.setAttribute("id",id);
        return "system/member-edit";
    }

    @RequestMapping("/tobooktables")
    public String toBookTables(){
        return "system/booktables";
    }

    @RequestMapping("/toaddbook")
    public String toAddBook(){
        return "system/addbook";
    }

    @RequestMapping("/todeletebook")
    public String toDelBook(){
        return "system/deletebook";
    }

    @RequestMapping("/toborrowbook")
    public String toBorrowBook(){
        return "system/borrow_book";
    }


}
