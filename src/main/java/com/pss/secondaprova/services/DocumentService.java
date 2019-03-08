package com.pss.secondaprova.services;

import com.pss.secondaprova.converters.DocumentSaveDtoToDocument;
import com.pss.secondaprova.converters.DocumentToDocumentDto;
import com.pss.secondaprova.dto.DocumentDTO;
import com.pss.secondaprova.dto.DocumentSaveDTO;
import com.pss.secondaprova.models.Document;
import com.pss.secondaprova.repositories.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DocumentService implements IDocumentService {
    private DocumentRepository documentRepository;
    private DocumentToDocumentDto documentToDocumentDto;
    private DocumentSaveDtoToDocument documentSaveDtoToDocument;

    @Override
    public List<DocumentDTO> getDocuments() {
        return documentRepository
                .findAll()
                .stream()
                .map(documentToDocumentDto::convert)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDTO getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        if (document == null)
            return null;
        return documentToDocumentDto.convert(document);
    }

    @Override
    public void saveDocument(DocumentSaveDTO documentSaveDTO) {
        Document document = documentSaveDtoToDocument.convert(documentSaveDTO);
        documentRepository.save(document);
    }

    @Override
    public void updateDocument(DocumentSaveDTO documentSaveDTO, Long id) {
        if (!documentRepository.existsById(id))
            return;
        Document updateDocument = documentSaveDtoToDocument.convert(documentSaveDTO);
        updateDocument.setId(id);
        documentRepository.save(updateDocument);
    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
