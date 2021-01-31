package com.qian.springbootlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @RequestMapping("/tobooktables")
    public String toBookTables(){
        return "booktables";
    }
}
