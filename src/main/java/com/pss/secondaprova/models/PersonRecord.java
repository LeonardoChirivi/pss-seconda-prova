package com.pss.secondaprova.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String birthPlace;
    private char sex;
    @ManyToMany
    @JoinTable(name = "document_personRecord",
            joinColumns = @JoinColumn(name = "personRecord_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id"))
    List<Document> documents;
}
