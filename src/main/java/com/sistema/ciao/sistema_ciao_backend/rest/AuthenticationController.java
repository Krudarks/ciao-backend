package com.sistema.ciao.sistema_ciao_backend.rest;

import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.rest.dto.AuthLoginRequest;
import com.sistema.ciao.sistema_ciao_backend.rest.dto.AuthResponse;
import com.sistema.ciao.sistema_ciao_backend.service.UserDetailsServiceImpl;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody  @Valid AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailsServiceImpl.loginUser(userRequest), HttpStatus.OK);
    }
}
