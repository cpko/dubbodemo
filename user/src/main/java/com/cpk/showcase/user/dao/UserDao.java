package com.cpk.showcase.user.dao;

import com.cpk.showcase.user.model.User;
import org.springframework.stereotype.Repository;

/**
 * Author:cp
 * Created on 11/3/15.
 */
@Repository
public class UserDao {
    public User findById(Long id) {
        return mock();
    }

    private User mock() {
        User user = new User();
        user.setId(1L);
        user.setName("jack");
        user.setMobile("xxxxx");
        user.setPassword("123456");
        return user;
    }

}
