package com.sistema.ciao.sistema_ciao_backend.entities;

import jakarta.persistence.Column;
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
    name = "teacher_sequence",
    sequenceName = "teacher_sequence",
    allocationSize = 1
)
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(generator = "teacher_sequence", strategy=GenerationType.SEQUENCE)
    private Integer id;

    
    @Column(nullable = false)
    private String name;

   
    @Column(nullable = false)
    private String lastName;

   
    @Column(nullable = false)
    private String phone;

   
    @Column(unique = true, nullable = false)
    private String email;

   
    @Column(unique = true, nullable = false)
    private String curp;

   
    @Column(nullable = false)
    private String cedula;

   
    @Column(nullable = false)
    private String ine;

       @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_sex")
    private Sex sex;
}
