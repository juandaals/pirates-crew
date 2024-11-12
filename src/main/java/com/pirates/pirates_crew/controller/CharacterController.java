package com.pirates.pirates_crew.controller;

import com.pirates.pirates_crew.model.Character;
import com.pirates.pirates_crew.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    // Obtener todos los personajes
    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    // Obtener un personaje por ID
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        Optional<Character> character = characterService.getCharacterById(id);
        return character.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo personaje
    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character savedCharacter = characterService.saveCharacter(character);
        log.info("Created character: {}", character);
        return ResponseEntity.ok(savedCharacter);

    }

    // Actualizar un personaje existente
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        Optional<Character> existingCharacter = characterService.getCharacterById(id);

        if (existingCharacter.isPresent()) {
            Character updatedCharacter = existingCharacter.get();
            updatedCharacter.setName(character.getName());
            updatedCharacter.setAge(character.getAge());
            updatedCharacter.setHeight(character.getHeight());
            updatedCharacter.setBounty(character.getBounty());

            Character savedCharacter = characterService.saveCharacter(updatedCharacter);
            return ResponseEntity.ok(savedCharacter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un personaje
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }
}
