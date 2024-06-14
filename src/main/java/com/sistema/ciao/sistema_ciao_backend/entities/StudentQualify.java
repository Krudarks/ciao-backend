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
    name = "student_qualify_sequence",
    sequenceName="student_qualify_sequence",
    allocationSize = 1
 )
 @Table(name = "students_qualifies")
public class StudentQualify {

    @Id
    @GeneratedValue(generator="student_qualify_sequence", strategy=GenerationType.AUTO)
    private Integer id;

    private String qualification;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "id_course_module_theme")
    private CourseModuleTheme courseModuleTheme;
}

