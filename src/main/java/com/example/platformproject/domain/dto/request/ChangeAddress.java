package com.example.platformproject.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ChangeAddress {
    Long id_student;
    String message;
    String new_value;
    Date date;
}
