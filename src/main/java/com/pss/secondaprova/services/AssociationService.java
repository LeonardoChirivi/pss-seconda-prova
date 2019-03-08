package com.pss.secondaprova.services;

import com.pss.secondaprova.dto.AssociationDTO;
import com.pss.secondaprova.models.PersonRecord;
import com.pss.secondaprova.repositories.DocumentRepository;
import com.pss.secondaprova.repositories.PersonRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociationService implements IAssociationService {
    private DocumentRepository documentRepository;
    private PersonRecordRepository personRecordRepository;

    @Override
    public void associateDocumentsToPersonRecord(Long personRecordId, AssociationDTO associationDTO) {
        PersonRecord personRecord = personRecordRepository.findById(personRecordId).orElse(null);
        if (personRecord == null)
            return;

        for (Long documentId : associationDTO.getDocumentsId())
            documentRepository
                    .findById(documentId)
                    .ifPresent(document -> personRecord.getDocuments().add(document));

        personRecordRepository.save(personRecord);
    }

    @Override
    public void removeAssociateDocumentsToPersonRecord(Long personRecordId, AssociationDTO associationDTO) {
        PersonRecord personRecord = personRecordRepository.findById(personRecordId).orElse(null);
        if (personRecord == null)
            return;

        for (Long documentId : associationDTO.getDocumentsId())
            documentRepository
                    .findById(documentId)
                    .ifPresent(document -> personRecord.getDocuments().remove(document));

        personRecordRepository.save(personRecord);
    }
}
