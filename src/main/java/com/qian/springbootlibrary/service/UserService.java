package com.qian.springbootlibrary.service;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getUserByUserName(String username);

    int addUserInfo(UserInfo userInfo);

    int setUserPersonalId(Map map);

    Map<String, Object> isUserLogin(String username, String password);
}
