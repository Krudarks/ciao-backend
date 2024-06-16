package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.TypeDocument;
import com.sistema.ciao.sistema_ciao_backend.service.TypeDocumentService;

@RestController
@RequestMapping("/typedocuments/")
public class TypeDocumentRest {
    @Autowired
    private TypeDocumentService typeDocumentService;
    
    @GetMapping
    private ResponseEntity<List<TypeDocument>> getAllTypeDocuments (){
        return ResponseEntity.ok(typeDocumentService.findAll());
    }
}