package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Status;
import com.sistema.ciao.sistema_ciao_backend.repository.StatusRepository;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

}

