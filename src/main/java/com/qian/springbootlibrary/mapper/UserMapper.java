package com.qian.springbootlibrary.mapper;

import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.vo.ViewUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper  {
    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getUserByUserName(String username);

    int addUserInfo(UserInfo userInfo);

    int setUserPersonalId(Map map);

    List<ViewUser> getAllViewUser();

//    ViewUser getAllInformation();
}
