package com.sistema.ciao.sistema_ciao_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.ciao.sistema_ciao_backend.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
