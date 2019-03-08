package com.pss.secondaprova.repositories;

import com.pss.secondaprova.models.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document, Long> {
    List<Document> findAll();
}
