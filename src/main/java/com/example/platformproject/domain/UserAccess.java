package com.example.platformproject.domain;

import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_access")

public class UserAccess {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
    private String role;
    private Boolean isWorked;
}
