package com.pyl.dao;

import com.pyl.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Repository
public interface UserDao {
    List<User> findAll();

    User login(User user);

    void upPassword(User user);

    void register(User user);

    void updateUserStatus(User user);

    void deleteUserByUName(String uName);
}
