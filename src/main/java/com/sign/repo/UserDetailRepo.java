package com.sign.repo;

import com.sign.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<User,Long> {
    public Optional<User> findByEmail(String email);
}
