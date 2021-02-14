package com.qian.springbootlibrary.service.impl;

import com.qian.springbootlibrary.mapper.UserBookMapper;
import com.qian.springbootlibrary.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserBookServiceImpl implements UserBookService {

    @Autowired
    UserBookMapper userBookMapper;
    @Override
    public ArrayList<String> getAllBorrowBookByUserName(String username) {
        return userBookMapper.getAllBookNameByUserName(username);
    }

    @Override
    public int deleteByBookNameAndUserName(String bookname, String username) {
        return userBookMapper.deleteByBookNameAndUserName(bookname,username);
    }
}
