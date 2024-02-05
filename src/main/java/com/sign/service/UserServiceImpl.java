package com.sign.service;

import com.sign.entity.User;
import com.sign.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDetailRepo userDetailRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUser() {
//        List<User> store = new ArrayList<>();
//        store.add(new User(UUID.randomUUID().toString(),"Gaurav Raj","garj0733@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Soorj","sooraj123@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Raj","raj0733@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Aditya","aditya@gmail.com"));
//        return store;
        return userDetailRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDetailRepo.save(user);
    }
}
