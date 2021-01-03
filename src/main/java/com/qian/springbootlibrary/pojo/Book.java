package com.qian.springbootlibrary.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Book {
    private int id;
    private String bookName;
    private String bookPrice;
    private String publishDate;
    private String publisher;
    private String ISBN;

}
