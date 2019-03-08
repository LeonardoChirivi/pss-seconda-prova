package com.pss.secondaprova.repositories;

import com.pss.secondaprova.models.PersonRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRecordRepository extends CrudRepository<PersonRecord, Long> {
    List<PersonRecord> findAll();
}
