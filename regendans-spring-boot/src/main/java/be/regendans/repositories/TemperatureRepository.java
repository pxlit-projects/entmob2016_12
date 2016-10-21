package be.regendans.repositories;

import be.regendans.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *  @author Joren
 */

public interface TemperatureRepository extends JpaRepository<Temperature, Integer>{

    Optional<Temperature> findByUserId(int userId);

}
