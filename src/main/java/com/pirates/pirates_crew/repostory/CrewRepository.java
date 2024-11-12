package com.pirates.pirates_crew.repostory;

import com.pirates.pirates_crew.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<Crew, Long> {
}