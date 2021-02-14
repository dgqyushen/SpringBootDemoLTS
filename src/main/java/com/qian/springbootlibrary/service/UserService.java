package com.qian.springbootlibrary.service;

import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.vo.ViewUser;

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

    List<ViewUser> getAllViewUser();

    int updateUserInfo(Map map);

    List<User> getUserByPageAndSize(int page,int size);

    int selectCount();

    List<ViewUser> getAllViewUserByPageAndSize(int page,int size);

    int selectAllVieUserCount();

    int borrowBooks(String bookName,String usernmae);
}
