package com.pss.secondaprova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentDTO {
    private Long id;
    private String protocolNumber;
    private String text;
}
