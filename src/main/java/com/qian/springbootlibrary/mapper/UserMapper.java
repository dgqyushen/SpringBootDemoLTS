package com.qian.springbootlibrary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.pojo.UserInfo;
import com.qian.springbootlibrary.vo.ViewUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getUserByUserName(String username);

    int addUserInfo(UserInfo userInfo);

    int setUserPersonalId(Map map);

    List<ViewUser> getAllViewUser();

    int updateUserInfo(Map map);

    List<ViewUser> getAllViewUserByPageAndSize(int page,int size);

    int updateBookListByUsername(String bookList,String username);

//    int selectAllVieUserCount();

//    List<ViewUser> getUserByPage(Map map);

//    ViewUser getAllInformation();
}
