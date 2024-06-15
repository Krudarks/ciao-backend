package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.ModuleRole;
import com.sistema.ciao.sistema_ciao_backend.repository.ModuleRoleRepository;


@Service
public class ModuleRoleService {

    @Autowired
    private ModuleRoleRepository moduleRoleRepository;

    public List<ModuleRole> findAll(){
        return moduleRoleRepository.findAll();
    }
}
