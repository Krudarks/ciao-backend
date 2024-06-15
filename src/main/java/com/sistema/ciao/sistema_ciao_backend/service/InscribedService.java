package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Inscribed;
import com.sistema.ciao.sistema_ciao_backend.repository.InscribedRepository;

@Service
public class InscribedService {

    @Autowired
    private InscribedRepository inscribedRepository;

    public List<Inscribed> findAll(){
        return inscribedRepository.findAll();
    }
}
