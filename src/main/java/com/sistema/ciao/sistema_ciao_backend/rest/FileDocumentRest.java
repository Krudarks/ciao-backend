package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.FileDocument;
import com.sistema.ciao.sistema_ciao_backend.service.FileDocumentService;

@RestController
@RequestMapping("/filedocuments/")
public class FileDocumentRest {
    @Autowired
    private FileDocumentService fileDocumentService;
    
    @GetMapping
    private ResponseEntity<List<FileDocument>> getAllFileDocuments (){
        return ResponseEntity.ok(fileDocumentService.findAll());
    }
}