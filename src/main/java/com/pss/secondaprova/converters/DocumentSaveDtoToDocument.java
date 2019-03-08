package com.pss.secondaprova.converters;

import com.pss.secondaprova.dto.DocumentSaveDTO;
import com.pss.secondaprova.models.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class DocumentSaveDtoToDocument {
    public Document convert(DocumentSaveDTO documentSaveDTO) {
        if (documentSaveDTO == null)
            return null;

        Document document = new Document();
        document.setText(documentSaveDTO.getText());
        return document;
    }
}
