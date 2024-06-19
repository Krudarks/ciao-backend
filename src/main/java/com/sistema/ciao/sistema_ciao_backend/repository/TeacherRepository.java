package com.sistema.ciao.sistema_ciao_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.ciao.sistema_ciao_backend.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    Optional<Teacher> findTeacherByEmail(String email);
    Optional<Teacher> findTeacherByCurp(String curp);
}