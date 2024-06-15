package com.sistema.ciao.sistema_ciao_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.ciao.sistema_ciao_backend.entities.FileDocument;
import com.sistema.ciao.sistema_ciao_backend.repository.FileDocumentRepository;

@Service
public class FileDocumentService {
    
    @Autowired
    private FileDocumentRepository fileDocumentRepository;

    public List<FileDocument> findAll(){
        return fileDocumentRepository.findAll();
    }
}
