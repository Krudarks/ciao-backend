package com.sistema.ciao.sistema_ciao_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
    name = "course_module_theme_sequence",
    sequenceName = "course_module_theme_sequence",
    allocationSize = 1
)
 @Table(name = "courses_modules_themes")
public class CourseModuleTheme {

    @Id
    @GeneratedValue(generator="course_module_theme_sequence", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    private String courseModuleTheme;

    @ManyToOne
    @JoinColumn(name = "id_course_module")
    private CourseModule courseModule;
}
