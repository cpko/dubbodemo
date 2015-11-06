package com.cpk.showcase.user.service;

import com.cpk.showcase.user.dao.UserDao;
import com.cpk.showcase.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:cp
 * Created on 11/3/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id);
    }
}
