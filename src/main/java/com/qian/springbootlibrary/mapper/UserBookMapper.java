package com.qian.springbootlibrary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qian.springbootlibrary.pojo.UserBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;

@Mapper
@Repository
public interface UserBookMapper extends BaseMapper<UserBook> {
    ArrayList<String> getAllBookNameByUserName(String username);

    int deleteByBookNameAndUserName(String bookname,String username);
}
