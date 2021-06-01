package com.harrymanproject.petstore2.datarepository;

import com.harrymanproject.petstore2.data.model.Store;
import com.harrymanproject.petstore2.data.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class StoreRepositoryTest {

    @Autowired
    StoreRepository storeRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    public void saveStoreTest(){
        Store store = new Store();
        store.setName("Class pets");
        store.setAddress("9, Cosmos street, Yaba, Lagos");
        store.setEMailAddress("classpets@gmail.com");
        store.setContactNumber("080-4444-5555");
        storeRepository.save(store);
        log.info("saving store object-->{}", store);

    }

    @Test
    public void findStoreByIdTest(){
        Store storeId = storeRepository.findById(5).orElse(null);
        assertThat(storeId.getId()).isEqualTo(5);
        log.info("find store by id ->{}", storeId);
    }

    @Test
    public void deleteStoreByIdTest(){
        storeRepository.findById(5).orElse(null);
        storeRepository.deleteById(5);
        assertThat(storeRepository.existsById(5)).isFalse();
    }

    @Test
    public void getAllStoresTest(){
        List<Store> getAllStores = storeRepository.findAll();
        assertThat(getAllStores.size()).isEqualTo(1);
    }

    @Test
    public void getAllPetsInAStoreTest(){
        List<Store> getAllStores = storeRepository.findAll();
        log.info("List of stores in our database ->{}", getAllStores);
    }
}
