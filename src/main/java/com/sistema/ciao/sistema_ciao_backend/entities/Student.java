package com.sistema.ciao.sistema_ciao_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    name = "student_sequence",
    sequenceName="student_sequence",
    allocationSize = 1
 )
 @Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(generator= "student_sequence", strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String curp;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
