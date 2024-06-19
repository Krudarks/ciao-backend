package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.ciao.sistema_ciao_backend.entities.CourseModuleTheme;
import com.sistema.ciao.sistema_ciao_backend.service.CourseModuleThemeService;

@RestController
@RequestMapping("/course-module-themes")
public class CourseModuleThemeRest {

    @Autowired
    private CourseModuleThemeService courseModuleThemeService;

    @GetMapping
    private ResponseEntity<List<CourseModuleTheme>> getAllCourseModuleThemes() {
        return ResponseEntity.ok(courseModuleThemeService.findAll());
    }

    @PostMapping
    private ResponseEntity<CourseModuleTheme> createCourseModuleTheme(@RequestBody CourseModuleTheme courseModuleTheme) {
        CourseModuleTheme savedCourseModuleTheme = courseModuleThemeService.save(courseModuleTheme);
        return ResponseEntity.ok(savedCourseModuleTheme);
    }
}