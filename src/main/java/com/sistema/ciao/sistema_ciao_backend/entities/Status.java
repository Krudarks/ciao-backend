package com.sistema.ciao.sistema_ciao_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
    name = "status",
    sequenceName = "status_sequence",
    allocationSize = 1
)
public class Status {
    @Id
    @GeneratedValue(generator="status_sequence", strategy=GenerationType.AUTO)
    private Integer id;
    
    private String status; 
}
