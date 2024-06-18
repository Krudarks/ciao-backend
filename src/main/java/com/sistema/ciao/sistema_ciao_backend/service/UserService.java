package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;
import com.sistema.ciao.sistema_ciao_backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    //Metodo para guardar un usuario 
    public UserEntity saveUser (UserEntity user){
        return userRepository.save(user);
    }
}

