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
    name = "roles_sequence",
    sequenceName = "roles_sequence",
    allocationSize = 1
)
@Table(name = "teachers")
public class Roles {
    
    @Id
    @GeneratedValue(generator="roles_sequence", strategy=GenerationType.AUTO)
    private Integer id;

    private String roles;
    private String description;
}
