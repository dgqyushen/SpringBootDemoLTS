package com.qian.springbootlibrary.service;

import com.qian.springbootlibrary.mapper.UserMapper;
import com.qian.springbootlibrary.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int id){
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }
}
