package com.qian.springbootlibrary.service;

import com.qian.springbootlibrary.mapper.UserMapper;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userMapper.addUserInfo(userInfo);
    }

    @Override
    public int setUserPersonalId(Map map) {
        return userMapper.setUserPersonalId(map);
    }

    @Override
    public Map<String, Object> isUserLogin(String username,String password) {
        User user = userMapper.getUserByUserName(username);
        Map map = new ConcurrentHashMap<String,Object>();
        //如果无此用户
        if (user == null){
            map.put("isUserExist",false);
            return map;
        }else {
            //用户存在
            map.put("isUserExist",true);
        }
        if (user.getPassword().equals(password)){
            map.put("isPasswordCorrect",true);
        }else {
            //密码错误
            map.put("isPasswordCorrect",false);
        }
        map.put("username",user.getUsername());
        return map;



    }
}
