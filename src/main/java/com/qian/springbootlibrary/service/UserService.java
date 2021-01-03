package com.qian.springbootlibrary.service;

import com.qian.springbootlibrary.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getUserByUserName(String username);
}
