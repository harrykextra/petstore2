package com.harrymanproject.petstore2.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String eMailAddress;
    private String contactNumber;


    @OneToMany(mappedBy = "store", cascade = {CascadeType.PERSIST},orphanRemoval = true, fetch = FetchType.EAGER)
    List<Pet> petList;

    public void addPet(Pet pet) {
        if (petList == null) {
            petList = new ArrayList<>();
        }
        petList.add(pet);
    }


}
