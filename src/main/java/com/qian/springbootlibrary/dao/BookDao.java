package com.qian.springbootlibrary.dao;

import com.qian.springbootlibrary.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {
    @Override
    List<Book> findAll();
}
