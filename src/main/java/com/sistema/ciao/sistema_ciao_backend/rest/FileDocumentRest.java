package com.sistema.ciao.sistema_ciao_backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sistema.ciao.sistema_ciao_backend.entities.FileDocument;
import com.sistema.ciao.sistema_ciao_backend.service.FileDocumentService;

@RestController
@RequestMapping("/filedocuments")
public class FileDocumentRest {

    @Autowired
    private FileDocumentService fileDocumentService;
    
    @GetMapping
    private ResponseEntity<List<FileDocument>> getAllFileDocuments (){
        return ResponseEntity.ok(fileDocumentService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<FileDocument> getFileDocumentById(@PathVariable Integer id) {
        Optional<FileDocument> fileDocument = fileDocumentService.findById(id);
        if (fileDocument.isPresent()) {
            return ResponseEntity.ok(fileDocument.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    private ResponseEntity<FileDocument> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileDocument savedFileDocument = fileDocumentService.saveFile(file);
            return ResponseEntity.ok(savedFileDocument);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}