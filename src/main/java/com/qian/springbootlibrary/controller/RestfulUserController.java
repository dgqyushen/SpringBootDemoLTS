package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
public class RestfulUserController {

    @Autowired
    UserService userServiceImpl;



    @RequestMapping("/getallusers")
    public Map<String,Object> getAllUser(@RequestParam(required = false,defaultValue = "1")int page, @RequestParam(required = false)int limit){
        Map map = new ConcurrentHashMap<String,Object>();
//        List<User> allUser = userServiceImpl.getAllUser();
        List<User> allUser = userServiceImpl.getUserByPageAndSize(page, limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",userServiceImpl.selectCount());
        map.put("data",allUser);
        return map;
    }


    @RequestMapping("/getallviewusers")
    public Map<String,Object> getAllViewUsers(@RequestParam(required = false,defaultValue = "1")int page, @RequestParam(required = false)int limit){
        Map map = new ConcurrentHashMap<String,Object>();
        //        System.out.println("page="+page+"size="+limit);


        page=(page-1)*limit;
//        System.out.println("================================");
//        System.out.println("page="+page+"size="+limit);
//        List<ViewUser> allViewUser = userServiceImpl.getAllViewUser();
        List<ViewUser> allViewUserByPageAndSize = userServiceImpl.getAllViewUserByPageAndSize(page, limit);
//        List<ViewUser> allViewUserByPageAndSize = userServiceImpl.getAllViewUserByPageAndSize(page - 1, limit);
//        userServiceImpl.getAllViewUserByPageAndSize()

        map.put("code",0);
        map.put("msg"," ");
        map.put("count",userServiceImpl.selectAllVieUserCount());
        map.put("data",allViewUserByPageAndSize);
        return map;
    }


    @RequestMapping("/deleteuser")
    public Map<String,Object> deleteUser(int id){
        System.out.println(id);
        userServiceImpl.deleteUser(id);
        HashMap<String, Object> map = new HashMap<>();
        map = map;
        map.put("msg","删除成功");
        return map;
    }






}
