package com.pss.secondaprova.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRecordDTO {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;
    private String birthPlace;
    private char sex;
    private List<DocumentDTO> documents;
}
