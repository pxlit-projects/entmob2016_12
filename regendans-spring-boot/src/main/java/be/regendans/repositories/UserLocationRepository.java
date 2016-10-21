package be.regendans.repositories;

import be.regendans.entities.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserLocationRepository extends JpaRepository<UserLocation, Integer> {

    List<UserLocation> findByUserId(int userId);

}