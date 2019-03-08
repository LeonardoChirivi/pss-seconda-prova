package com.pss.secondaprova.controllers;

import com.pss.secondaprova.dto.PersonRecordDTO;
import com.pss.secondaprova.services.IPersonRecordService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonRecordControllerTest {
    @Mock
    private IPersonRecordService personRecordService;
    private PersonRecordController personRecordController;
    private MockMvc mockMvc;
    private ArrayList<PersonRecordDTO> records;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        personRecordController = new PersonRecordController(personRecordService);
        mockMvc = MockMvcBuilders.standaloneSetup(personRecordController).build();
        records = generateRecords();
    }

    @Test
    public void getPersonRecords_ShouldReturnOk() throws Exception {
        when(personRecordService.getPersonRecords()).thenReturn(records);

        mockMvc.perform(get("/anagrafiche"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(records.size())));

        verify(personRecordService, times(1)).getPersonRecords();
    }

    @Test
    public void getSingleRecordTest() throws Exception {
        PersonRecordDTO record = records.get(1);
        when(personRecordService.getPersonRecord(anyLong())).thenReturn(record);

        mockMvc.perform(get("/anagrafica/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.firstName", is("name")));

        verify(personRecordService, times(1)).getPersonRecord(anyLong());
    }

    @Test
    public void deletePersonRecord_ShouldReturnOk() throws Exception {
        doNothing().when(personRecordService).deletePersonRecord(anyLong());

        mockMvc.perform(delete("/anagrafiche/2"))
                .andExpect(status().isOk());

        verify(personRecordService, times(1)).deletePersonRecord(anyLong());
    }

    private ArrayList<PersonRecordDTO> generateRecords() {
        ArrayList<PersonRecordDTO> records = new ArrayList<>();
        records.add(new PersonRecordDTO(1L, "name", "lastname", new Date(), "place", 'M', new ArrayList<>()));
        records.add(new PersonRecordDTO(2L, "name", "lastname", new Date(), "place", 'f', new ArrayList<>()));
        records.add(new PersonRecordDTO(3L, "name", "lastname", new Date(), "place", 'f', new ArrayList<>()));
        return records;
    }
}