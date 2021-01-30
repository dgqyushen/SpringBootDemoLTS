package com.qian.springbootlibrary.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewUser {
    private int id;
    private String username;
    private String password;
    private boolean root;
    private String city;
    private String email;
    private String sex;
}
