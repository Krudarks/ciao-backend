package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.ciao.sistema_ciao_backend.entities.CourseModule;
import com.sistema.ciao.sistema_ciao_backend.repository.CourseModuleRepository;

@Service
public class CourseModuleService {

    @Autowired
    private CourseModuleRepository courseModuleRepository;

    public List<CourseModule> findAll() {
        return courseModuleRepository.findAll();
    }

    public CourseModule save(CourseModule courseModule) {
        return courseModuleRepository.save(courseModule);
    }
}