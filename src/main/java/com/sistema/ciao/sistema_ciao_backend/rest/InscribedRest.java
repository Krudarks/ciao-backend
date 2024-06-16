package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Inscribed;
import com.sistema.ciao.sistema_ciao_backend.service.InscribedService;

@RestController
@RequestMapping("/inscribeds/")
public class InscribedRest {
    @Autowired
    private InscribedService inscribedService;

    @GetMapping
    private ResponseEntity<List<Inscribed>>getAllInscribeds(){
        return ResponseEntity.ok(inscribedService.findAll());
    }
} 

