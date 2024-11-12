package com.pirates.pirates_crew.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Boats")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String type;
    private String roman_name;
}