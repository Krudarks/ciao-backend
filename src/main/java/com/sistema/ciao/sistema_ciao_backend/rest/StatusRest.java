package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Status;
import com.sistema.ciao.sistema_ciao_backend.service.StatusService;

@RestController
@RequestMapping("/statuses/")
public class StatusRest {
    @Autowired
    private StatusService statusService;
    
    @GetMapping
    private ResponseEntity<List<Status>> getAllStatuses (){
        return ResponseEntity.ok(statusService.findAll());
    }
}