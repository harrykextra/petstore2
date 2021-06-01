package com.harrymanproject.petstore2.data.repository;

import com.harrymanproject.petstore2.data.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface PetRepository extends JpaRepository<Pet,Integer> {

}
