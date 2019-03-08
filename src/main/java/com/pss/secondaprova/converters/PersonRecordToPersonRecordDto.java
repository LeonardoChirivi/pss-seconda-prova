package com.pss.secondaprova.converters;

import com.pss.secondaprova.dto.PersonRecordDTO;
import com.pss.secondaprova.models.PersonRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonRecordToPersonRecordDto {
    private DocumentToDocumentDto documentToDocumentDto;

    public PersonRecordDTO convert(PersonRecord personRecord) {
        if (personRecord == null)
            return null;

        PersonRecordDTO personRecordDTO = new PersonRecordDTO();
        personRecordDTO.setId(personRecord.getId());
        personRecordDTO.setFirstName(personRecord.getFirstName());
        personRecordDTO.setLastName(personRecord.getLastName());
        personRecordDTO.setBirthDate(personRecord.getBirthDate());
        personRecordDTO.setBirthPlace(personRecord.getBirthPlace());
        personRecordDTO.setSex(personRecord.getSex());
        personRecordDTO.setDocuments(personRecord.getDocuments()
                .stream()
                .map(documentToDocumentDto::convert)
                .collect(Collectors.toList()));
        return personRecordDTO;
    }
}
