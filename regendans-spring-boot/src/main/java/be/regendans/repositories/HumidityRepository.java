package be.regendans.repositories;

import be.regendans.entities.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * @author Joren
 */

public interface HumidityRepository extends JpaRepository<Humidity, Integer>{

    Optional<Humidity> findByUserId(int userId);

}
