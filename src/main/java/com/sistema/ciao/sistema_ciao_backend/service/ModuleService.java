package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.repository.ModuleRepository;
import com.sistema.ciao.sistema_ciao_backend.entities.Module;

@Service
public class ModuleService {
    
    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> findAll(){
        return moduleRepository.findAll();
    }
}
