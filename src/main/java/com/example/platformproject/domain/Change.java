package com.example.platformproject.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "change")
public class Change {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_student;
    private String new_value;
    private String old_value;
    private Date date;
    private Boolean viewed;
}
