package com.bharath.retail.crp.service;

import com.bharath.retail.crp.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user, Integer userId);
    User getUserById(Integer userId);
    List<User> getAllUsers();
}
