package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class RestfulBookController {

    @Autowired
    BookService bookServiceImpl;
    @Autowired
    HttpSession httpSession;

    @RequestMapping("/getallbooks")
    public Map<String,Object> getAllBook(){
        Map map = new ConcurrentHashMap<String,Object>();
        List<Book> allBook = bookServiceImpl.getAllBook();
        map.put("code",0);
        map.put("msg","");
        map.put("count",allBook.size());
        map.put("data",allBook);

        return map;
    }

    @RequestMapping("/delbookbyid")
    public void delBookById(int id){
        System.out.println(id);
        bookServiceImpl.delBookById(id);
        httpSession.setAttribute("msg","删除书本成功");
    }
}
