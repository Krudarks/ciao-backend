package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.ciao.sistema_ciao_backend.entities.ModuleRole;
import com.sistema.ciao.sistema_ciao_backend.service.ModuleRoleService;

public class ModuleRoleRest {
    @Autowired
    private ModuleRoleService moduleRoleService;
    
    @GetMapping
    private ResponseEntity<List<ModuleRole>> getAllModuleRoles (){
        return ResponseEntity.ok(moduleRoleService.findAll());
    }
}