package com.sistema.ciao.sistema_ciao_backend.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sistema.ciao.sistema_ciao_backend.entities.FileDocument;
import com.sistema.ciao.sistema_ciao_backend.repository.FileDocumentRepository;

@Service
public class FileDocumentService {

    private static String UPLOAD_DIR = "uploads/";

    @Autowired
    private FileDocumentRepository fileDocumentRepository;

    public List<FileDocument> findAll() {
        return fileDocumentRepository.findAll();
    }

    public Optional<FileDocument> findById(Integer id) {
        return fileDocumentRepository.findById(id);
    }

    public FileDocument save(FileDocument fileDocument) {
        return fileDocumentRepository.save(fileDocument);
    }

    public FileDocument saveFile(MultipartFile file) throws IOException {
        // Crear el directorio si no existe
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Guardar el archivo en el sistema de archivos
        Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        Files.write(filePath, file.getBytes());

        // Crear y guardar la entidad FileDocument
        FileDocument fileDocument = new FileDocument();
        fileDocument.setDocument(filePath.toString());
        return fileDocumentRepository.save(fileDocument);
    }
}