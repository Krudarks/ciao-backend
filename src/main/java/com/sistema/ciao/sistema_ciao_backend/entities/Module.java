package com.sistema.ciao.sistema_ciao_backend.entities;

import com.sistema.ciao.sistema_ciao_backend.entities.Module;

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
    name = "module_sequence",
    sequenceName = "module_sequence",
    allocationSize = 1
)
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(generator="module_sequence", strategy=GenerationType.AUTO)
    private Integer id;

    private String module; 

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
}
