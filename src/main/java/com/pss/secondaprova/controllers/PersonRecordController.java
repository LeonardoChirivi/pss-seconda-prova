package com.pss.secondaprova.controllers;

import com.pss.secondaprova.dto.PersonRecordDTO;
import com.pss.secondaprova.dto.PersonRecordSaveDTO;
import com.pss.secondaprova.services.IPersonRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class PersonRecordController {
    private IPersonRecordService personRecordService;

    @GetMapping("/anagrafiche")
    public List<PersonRecordDTO> getPersonRecords() {
        return personRecordService.getPersonRecords();
    }

    @GetMapping("/anagrafica/{id}")
    public PersonRecordDTO getPersonRecord(@PathVariable Long id) {
        return personRecordService.getPersonRecord(id);
    }

    @PostMapping("/anagrafiche")
    public void savePersonRecord(@Valid @RequestBody PersonRecordSaveDTO personRecordSaveDTO) {
        personRecordService.savePersonRecord(personRecordSaveDTO);
    }

    @PutMapping("/anagrafiche/{id}")
    public void updatePersonRecord(@Valid @RequestBody PersonRecordSaveDTO personRecordSaveDTO, @PathVariable Long id) {
        personRecordService.updatePersonRecord(personRecordSaveDTO, id);
    }

    @DeleteMapping("/anagrafiche/{id}")
    public void deletePersonRecord(@PathVariable Long id) {
        personRecordService.deletePersonRecord(id);
    }
}
