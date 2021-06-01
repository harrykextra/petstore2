package com.harrymanproject.petstore2.controller;

import com.harrymanproject.petstore2.data.model.Store;
import com.harrymanproject.petstore2.exceptions.StoreDoesNotExistException;
import com.harrymanproject.petstore2.service.StoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreServiceImpl storeServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> saveStore(@RequestBody Store store) {
        log.info("Request object -----> {}", store);
        try{
            storeServiceImpl.saveStore(store);
        }catch (StoreDoesNotExistException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStores(){
        log.info("Get end point called");
        List<Store> storeList = storeServiceImpl.findAllStores();
        log.info("retrieve stores from database----->{}", storeList);
        return ResponseEntity.ok().body(storeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findOneStore(@PathVariable("id") Integer id){
        log.info("id of store to be found------>{}", id);
        Store store = storeServiceImpl.findStoreById(id);
        return ResponseEntity.ok().body(store);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteStore(@PathVariable Integer id){
        log.info("id of store to be found----->{}", id);
        storeServiceImpl.deleteStoreById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
