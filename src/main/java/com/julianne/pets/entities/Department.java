package com.julianne.pets.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "chief_vet")
    private String chief_vet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_room")
    private Room main_room;
}
