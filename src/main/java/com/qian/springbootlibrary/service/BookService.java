package com.qian.springbootlibrary.service;


import com.qian.springbootlibrary.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BookService {

    public List<Book> getAllBook();

    void delBookById(int id);

    void addBook(Book book);

    public List<Book> getBookPageByCondition(Specification<Book> specification, Pageable pageable);

    public Book getBookById(int id);

    void updateBook(Book book);
}
