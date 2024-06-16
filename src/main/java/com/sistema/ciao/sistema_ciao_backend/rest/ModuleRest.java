package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Module;
import com.sistema.ciao.sistema_ciao_backend.service.ModuleService;

@RestController
@RequestMapping("/module/")
public class ModuleRest {
    @Autowired
    private ModuleService moduleService;
    
    @GetMapping
    private ResponseEntity<List<Module>> getAllModules (){
        return ResponseEntity.ok(moduleService.findAll());
    }
}
