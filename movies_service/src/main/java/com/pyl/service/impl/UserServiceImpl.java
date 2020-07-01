package com.pyl.service.impl;

import com.pyl.dao.UserDao;
import com.pyl.pojo.User;
import com.pyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        return userList;
    }

    @Override
    public User login(User user) {

        return userDao.login(user);
    }


    @Override
    public void upPassword(User user) {
        userDao.upPassword(user);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public void updateUserStatus(User user) {
        if ("1".equals(user.getuStauts())){
            user.setuStauts("2");
        }else {
            user.setuStauts("1");
        }
        userDao.updateUserStatus(user);
    }

    @Override
    public void deleteUserByUName(String uName) {
        userDao.deleteUserByUName(uName);
    }
}
