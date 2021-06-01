package com.harrymanproject.petstore2.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String breed;
    @Enumerated(EnumType.STRING)
    private PetSex petSex;
    @Enumerated(EnumType.STRING)
    private PetType petType;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    Store store;
}
