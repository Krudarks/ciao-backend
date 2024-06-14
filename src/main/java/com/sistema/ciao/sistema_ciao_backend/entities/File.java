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
    name = "file_sequence",
    sequenceName = "file_sequence",
    allocationSize = 1
)
@Table(name="files")
public class File {

    @Id
    @GeneratedValue(generator = "file_sequence", strategy = GenerationType.AUTO)
    private Integer id;
    private String document;
    private String cheksum;

    @ManyToOne
    @JoinColumn(name = "id_type_document")
    private TypeDocument typeDocument;
}
