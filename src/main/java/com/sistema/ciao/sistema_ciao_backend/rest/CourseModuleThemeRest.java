package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Course;
import com.sistema.ciao.sistema_ciao_backend.entities.CourseModuleTheme;

@RestController
@RequestMapping("/coursemoduletheme/")
public class CourseModuleThemeRest {

    public class CourseRest {

        @Autowired
        private CourseModuleTheme courseModuleTheme;

        @GetMapping
        private ResponseEntity<List<Course>> getAllCourseModuleTheme() {
            return ResponseEntity.ok(courseModuleTheme.findAll());
        }
    }

}
