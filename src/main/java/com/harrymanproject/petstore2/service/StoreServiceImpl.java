package com.harrymanproject.petstore2.service;

import com.harrymanproject.petstore2.data.model.Pet;
import com.harrymanproject.petstore2.data.model.Store;
import com.harrymanproject.petstore2.data.repository.StoreRepository;
import com.harrymanproject.petstore2.exceptions.StoreDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Override
    public void saveStore(Store store) throws StoreDoesNotExistException{
        if (store == null){
            throw new StoreDoesNotExistException("Store can not be null");
        }
        storeRepository.save(store);
    }

    @Override
    public void updateStore(Store store) throws StoreDoesNotExistException{
        if (store == null){
            throw new StoreDoesNotExistException("Store can not be null");
        }
        storeRepository.save(store);
    }

   @Override
    public Store findStoreById(Integer id){
        return storeRepository.findById(id).orElse(null);
   }

    @Override
    public List<Store> findAllStores(){
        return storeRepository.findAll();
    }

    @Override
    public void deleteStoreById(Integer id){
        storeRepository.deleteById(id);
    }
}
