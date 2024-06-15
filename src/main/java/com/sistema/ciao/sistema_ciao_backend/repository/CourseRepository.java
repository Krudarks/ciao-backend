package com.sistema.ciao.sistema_ciao_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.ciao.sistema_ciao_backend.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
