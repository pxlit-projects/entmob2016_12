package be.regendans.repositories;

import be.regendans.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  @author Joren
 */

public interface TemperatureRepository extends JpaRepository<Temperature, Integer>{

    List<Temperature> findByUserId(int userId);

}
