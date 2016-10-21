package be.regendans.repositories;

import be.regendans.entities.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bunyamin
 */

public interface UserLocationRepository extends JpaRepository<UserLocation, Integer> {

    Optional<UserLocation> findByUserId(int userId);

}