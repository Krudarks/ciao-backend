package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.CourseModuleTheme;
import com.sistema.ciao.sistema_ciao_backend.repository.CourseModuleThemeRepository;

@Service
public class CourseModuleThemeService {

    @Autowired
    private CourseModuleThemeRepository courseModuleThemeRepository;

    public List<CourseModuleTheme> findAll(){
        return courseModuleThemeRepository.findAll();
    }
}
