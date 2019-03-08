package com.pss.secondaprova.controllers;

import com.pss.secondaprova.dto.AssociationDTO;
import com.pss.secondaprova.services.IAssociationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AssociationController {
    private IAssociationService associationService;

    @PutMapping("/associa/anagrafica/{personRecordId}")
    public void associateDocumentsToPersonRecord(@PathVariable Long personRecordId,
                                                 @RequestBody AssociationDTO associationDTO) {
        associationService.associateDocumentsToPersonRecord(personRecordId, associationDTO);
    }

    @DeleteMapping("/associa/anagrafica/{personRecordId}")
    public void removeAssociateDocumentsToPersonRecord(@PathVariable Long personRecordId,
                                                       @RequestBody AssociationDTO associationDTO) {
        associationService.removeAssociateDocumentsToPersonRecord(personRecordId, associationDTO);
    }
}
