package com.qian.springbootlibrary.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private int id;
    private String city;
    private String email;
    private boolean sex;
//    private User user;

//    public UserInfo(String city, String email, boolean sex) {
//        this.city = city;
//        this.email = email;
//        this.sex = sex;
//    }
}
