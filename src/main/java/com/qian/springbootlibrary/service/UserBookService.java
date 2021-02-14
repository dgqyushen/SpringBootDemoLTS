package com.qian.springbootlibrary.service;

import java.util.ArrayList;

public interface UserBookService {
    ArrayList<String> getAllBorrowBookByUserName(String username);

    int deleteByBookNameAndUserName(String bookname,String username);
}
