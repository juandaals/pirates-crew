package com.pirates.pirates_crew.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String age;
    private String height;
    private String bounty; // Recompensa
}