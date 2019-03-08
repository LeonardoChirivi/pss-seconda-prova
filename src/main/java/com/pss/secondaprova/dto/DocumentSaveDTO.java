package com.pss.secondaprova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentSaveDTO {
    @NotNull
    @Size(min = 1, max = 50)
    private String text;
}
