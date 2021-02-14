package com.qian.springbootlibrary.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qian.springbootlibrary.mapper.UserBookMapper;
import com.qian.springbootlibrary.mapper.UserMapper;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserBook;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.service.UserService;
import com.qian.springbootlibrary.vo.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserBookMapper userBookMapper;

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
        map.put("user",user);
        return map;
    }

    @Override
    public List<ViewUser> getAllViewUser() {
        return userMapper.getAllViewUser();
    }

    @Override
    public int updateUserInfo(Map map) {
        return userMapper.updateUserInfo(map);
    }

    @Override
    public List<User> getUserByPageAndSize(int page, int size) {
        //定义分页变量
        Page<User> tempPage = new Page<>(page,size);
        return userMapper.selectPage(tempPage, null).getRecords();
    }

    @Override
    public int selectCount() {
         return userMapper.selectCount(null);
    }

    @Override
    public List<ViewUser> getAllViewUserByPageAndSize(int page, int size) {
        return userMapper.getAllViewUserByPageAndSize(page,size);
    }

    @Override
    public int selectAllVieUserCount() {
        return userMapper.getAllViewUser().size();
    }

    @Override
    public int borrowBooks(String bookName, String username) {
        return userBookMapper.insert(new UserBook(null,username,bookName));
    }
}
