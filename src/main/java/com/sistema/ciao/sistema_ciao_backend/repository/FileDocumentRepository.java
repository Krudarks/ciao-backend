package com.sistema.ciao.sistema_ciao_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.ciao.sistema_ciao_backend.entities.FileDocument;

@Repository
public interface FileDocumentRepository extends JpaRepository<FileDocument, Integer> {

}
