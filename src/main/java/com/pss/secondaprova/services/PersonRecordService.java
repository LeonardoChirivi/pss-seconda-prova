package com.pss.secondaprova.services;

import com.pss.secondaprova.converters.PersonRecordSaveDtoToPersonRecord;
import com.pss.secondaprova.converters.PersonRecordToPersonRecordDto;
import com.pss.secondaprova.dto.PersonRecordDTO;
import com.pss.secondaprova.dto.PersonRecordSaveDTO;
import com.pss.secondaprova.models.PersonRecord;
import com.pss.secondaprova.repositories.PersonRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonRecordService implements IPersonRecordService {
    private PersonRecordRepository personRecordRepository;
    private PersonRecordToPersonRecordDto personRecordToPersonRecordDto;
    private PersonRecordSaveDtoToPersonRecord personRecordSaveDtoToPersonRecord;

    @Override
    public List<PersonRecordDTO> getPersonRecords() {
        return personRecordRepository
                .findAll()
                .stream()
                .map(personRecordToPersonRecordDto::convert)
                .collect(Collectors.toList());

    }

    @Override
    public PersonRecordDTO getPersonRecord(Long id) {
        PersonRecord personRecord = personRecordRepository.findById(id).orElse(null);
        if (personRecord == null)
            return null;
        return personRecordToPersonRecordDto.convert(personRecord);
    }

    @Override
    public void savePersonRecord(PersonRecordSaveDTO personRecordSaveDTO) {
        PersonRecord personRecord = personRecordSaveDtoToPersonRecord.convert(personRecordSaveDTO);
        personRecordRepository.save(personRecord);
    }

    @Override
    public void updatePersonRecord(PersonRecordSaveDTO personRecordSaveDTO, Long id) {
        if (!personRecordRepository.existsById(id))
            return;
        PersonRecord updatePersonRecord = personRecordSaveDtoToPersonRecord.convert(personRecordSaveDTO);
        updatePersonRecord.setId(id);
        updatePersonRecord.setDocuments(personRecordRepository.findById(id).get().getDocuments());
        personRecordRepository.save(updatePersonRecord);
    }

    @Override
    public void deletePersonRecord(Long id) {
        PersonRecord personRecord = personRecordRepository.findById(id).orElse(null);
        if (personRecord == null || !personRecord.getDocuments().isEmpty())
            return;
        personRecordRepository.delete(personRecord);
    }
}
