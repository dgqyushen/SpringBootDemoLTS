package com.qian.springbootlibrary;

import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootLibraryApplicationTests {
    @Autowired
    BookService bookServiceImpl;
    @Test
    void contextLoads() {
        List<Book> allBook = bookServiceImpl.getAllBook();
        for (Book book : allBook) {
            System.out.println(book);
        }


    }

}
