package com.pss.secondaprova.services;

import com.pss.secondaprova.dto.PersonRecordDTO;
import com.pss.secondaprova.dto.PersonRecordSaveDTO;

import java.util.List;

public interface IPersonRecordService {
    List<PersonRecordDTO> getPersonRecords();

    PersonRecordDTO getPersonRecord(Long id);

    void savePersonRecord(PersonRecordSaveDTO personRecordSaveDTO);

    void updatePersonRecord(PersonRecordSaveDTO personRecordSaveDTO, Long id);

    void deletePersonRecord(Long id);
}
