package com.qian.springbootlibrary.service.impl;

import com.qian.springbootlibrary.dao.BookDao;
import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Override
    public List<Book> getAllBook() {
        return bookDao.findAll();
    }

    @Override
    public void delBookById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public void addBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public List<Book> getBookPageByCondition(Specification<Book> specification, Pageable pageable) {
        return bookDao.findAll(specification,pageable).getContent();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.save(book);
    }
}
