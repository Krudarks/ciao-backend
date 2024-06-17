package com.sistema.ciao.sistema_ciao_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "permissions")
@SequenceGenerator(name = "permission_sequence", sequenceName = "permission_sequence", allocationSize = 1)
public class Permission {

    @Id
    @GeneratedValue(generator = "permission_sequence", strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    
}
