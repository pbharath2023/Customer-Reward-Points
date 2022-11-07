package com.bharath.retail.crp.serviceimpl;

import com.bharath.retail.crp.entity.User;
import com.bharath.retail.crp.service.UserService;
import com.bharath.retail.crp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User updateUser(User user, Integer userId) {
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}