package be.regendans.spring.services;

import be.regendans.spring.entities.UserLocation;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserLocationService {

    UserLocation getUserLocationById(int id);
    List<UserLocation> getAllUserLocations();
    List<UserLocation> getUserLocationByUserId(int userId);
    String deleteUserLocationById(int id);
    UserLocation newUserLocation(UserLocation ul);
}
