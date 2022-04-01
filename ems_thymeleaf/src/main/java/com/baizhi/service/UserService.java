package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * @author:
 * @creat 2021-06-09-11:26
 * @description:
 */
public interface UserService {
    void register(User user);

    User login(String username, String password);
}
