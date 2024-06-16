package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Student;
import com.sistema.ciao.sistema_ciao_backend.service.StudentService;

@RestController
@RequestMapping("/students/")
public class StudentRest {
    @Autowired
    private StudentService studentService;
    
    @GetMapping
    private ResponseEntity<List<Student>> getAllStudents (){
        return ResponseEntity.ok(studentService.findAll());
    }
}