package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.ciao.sistema_ciao_backend.entities.Document;
import com.sistema.ciao.sistema_ciao_backend.entities.FileDocument;
import com.sistema.ciao.sistema_ciao_backend.entities.TypeDocument;
import com.sistema.ciao.sistema_ciao_backend.service.DocumentService;
import com.sistema.ciao.sistema_ciao_backend.service.FileDocumentService;
import com.sistema.ciao.sistema_ciao_backend.service.TypeDocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentRest {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private FileDocumentService fileDocumentService;

    @Autowired
    private TypeDocumentService typeDocumentService;

    @GetMapping
    private ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(documentService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Document> getDocumentById(@PathVariable Integer id) {
        Optional<Document> document = documentService.findById(id);
        if (document.isPresent()) {
            return ResponseEntity.ok(document.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Document> createDocument(@RequestParam("fileId") Integer fileId, 
                                                    @RequestParam("typeId") Integer typeId) {
        Optional<FileDocument> fileDocument = fileDocumentService.findById(fileId);
        Optional<TypeDocument> typeDocument = typeDocumentService.findById(typeId);

        if (fileDocument.isPresent() && typeDocument.isPresent()) {
            Document document = new Document();
            document.setFileDocument(fileDocument.get());
            document.setTypeDocument(typeDocument.get());

            Document savedDocument = documentService.save(document);
            return ResponseEntity.ok(savedDocument);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }
}