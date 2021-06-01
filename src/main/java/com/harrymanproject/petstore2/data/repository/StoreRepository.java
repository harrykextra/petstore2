package com.harrymanproject.petstore2.data.repository;

import com.harrymanproject.petstore2.data.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Integer> {
}
