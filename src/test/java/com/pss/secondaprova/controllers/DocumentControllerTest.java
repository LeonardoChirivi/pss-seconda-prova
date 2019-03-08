package com.pss.secondaprova.controllers;

import com.pss.secondaprova.dto.DocumentDTO;
import com.pss.secondaprova.dto.DocumentSaveDTO;
import com.pss.secondaprova.services.IDocumentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

public class DocumentControllerTest {
    @Mock
    private IDocumentService documentService;
    private DocumentController documentController;
    private MockMvc mockMvc;
    private ArrayList<DocumentDTO> documents;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        documentController = new DocumentController(documentService);
        mockMvc = MockMvcBuilders.standaloneSetup(documentController).build();
        documents = generateDocuments();
    }

    @Test
    public void getDocuments_ShouldReturnOk() throws Exception {
        when(documentService.getDocuments()).thenReturn(documents);

        mockMvc.perform(get("/documenti"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(documents.size())));

        verify(documentService, times(1)).getDocuments();
    }

    @Test
    public void getSingleDocumentTest() throws Exception {
        DocumentDTO documentDTO = documents.get(2);
        when(documentService.getDocumentById(anyLong())).thenReturn(documentDTO);

        mockMvc.perform(get("/documenti/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.protocolNumber", is("3/2019")))
                .andExpect(jsonPath("$.text", is("text3")));

        verify(documentService, times(1)).getDocumentById(anyLong());
    }

    @Test
    public void postDocument_ShouldBeOk() throws Exception {
        DocumentSaveDTO documentSaveDTO = getDocumentSaveDTO();

        doNothing().when(documentService).saveDocument(any(DocumentSaveDTO.class));

        mockMvc.perform(post("/documenti")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(documentSaveDTO)))
                .andExpect(status().isOk());

        verify(documentService, times(1)).saveDocument(any(DocumentSaveDTO.class));
    }

    @Test
    public void updateDocument_ShouldBeOk() throws Exception {
        DocumentSaveDTO documentSaveDTO = getDocumentSaveDTO();

        doNothing().when(documentService).updateDocument(any(DocumentSaveDTO.class), anyLong());

        mockMvc.perform(put("/documenti/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(documentSaveDTO)))
                .andExpect(status().isOk());

        verify(documentService, times(1)).updateDocument(any(DocumentSaveDTO.class), anyLong());
    }

    @Test
    public void deleteDocument_ShouldReturnOk() throws Exception {
        doNothing().when(documentService).deleteDocument(anyLong());

        mockMvc.perform(delete("/documenti/2"))
                .andExpect(status().isOk());

        verify(documentService, times(1)).deleteDocument(anyLong());
    }

    private DocumentSaveDTO getDocumentSaveDTO() {
        DocumentSaveDTO documentSaveDTO = new DocumentSaveDTO();
        documentSaveDTO.setText("text to save");
        return documentSaveDTO;
    }

    private ArrayList<DocumentDTO> generateDocuments() {
        ArrayList<DocumentDTO> documents = new ArrayList<>();
        documents.add(new DocumentDTO(1L, "1/2019", "text1"));
        documents.add(new DocumentDTO(2L, "2/2019", "text2"));
        documents.add(new DocumentDTO(3L, "3/2019", "text3"));
        documents.add(new DocumentDTO(4L, "4/2019", "text4"));
        return documents;
    }
}