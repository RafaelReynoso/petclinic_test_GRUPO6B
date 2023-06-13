package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class VetControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllVets() throws Exception{

        int ID_FIRST_RECORD = 1;

        this.mockMvc.perform((get("/vets")))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));

    }

    @Test
    public void testFindVetOK() throws Exception {

        String NAME_VET = "James";
        String LASTNAME_VET = "Carter";

        mockMvc.perform(get("/vets/1"))  // Object must be BASIL
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is(NAME_VET)))
                .andExpect(jsonPath("$.lastname", is(LASTNAME_VET)));
    }

    @Test
    public void testFindVetKO() throws Exception {

        mockMvc.perform(get("/vets/666"))
                .andExpect(status().isNotFound());

    }

    @Test
    public void testCreateVet() throws Exception {

        String NAME_VET = "Rafael";
        String LASTNAME_VET = "Reynoso";

        VetTO newVetTO = new VetTO();
        newVetTO.setFirst_name(NAME_VET);
        newVetTO.setLast_name(LASTNAME_VET);

        mockMvc.perform(post("/pets")
                .content(om.writeValueAsString(newVetTO))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.first_name", is(NAME_VET)))
                .andExpect(jsonPath("$.last_name", is(LASTNAME_VET)));
    }
    
}
