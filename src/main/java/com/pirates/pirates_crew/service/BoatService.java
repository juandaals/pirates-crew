package com.pirates.pirates_crew.service;

import com.pirates.pirates_crew.model.Boat;
import com.pirates.pirates_crew.repostory.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    // Obtener todos los personajes
    public List<com.pirates.pirates_crew.model.Boat> getAllBoats() {
        return boatRepository.findAll();
    }

    // Obtener un personaje por ID
    public Optional<com.pirates.pirates_crew.model.Boat> getBoatById(Long id) {
        return boatRepository.findById(id);
    }

    // Crear o actualizar un personaje
    public com.pirates.pirates_crew.model.Boat saveBoat(Boat boat) {
        return boatRepository.save(boat);
    }

    // Eliminar un personaje
    public void deleteBoat(Long id) {
        boatRepository.deleteById(id);
    }
}
