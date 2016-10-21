package be.regendans.repositories;

import be.regendans.entities.AirPressure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Joren
 */

public interface AirPressureRepository extends JpaRepository<AirPressure, Integer>{

    Optional<AirPressure> findByUserId(int userId);
}
