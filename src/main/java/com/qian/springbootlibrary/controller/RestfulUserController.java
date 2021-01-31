package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.service.BookService;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class RestfulUserController {

    @Autowired
    UserService userServiceImpl;

    @Autowired
    BookService bookServiceImpl;

    @RequestMapping("/getallusers")
    public Map<String,Object> getAllUser(){
        Map map = new ConcurrentHashMap<String,Object>();
        List<User> allUser = userServiceImpl.getAllUser();


        map.put("code",0);
        map.put("msg","");
        map.put("count",allUser.size());
        map.put("data",allUser);
        return map;
    }

    @RequestMapping("/getallviewusers")
    public Map<String,Object> getAllViewUsers(){
        Map map = new ConcurrentHashMap<String,Object>();
        List<ViewUser> allViewUser = userServiceImpl.getAllViewUser();
        map.put("code",0);
        map.put("msg","");
        map.put("count",allViewUser.size());
        map.put("data",allViewUser);
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

    @RequestMapping("/getallbooks")
    public Map<String,Object> getAllBook(){
        Map map = new ConcurrentHashMap<String,Object>();
        List<Book> allBook = bookServiceImpl.getAllBook();
//        List<User> allUser = userServiceImpl.getAllUser();
//
//
        map.put("code",0);
        map.put("msg","");
        map.put("count",allBook.size());
        map.put("data",allBook);

        return map;
    }


}
