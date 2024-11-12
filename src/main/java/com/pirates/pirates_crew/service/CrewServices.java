package com.pirates.pirates_crew.service;

import com.pirates.pirates_crew.model.Crew;
import com.pirates.pirates_crew.repostory.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CrewServices {
    @Autowired
    private CrewRepository crewRepository;

    // Obtener todos los personajes
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }

    // Obtener un personaje por ID
    public Optional<Crew> getCrewById(Long id) {
        return crewRepository.findById(id);
    }

    // Crear o actualizar un personaje
    public Crew saveCrew(Crew crew) {
        return crewRepository.save(crew);
    }

    // Eliminar un personaje
    public void deleteCrew(Long id) {
        crewRepository.deleteById(id);
    }
}
