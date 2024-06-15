package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.StudentQualify;
import com.sistema.ciao.sistema_ciao_backend.repository.StudentQualifyRepository;

@Service
public class StudentQualifyService {
    @Autowired
    private StudentQualifyRepository studentQualifyRepository;

    public List<StudentQualify> findAll() {
        return studentQualifyRepository.findAll();
    }

}

