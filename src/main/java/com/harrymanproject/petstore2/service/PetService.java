package com.harrymanproject.petstore2.service;

import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.exceptions.PetDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PetService {
    void savePet (Pet pet) throws PetDoesNotExistException;
    void updatePet (Pet pet) throws PetDoesNotExistException;
    Pet findPetById (Integer id);
    List<Pet> findAllPets();
    void deletePetById(Integer id);
}
