package be.regendans.spring.daos;

import be.regendans.spring.entities.UserLocation;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserLocationDao {

    UserLocation getUserLocationById(int id);
    List<UserLocation> getAllUserLocations();
    List<UserLocation> getUserLocationByUserId(int userId);
    String deleteUserLocationById(int id);
    UserLocation newUserLocation(UserLocation ul);
}
