package com.pss.secondaprova.services;

import com.pss.secondaprova.dto.DocumentDTO;
import com.pss.secondaprova.dto.DocumentSaveDTO;

import java.util.List;

public interface IDocumentService {
    List<DocumentDTO> getDocuments();

    DocumentDTO getDocumentById(Long id);

    void saveDocument(DocumentSaveDTO documentSaveDTO);

    void updateDocument(DocumentSaveDTO documentSaveDTO, Long id);

    void deleteDocument(Long id);
}
