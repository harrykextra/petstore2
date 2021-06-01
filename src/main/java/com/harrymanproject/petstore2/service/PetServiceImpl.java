package com.harrymanproject.petstore2.service;

import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.data.repository.PetRepository;
import com.harrymanproject.petstore2.exceptions.PetDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petRepository;

    @Override
    public void savePet(Pet pet) throws PetDoesNotExistException {
        if (pet == null){
            throw new PetDoesNotExistException("Pet can not be null");
        }
         petRepository.save(pet);
    }

    @Override
    public void updatePet(Pet pet) throws PetDoesNotExistException{
        if (pet == null){
            throw new PetDoesNotExistException("Pet can npt be null");
        }
        petRepository.save(pet);
    }

    @Override
    public Pet findPetById(Integer id){
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }

    @Override
    public void deletePetById(Integer id){
        petRepository.deleteById(id);
    }
}
