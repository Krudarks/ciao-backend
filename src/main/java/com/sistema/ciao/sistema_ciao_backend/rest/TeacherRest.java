package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Teacher;
import com.sistema.ciao.sistema_ciao_backend.exception.TeacherAlreadyExistsException;
import com.sistema.ciao.sistema_ciao_backend.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherRest {
    @Autowired
    private TeacherService teacherService;
    
    @GetMapping
    private ResponseEntity<List<Teacher>> getAllTeachers (){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createTeacher(@Valid @RequestBody Teacher teacher) {
        try {
            Teacher savedTeacher = teacherService.saveTeacher(teacher);
            return ResponseEntity.status(HttpStatus.CREATED).body("Teacher creado: " + savedTeacher.getId());
        } catch (TeacherAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el Teacher");
        }
    }
}