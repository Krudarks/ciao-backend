package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Group;
import com.sistema.ciao.sistema_ciao_backend.service.GroupService;

@RestController
@RequestMapping("/groups/")
public class GroupRest {
    @Autowired
    private GroupService groupService;

    @GetMapping
    private ResponseEntity<List<Group>>getAllGroups(){
        return ResponseEntity.ok(groupService.findAll());
    }
} 