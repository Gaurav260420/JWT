package com.sign.service;

import com.sign.entity.User;
import com.sign.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailService implements UserDetailsService {
    @Autowired
    private UserDetailRepo userDetailRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailRepo.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found !! "));
        return user;
    }
}
