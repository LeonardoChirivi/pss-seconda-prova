package com.pss.secondaprova.controllers;

import com.pss.secondaprova.dto.DocumentDTO;
import com.pss.secondaprova.dto.DocumentSaveDTO;
import com.pss.secondaprova.services.IDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class DocumentController {
    private IDocumentService documentService;

    @GetMapping("/documenti")
    public List<DocumentDTO> getDocuments() {
        return documentService.getDocuments();
    }

    @GetMapping("/documenti/{id}")
    public DocumentDTO getDocument(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping("/documenti")
    public void saveDocument(@Valid @RequestBody DocumentSaveDTO documentSaveDTO) {
        documentService.saveDocument(documentSaveDTO);
    }

    @PutMapping("/documenti/{id}")
    public void updateDocument(@Valid @RequestBody DocumentSaveDTO documentSaveDTO, @PathVariable Long id) {
        documentService.updateDocument(documentSaveDTO, id);
    }

    @DeleteMapping("/documenti/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
}
