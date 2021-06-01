package com.harrymanproject.petstore2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrymanproject.petstore2.data.model.Store;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class StoreControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenICallTheCreateStorePostMethod() throws Exception{
        Store store = new Store();
        store.setName("Ella's place");
        store.setAddress("5, Toyin street, Yaba, Lagos");
        store.setEMailAddress("ellasplace@gmail.com");
        store.setContactNumber("090-9999-5555");

        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/store/create")
        .contentType("application/json").content(mapper.writeValueAsString(store)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void whenICallFindAllStores() throws Exception{
        this.mockMvc.perform(get("/store/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallFindStoreById() throws Exception{
        this.mockMvc.perform(get("/store/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallDelete() throws Exception{
        this.mockMvc.perform(get("/store/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}