package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:
 * @creat 2021-06-09-11:15
 * @description:
 */
@Mapper
public interface UserDao {
    void save(User user);

    User login(@Param("username") String username, @Param("password") String password);
}
