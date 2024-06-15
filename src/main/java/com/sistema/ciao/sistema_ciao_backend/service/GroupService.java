package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.Group;
import com.sistema.ciao.sistema_ciao_backend.repository.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
}
