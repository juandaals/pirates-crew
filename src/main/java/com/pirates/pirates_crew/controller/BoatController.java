package com.pirates.pirates_crew.controller;

import com.pirates.pirates_crew.model.Boat;
import com.pirates.pirates_crew.service.BoatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/boats")
public class BoatController {
    @Autowired
    private BoatService boatService;

    // Obtener todos los personajes
    @GetMapping
    public ResponseEntity<List<com.pirates.pirates_crew.model.Boat>> getAllBoats() {
        return ResponseEntity.ok(boatService.getAllBoats());
    }

    // Obtener un personaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<com.pirates.pirates_crew.model.Boat> getBoatById(@PathVariable Long id) {
        Optional<com.pirates.pirates_crew.model.Boat> boat = boatService.getBoatById(id);
        return boat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo personaje
    @PostMapping
    public ResponseEntity<com.pirates.pirates_crew.model.Boat> createBoat(@RequestBody com.pirates.pirates_crew.model.Boat boat) {
        com.pirates.pirates_crew.model.Boat savedBoat = boatService.saveBoat(boat);
        return ResponseEntity.ok(savedBoat);

    }

    // Actualizar un personaje existente
    @PutMapping("/{id}")
    public ResponseEntity<com.pirates.pirates_crew.model.Boat> updateBoat(@PathVariable Long id, @RequestBody com.pirates.pirates_crew.model.Boat boat) {
        Optional<com.pirates.pirates_crew.model.Boat> existingBoat = boatService.getBoatById(id);

        if (existingBoat.isPresent()) {
            com.pirates.pirates_crew.model.Boat updatedBoat = existingBoat.get();
            updatedBoat.setName(boat.getName());
            updatedBoat.setType(boat.getType());
            updatedBoat.setRoman_name(boat.getRoman_name());

            Boat savedBoat = boatService.saveBoat(updatedBoat);
            return ResponseEntity.ok(savedBoat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un personaje
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoat(@PathVariable Long id) {
        boatService.deleteBoat(id);
        return ResponseEntity.noContent().build();
    }
}
