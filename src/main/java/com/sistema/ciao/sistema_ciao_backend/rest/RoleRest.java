package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Role;
import com.sistema.ciao.sistema_ciao_backend.service.RoleService;

@RestController
@RequestMapping("/roles/")
public class RoleRest {
    @Autowired
    private RoleService roleService;
    
    @GetMapping
    private ResponseEntity<List<Role>> getAllRoles (){
        return ResponseEntity.ok(roleService.findAll());
    }
}
