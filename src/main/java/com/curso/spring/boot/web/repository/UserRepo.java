package com.curso.spring.boot.web.repository;

import com.curso.spring.boot.web.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);
    Optional<UserModel> findById(Long id);
}
