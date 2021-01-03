package com.qian.springbootlibrary.mapper;

import com.qian.springbootlibrary.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    List<Book> getAllBook();

    Book getBookById(int id);

    int addBook(Book book);

    int deleteBook(int id);

    int updateBook(Book book);
}
