package com.pirates.pirates_crew.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "crews")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String flag; // Bandera seleccionada

    @OneToMany(cascade = CascadeType.ALL)
    private List<Character> members;

    @ManyToOne
    private User user;
}