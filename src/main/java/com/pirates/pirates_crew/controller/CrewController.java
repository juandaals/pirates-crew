package com.pirates.pirates_crew.controller;

import com.pirates.pirates_crew.model.Crew;
import com.pirates.pirates_crew.service.CrewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("crew")
public class CrewController {
    @Autowired
    private CrewServices crewService;

    // Obtener todos los personajes
    @GetMapping
    public ResponseEntity<List<Crew>> getAllCrews() {
        return ResponseEntity.ok(crewService.getAllCrews());
    }

    // Obtener un personaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<Crew> getCrewById(@PathVariable Long id) {
        Optional<Crew> crew = crewService.getCrewById(id);
        return crew.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo personaje
    @PostMapping
    public ResponseEntity<Crew> createCrew(@RequestBody Crew crew) {
        Crew savedCrew = crewService.saveCrew(crew);
        return ResponseEntity.ok(savedCrew);
    }

    // Actualizar un personaje existente
    @PutMapping("/{id}")
    public ResponseEntity<Crew> updateCrew(@PathVariable Long id, @RequestBody Crew crew) {
        Optional<Crew> existingCrew = crewService.getCrewById(id);

        if (existingCrew.isPresent()) {
            Crew updatedCrew = existingCrew.get();
            updatedCrew.setName(crew.getName());
            updatedCrew.setFlag(crew.getFlag());
            updatedCrew.setUser(crew.getUser());
            updatedCrew.setMembers(crew.getMembers());

            Crew savedCrew = crewService.saveCrew(updatedCrew);
            return ResponseEntity.ok(savedCrew);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un personaje
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrew(@PathVariable Long id) {
        crewService.deleteCrew(id);
        return ResponseEntity.noContent().build();
    }
}
