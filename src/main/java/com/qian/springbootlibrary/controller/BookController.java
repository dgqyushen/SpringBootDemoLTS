package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
//    @Autowired
//    BookDao bookDao;
    @Autowired
    BookService bookServiceImpl;



    @RequestMapping("/savebook")
    public String addBook(@ModelAttribute(value = "book")Book book){
//        System.out.println(book);
        bookServiceImpl.addBook(book);
        return "/system/booktables";
    }


}
