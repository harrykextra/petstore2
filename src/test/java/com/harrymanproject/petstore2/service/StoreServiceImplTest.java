package com.harrymanproject.petstore2.service;

import com.harrymanproject.petstore2.data.model.Store;
import com.harrymanproject.petstore2.data.repository.StoreRepository;
import com.harrymanproject.petstore2.exceptions.StoreDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Slf4j
class StoreServiceImplTest {

    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreServiceImpl storeServiceImpl;

    Store testStore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testStore = new Store();
    }

    @Test
    void MockTheSaveStoreTest() throws StoreDoesNotExistException {
        storeServiceImpl.saveStore(testStore);
        verify(storeRepository, times(1)).save(testStore);

    }

    @Test
    void MockTheUpdateStoreTest() throws StoreDoesNotExistException{
        storeServiceImpl.updateStore(testStore);
        verify(storeRepository, times(1)).save(testStore);
    }

    @Test
    void MockTheFindStoreByIdTest(){
        when(storeRepository.findById(3)).thenReturn(Optional.of(testStore));
        storeServiceImpl.findStoreById(3);
        verify(storeRepository, times(1)).findById(3);
    }

    @Test
    void MockTheDeleteStoreByIdTest(){
        storeServiceImpl.deleteStoreById(1);
        verify(storeRepository, times(1)).deleteById(1);
    }

}