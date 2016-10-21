package be.regendans.repositories;

import be.regendans.entities.AirPressure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Joren
 */

public interface AirPressureRepository extends JpaRepository<AirPressure, Integer>{

    List<AirPressure> findByUserId(int userId);
}
