package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.TypeDocument;
import com.sistema.ciao.sistema_ciao_backend.repository.TypeDocumentRepository;

@Service
public class TypeDocumentService {
    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    public List<TypeDocument> findAll() {
        return typeDocumentRepository.findAll();
    }

}

