package com.sign.service;

import com.sign.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User createUser( User user);
}
