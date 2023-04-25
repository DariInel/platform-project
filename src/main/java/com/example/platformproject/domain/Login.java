package com.example.platformproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    private Long id;

    private String email;
    private String phoneNumber;

    //  @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    // @PrimaryKeyJoinColumn
    // private UserAccess userAccess;
}
