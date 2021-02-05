package com.qian.springbootlibrary.service;


import com.qian.springbootlibrary.pojo.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBook();

    void delBookById(int id);

    void addBook(Book book);


}
