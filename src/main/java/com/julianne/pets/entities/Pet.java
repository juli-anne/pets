package com.julianne.pets.entities;

import jakarta.persistence.*;
import lombok.Data;

// entity - java class/table in mysql
@Entity
@Data
@Table (name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private Integer age;
}
