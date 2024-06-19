package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.ciao.sistema_ciao_backend.entities.Course;
import com.sistema.ciao.sistema_ciao_backend.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseRest {

    @Autowired
    private CourseService courseService;

    @GetMapping
    private ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @PostMapping
    private ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.save(course);
        return ResponseEntity.ok(savedCourse);
    }
}