package com.qian.springbootlibrary.dao;

import com.qian.springbootlibrary.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
    @Override
    List<Book> findAll();

    Book getBookById(Integer id);
}
