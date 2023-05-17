package com.curso.spring.boot.web.service;


import com.curso.spring.boot.web.model.UserModel;
import com.curso.spring.boot.web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public void cadastraruser(UserModel user) {
        userRepo.save(user);
    }

    public List<UserModel> listarUsers(){
        return (List<UserModel>) userRepo.findAll();
    }

    public UserModel listarporcodigo(Long id) {
        return userRepo.findById(id).get();
    }
}
