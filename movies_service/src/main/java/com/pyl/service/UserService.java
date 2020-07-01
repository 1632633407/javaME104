package com.pyl.service;

import com.pyl.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
public interface UserService {
    /**
     * @Description 查询所有用户信息
     * @Param []
     * @return java.util.List<com.pyl.pojo.User>
     **/
    List<User> findAll();


    User login(User user);

    void upPassword(User user);

    void register(User user);

    void updateUserStatus(User user);

    void deleteUserByUName(String uName);
}
