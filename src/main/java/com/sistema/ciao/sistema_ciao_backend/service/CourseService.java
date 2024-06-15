package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Course;
import com.sistema.ciao.sistema_ciao_backend.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }
}
 