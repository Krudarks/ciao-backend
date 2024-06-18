package com.sistema.ciao.sistema_ciao_backend.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@SequenceGenerator(
    name = "user_sequence",
    sequenceName="user_sequence",
    allocationSize = 1
 )
 @Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue( strategy=GenerationType.SEQUENCE, generator="user_sequence")
    private Integer id;

    private String email;
    private String password;
    private String name;
    private Date fechaDocument; 
    private Boolean isEnable;
    private Boolean accountNoExpired;
    private Boolean accountLocked;
    private Boolean credentialNoExpired;

    
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role role;

}
