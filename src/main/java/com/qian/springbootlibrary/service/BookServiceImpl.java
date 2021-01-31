package com.qian.springbootlibrary.service;

import com.qian.springbootlibrary.dao.BookDao;
import com.qian.springbootlibrary.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookDao bookDao;
    @Override
    public List<Book> getAllBook() {
        return bookDao.findAll();
    }
}
