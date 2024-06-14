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
    name = "student_date_iscribed_sequence",
    sequenceName="student_date_iscribed_sequence",
    allocationSize = 1
 )
 @Table(name = "students_dates_inscribeds")
public class StudentsDateInscribed {
    @Id
    @GeneratedValue(generator="student_date_inscribed_sequence", strategy=GenerationType.AUTO)
    private Integer id;
}
