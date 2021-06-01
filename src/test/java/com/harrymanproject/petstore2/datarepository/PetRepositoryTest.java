package com.harrymanproject.petstore2.datarepository;

import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.data.model.PetSex;
import com.harrymanproject.petstore2.data.model.PetType;
import com.harrymanproject.petstore2.data.model.Store;
import com.harrymanproject.petstore2.data.repository.PetRepository;
import com.harrymanproject.petstore2.data.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class PetRepositoryTest {

    @Autowired
    PetRepository petRepository;

    @Autowired
    StoreRepository storeRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    public void savePetTest() {
        Pet pet = new Pet();
        pet.setName("Bruno");
        pet.setPetSex(PetSex.MALE);
        pet.setPetType(PetType.DOG);
        pet.setBreed("Bulldog");
    //    pet.setId(1);

        petRepository.save(pet);

        log.info("saving pet object-->{}");

        assertThat(pet.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void ToMapListOfPetToAStoreTest(){
        Store store = new Store();
        Pet pet = new Pet();
        pet.setName("Klaus");
        pet.setPetSex(PetSex.MALE);
        pet.setPetType(PetType.FISH);
        pet.setBreed("Goldfish");

        Store store1 = storeRepository.findById(4).orElse(null);

        pet.setStore(store1);

        petRepository.save(pet);
        log.info("Mapping pet to store --> {}", pet);

    }

    @Test
    public void findPetByIdTest(){
        Pet petId = petRepository.findById(3).orElse(null);
        assertThat(petId.getId()).isEqualTo(3);
        log.info("find pet by id -->{}", petId);
    }

    @Test
    public void deletePetByIdTest(){
        petRepository.findById(2).orElse(null);
        petRepository.deleteById(2);
        assertThat(petRepository.existsById(2)).isFalse();
    }

    @Test
    public void getAllPetTest(){
        List<Pet> getPet = petRepository.findAll();
        assertThat(getPet.size()).isEqualTo(3);
    }

}
