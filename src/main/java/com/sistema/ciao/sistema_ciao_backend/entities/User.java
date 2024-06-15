package com.sistema.ciao.sistema_ciao_backend.entities;

import java.util.Date;

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
    name = "user_sequence",
    sequenceName="user_sequence",
    allocationSize = 1
 )
 @Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="user_sequence", strategy=GenerationType.AUTO)
    private Integer id;

    private String email;
    private String password;
    private String name;
    private Date fechaDocument; 
    
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
}
