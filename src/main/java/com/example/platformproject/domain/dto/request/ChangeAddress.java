package com.example.platformproject.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ChangeAddress {
    Long id_student;
    String old_address;
    String new_address;
    Date date;
}
