package com.pss.secondaprova.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRecordSaveDTO {
    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;
    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;
    @NotNull
    @Size(min = 1, max = 50)
    private String birthPlace;
    @NotNull
    private char sex;
}
