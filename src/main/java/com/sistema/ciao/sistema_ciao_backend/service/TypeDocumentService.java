package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<TypeDocument> findById(Integer id) {
        return typeDocumentRepository.findById(id);
    }

    public TypeDocument save(TypeDocument typeDocument) {
        return typeDocumentRepository.save(typeDocument);
    }

    public boolean existsById(Integer id) {
        return typeDocumentRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        typeDocumentRepository.deleteById(id);
    }
}