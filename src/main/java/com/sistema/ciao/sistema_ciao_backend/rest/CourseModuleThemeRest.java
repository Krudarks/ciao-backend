package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.CourseModuleTheme;
import com.sistema.ciao.sistema_ciao_backend.service.CourseModuleThemeService;

@RestController
@RequestMapping("/coursemoduletheme/")
public class CourseModuleThemeRest {
        @Autowired
        private CourseModuleThemeService courseModuleThemeService;

        @GetMapping
        private ResponseEntity<List<CourseModuleTheme>> getAllCourseModuleTheme() {
            return ResponseEntity.ok(courseModuleThemeService.findAll());
        }
    }

