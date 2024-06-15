package com.sistema.ciao.sistema_ciao_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.ciao.sistema_ciao_backend.entities.CourseModuleTheme;

@Repository
public interface CourseModuleThemeRepository extends JpaRepository<CourseModuleTheme, Integer> {

}
