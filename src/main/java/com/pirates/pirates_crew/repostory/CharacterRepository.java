package com.pirates.pirates_crew.repostory;


import com.pirates.pirates_crew.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
