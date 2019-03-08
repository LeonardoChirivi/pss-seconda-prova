package com.pss.secondaprova.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String protocolNumber;
    private String text;
    @ManyToMany
    @JoinTable(name = "document_personRecord",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "personRecord_id"))
    List<PersonRecord> personRecords;

    @PostPersist
    @PreUpdate
    private void postPersist() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        this.protocolNumber = this.getId() + "/" + year ;
    }
}
