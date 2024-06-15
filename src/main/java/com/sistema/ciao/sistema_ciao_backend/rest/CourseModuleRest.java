package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.CourseModule;
import com.sistema.ciao.sistema_ciao_backend.service.CourseModuleService;

@RestController
@RequestMapping("/coursemodule/")
public class CourseModuleRest {
    @Autowired
    private CourseModuleService courseModuleService;

    @GetMapping
    private ResponseEntity<List<CourseModule>>getAllCourseModule(){
        return ResponseEntity.ok(courseModuleService.findAll());
    }
}
