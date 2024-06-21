package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.TypeDocument;
import com.sistema.ciao.sistema_ciao_backend.service.TypeDocumentService;

@RestController
@RequestMapping("/typedocuments")
public class TypeDocumentRest {
    

    @Autowired
    private TypeDocumentService typeDocumentService;
    
    @GetMapping
    private ResponseEntity<List<TypeDocument>> getAllTypeDocuments() {
        return ResponseEntity.ok(typeDocumentService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<TypeDocument> getTypeDocumentById(@PathVariable Integer id) {
        Optional<TypeDocument> typeDocument = typeDocumentService.findById(id);
        if (typeDocument.isPresent()) {
            return ResponseEntity.ok(typeDocument.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<TypeDocument> createTypeDocument(@RequestBody TypeDocument typeDocument) {
        TypeDocument savedTypeDocument = typeDocumentService.save(typeDocument);
        return ResponseEntity.ok(savedTypeDocument);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTypeDocument(@PathVariable Integer id) {
        if (typeDocumentService.existsById(id)) {
            typeDocumentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}