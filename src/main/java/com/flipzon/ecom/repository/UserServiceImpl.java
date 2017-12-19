package com.flipzon.ecom.repository;

import com.flipzon.ecom.dao.UserDAO;
import com.flipzon.ecom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean addUser(User user) {
        encryptPassword(user);
        return  userDAO.addUser(user);
    }

    private void encryptPassword(User user) {
        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
    }
}
