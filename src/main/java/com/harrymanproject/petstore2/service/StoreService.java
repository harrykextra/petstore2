package com.harrymanproject.petstore2.service;

import com.harrymanproject.petstore2.data.model.Store;
import com.harrymanproject.petstore2.exceptions.StoreDoesNotExistException;

import java.util.List;

public interface StoreService {

    void saveStore(Store store)throws StoreDoesNotExistException;
    void updateStore(Store store) throws StoreDoesNotExistException;
    Store findStoreById(Integer id);
    List<Store> findAllStores();
    void deleteStoreById(Integer id);
}
