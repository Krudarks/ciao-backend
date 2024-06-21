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
    name="typedoc_sequence",
    sequenceName = "type_document_sequence",
    allocationSize=1
)
@Table(name="types_documents")
public class TypeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typedocument_sequence")
    private Integer id;

    private String typeDocument;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
}
