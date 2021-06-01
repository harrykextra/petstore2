package com.harrymanproject.petstore2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.data.model.PetSex;
import com.harrymanproject.petstore2.data.model.PetType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class PetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }
    @Test
    void whenICallTheCreatePetPostMethod() throws Exception{
        Pet pet = new Pet();
        pet.setName("Billy");
        pet.setBreed("German shepherd");
        pet.setPetType(PetType.DOG);
        pet.setPetSex(PetSex.MALE);

        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/pet/create")
                .contentType("application/json").content(mapper.writeValueAsString(pet)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

    }

    @Test
    void  whenICallFindPetById() throws Exception{
        this.mockMvc.perform(get("/pet/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallFindAllPets() throws Exception{
        this.mockMvc.perform(get("/pet/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallDelete() throws Exception{
        this.mockMvc.perform(get("/pet/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}