package com.pss.secondaprova.services;

import com.pss.secondaprova.dto.AssociationDTO;

public interface IAssociationService {
    void associateDocumentsToPersonRecord(Long personRecordId, AssociationDTO associationDTO);

    void removeAssociateDocumentsToPersonRecord(Long personRecordId, AssociationDTO associationDTO);
}
