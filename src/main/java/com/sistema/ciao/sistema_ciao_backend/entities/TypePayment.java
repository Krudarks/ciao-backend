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
    name = "type_payment_sequence",
    sequenceName = "type_payment_sequence",
    allocationSize = 1
)
@Table(name="types_payments")
public class TypePayment {

    @Id
    @GeneratedValue(generator="type_payment_sequence", strategy = GenerationType.AUTO)
    private Integer id;
    
    private String method;
    //private String userModificado;
    //private Date fechaDocument; 

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
}
