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
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @NotBlank
    @Column(nullable = false)
    private String phone;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String CURP;

    @NotBlank
    @Column(nullable = false)
    private String cedula;

    @NotBlank
    @Column(nullable = false)
    private String ine;

       @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_sex")
    private Sex sex;
}
