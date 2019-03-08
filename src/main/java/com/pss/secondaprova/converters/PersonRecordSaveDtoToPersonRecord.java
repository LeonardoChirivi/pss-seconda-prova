package com.pss.secondaprova.converters;

import com.pss.secondaprova.dto.PersonRecordSaveDTO;
import com.pss.secondaprova.models.PersonRecord;
import org.springframework.stereotype.Component;

@Component
public class PersonRecordSaveDtoToPersonRecord {
    public PersonRecord convert(PersonRecordSaveDTO personRecordSaveDTO) {
        if (personRecordSaveDTO == null)
            return null;

        PersonRecord personRecord = new PersonRecord();
        personRecord.setFirstName(personRecordSaveDTO.getFirstName());
        personRecord.setLastName(personRecordSaveDTO.getLastName());
        personRecord.setBirthDate(personRecordSaveDTO.getBirthDate());
        personRecord.setBirthPlace(personRecordSaveDTO.getBirthPlace());
        personRecord.setSex(Character.toUpperCase(personRecordSaveDTO.getSex()));
        return personRecord;
    }
}
