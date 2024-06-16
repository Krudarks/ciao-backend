package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Sex;
import com.sistema.ciao.sistema_ciao_backend.service.SexService;

@RestController
@RequestMapping("/sexs/")
public class SexRest {
    @Autowired
    private SexService sexService;
    
    @GetMapping
    private ResponseEntity<List<Sex>> getAllSexs (){
        return ResponseEntity.ok(sexService.findAll());
    }
}
