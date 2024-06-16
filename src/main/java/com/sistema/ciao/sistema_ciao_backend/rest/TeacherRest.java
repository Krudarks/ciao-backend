package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Teacher;
import com.sistema.ciao.sistema_ciao_backend.service.TeacherService;

@RestController
@RequestMapping("/teachers/")
public class TeacherRest {
    @Autowired
    private TeacherService teacherService;
    
    @GetMapping
    private ResponseEntity<List<Teacher>> getAllTeachers (){
        return ResponseEntity.ok(teacherService.findAll());
    }
}