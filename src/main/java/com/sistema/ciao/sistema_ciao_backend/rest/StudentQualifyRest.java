package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.StudentQualify;
import com.sistema.ciao.sistema_ciao_backend.service.StudentQualifyService;

@RestController
@RequestMapping("/studentqualifys/")
public class StudentQualifyRest {
    @Autowired
    private StudentQualifyService studentQualifyService;
    
    @GetMapping
    private ResponseEntity<List<StudentQualify>> getAllStudentQualifys (){
        return ResponseEntity.ok(studentQualifyService.findAll());
    }
}
