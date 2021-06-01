package com.harrymanproject.petstore2.service;

import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.data.model.PetSex;
import com.harrymanproject.petstore2.data.repository.PetRepository;
import com.harrymanproject.petstore2.exceptions.PetDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
class PetServiceImplTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetServiceImpl petServiceImpl;

    Pet testPet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testPet = new Pet();
    }

    @Test
    void mockTheSavePetTest()throws PetDoesNotExistException{
        petServiceImpl.savePet(testPet);
        verify(petRepository, times(1)).save(testPet);
    }

    @Test
    void updatePetTest(){
        Pet pet = new Pet();
        pet.setId(2);
        pet.setName("Cynthia");
        assertThat(pet.getId()).isEqualTo(2);
        assertThat(pet.getName()).isEqualTo("Cynthia");
    }

    @Test
    void mockTheFindByIdTest(){
        when(petRepository.findById(2)).thenReturn(Optional.of(testPet));
        petServiceImpl.findPetById(2);
        verify(petRepository, times(1)).findById(2);
    }

    @Test
    void mockTheDeleteTest(){
        petServiceImpl.deletePetById(2);
        verify(petRepository, times(1)).deleteById(2);
    }


}