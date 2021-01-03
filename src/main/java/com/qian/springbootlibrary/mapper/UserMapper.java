package com.qian.springbootlibrary.mapper;

import com.qian.springbootlibrary.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getUserByUserName(String username);
}
