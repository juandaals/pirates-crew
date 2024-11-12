package com.pirates.pirates_crew.repostory;

import com.pirates.pirates_crew.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoatRepository extends JpaRepository<Boat, Long> {
}
