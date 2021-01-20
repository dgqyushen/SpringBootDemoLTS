package com.qian.springbootlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/tomain")
    public String main(){
        return "main";
    }





}
