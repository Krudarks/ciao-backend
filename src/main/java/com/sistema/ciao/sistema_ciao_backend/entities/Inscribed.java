package com.sistema.ciao.sistema_ciao_backend.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    name = "inscribed_sequence",
    sequenceName = "inscribed_sequence",
    allocationSize=1
)
@Table(name="inscribeds")
public class Inscribed {

    @Id
    @GeneratedValue(generator = "inscribed_sequence",strategy = GenerationType.AUTO)
    private Integer id;

    private String inscribed;
    
    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_inscribed",
               joinColumns = @JoinColumn(name = "id_student"),
               inverseJoinColumns = @JoinColumn(name = "id_inscribed"))
    private List<Student> student;
}
