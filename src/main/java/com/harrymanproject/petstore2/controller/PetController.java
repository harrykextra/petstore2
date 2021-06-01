package com.harrymanproject.petstore2.controller;

import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.exceptions.PetDoesNotExistException;
import com.harrymanproject.petstore2.service.PetServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetServiceImpl petServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> savePet(@RequestBody Pet pet){
        log.info("Request object ----> {}", pet);
        try{
            petServiceImpl.savePet(pet);
        }catch (PetDoesNotExistException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllPets(){
        log.info("Get end point called");
        List<Pet> petList = petServiceImpl.findAllPets();
        log.info("retrieve pets from database----->{}",petList);
        return ResponseEntity.ok().body(petList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findOnePet(@PathVariable("id") Integer id){
        log.info("id of pets to be found----->", id);
        Pet pet;
        pet = petServiceImpl.findPetById(id);

        return ResponseEntity.ok().body(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletePet(@PathVariable Integer id){
        log.info("id of pets to be found----->{}",id);
        petServiceImpl.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
