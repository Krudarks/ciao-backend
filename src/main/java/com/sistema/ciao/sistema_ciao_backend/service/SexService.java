package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Sex;
import com.sistema.ciao.sistema_ciao_backend.repository.SexRepository;

@Service
public class SexService {

        @Autowired
    private SexRepository sexRepository;

    public List<Sex> findAll() {
        return sexRepository.findAll();
    }

}

