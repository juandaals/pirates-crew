package com.pirates.pirates_crew.service;

import com.pirates.pirates_crew.model.Character;
import com.pirates.pirates_crew.repostory.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    // Obtener todos los personajes
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Obtener un personaje por ID
    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    // Crear o actualizar un personaje
    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    // Eliminar un personaje
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
