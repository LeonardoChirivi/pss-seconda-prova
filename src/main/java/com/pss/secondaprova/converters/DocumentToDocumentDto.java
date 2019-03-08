package com.pss.secondaprova.converters;

import com.pss.secondaprova.dto.DocumentDTO;
import com.pss.secondaprova.models.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class DocumentToDocumentDto {
    public DocumentDTO convert(Document document) {
        if (document == null)
            return null;

        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setId(document.getId());
        documentDTO.setProtocolNumber(document.getProtocolNumber());
        documentDTO.setText(document.getText());
        return documentDTO;
    }
}
