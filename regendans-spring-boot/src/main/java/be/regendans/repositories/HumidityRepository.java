package be.regendans.repositories;

import be.regendans.entities.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Joren
 */

public interface HumidityRepository extends JpaRepository<Humidity, Integer>{

    List<Humidity> findByUserId(int userId);

}
