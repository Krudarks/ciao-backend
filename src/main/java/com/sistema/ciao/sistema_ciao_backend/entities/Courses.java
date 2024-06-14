package com.sistema.ciao.sistema_ciao_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    name = "course_sequence",
    sequenceName = "course_sequence",
    allocationSize = 1
)
 @Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(generator="courses_sequence", strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    
}
