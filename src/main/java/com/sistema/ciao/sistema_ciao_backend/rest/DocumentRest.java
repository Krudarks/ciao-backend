package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Document;
import com.sistema.ciao.sistema_ciao_backend.service.DocumentService;

@RestController
@RequestMapping("/documents/")
public class DocumentRest {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    private ResponseEntity<List<Document>>getAllDocuments(){
        return ResponseEntity.ok(documentService.findAll());
    }
}