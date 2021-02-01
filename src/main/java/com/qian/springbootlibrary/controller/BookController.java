package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.dao.BookDao;
import com.qian.springbootlibrary.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookDao bookDao;
    @RequestMapping("/tobooktables")
    public String toBookTables(){
        return "booktables";
    }

    @RequestMapping("/toaddbook")
    public String toAddBook(){
        return "addbook";
    }


    @RequestMapping("/savebook")
    public String addBook(@ModelAttribute(value = "book")Book book){
//        System.out.println(book);
        bookDao.save(book);
        return "booktables";
    }
}
