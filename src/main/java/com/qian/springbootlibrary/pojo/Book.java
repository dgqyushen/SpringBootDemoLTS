package com.qian.springbootlibrary.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String bookName;

    private Float bookPrice;

    private Date publishDate;

    private String publisher;

    private String ISBN;

    private Integer num;

    private String author;

}
