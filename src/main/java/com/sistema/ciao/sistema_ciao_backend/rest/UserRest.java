package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.UserEntity;
import com.sistema.ciao.sistema_ciao_backend.service.UserService;

@RestController
@RequestMapping("users")
public class UserRest {
    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    //Metodo para crear un usuario
    @PostMapping
    public ResponseEntity<UserEntity>createuser(@RequestBody UserEntity user) {
        UserEntity savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);     
    }
}
