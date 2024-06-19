package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.ciao.sistema_ciao_backend.entities.CourseModule;
import com.sistema.ciao.sistema_ciao_backend.service.CourseModuleService;

@RestController
@RequestMapping("/course-modules")
public class CourseModuleRest {

    @Autowired
    private CourseModuleService courseModuleService;

    @GetMapping
    private ResponseEntity<List<CourseModule>> getAllCourseModules() {
        return ResponseEntity.ok(courseModuleService.findAll());
    }

    @PostMapping
    private ResponseEntity<CourseModule> createCourseModule(@RequestBody CourseModule courseModule) {
        CourseModule savedCourseModule = courseModuleService.save(courseModule);
        return ResponseEntity.ok(savedCourseModule);
    }
}