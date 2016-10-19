package be.regendans.spring.daos.mocks;

import be.regendans.spring.daos.UserLocationDao;
import be.regendans.spring.entities.UserLocation;

import java.util.List;

/**
 * @author Bunyamin
 */

public class UserLocationDaoMock implements UserLocationDao {

    private boolean getUserLocationByIdIsCalled = false;
    private boolean getAllUserLocationsIsCalled = false;
    private boolean getUserLocationByUserIdIsCalled = false;
    private boolean deleteUserLocationByIdIsCalled = false;
    private boolean newUserLocationIsCalled = false;

    public boolean isGetUserLocationByIdIsCalled() { return getUserLocationByIdIsCalled; }
    public boolean isGetAllUserLocationsIsCalled() { return getAllUserLocationsIsCalled; }
    public boolean isGetUserLocationByUserIdIsCalled() { return getUserLocationByUserIdIsCalled; }
    public boolean isDeleteUserLocationByIdIsCalled() { return deleteUserLocationByIdIsCalled; }
    public boolean isNewUserLocationIsCalled() { return newUserLocationIsCalled; }

    @Override
    public UserLocation getUserLocationById(int id) {
        getUserLocationByIdIsCalled = true;
        return null;
    }

    @Override
    public List<UserLocation> getAllUserLocations() {
        getAllUserLocationsIsCalled = true;
        return null;
    }

    @Override
    public List<UserLocation> getUserLocationByUserId(int userId) {
        getUserLocationByUserIdIsCalled = true;
        return null;
    }

    @Override
    public String deleteUserLocationById(int id) {
        deleteUserLocationByIdIsCalled = true;
        return null;
    }

    @Override
    public UserLocation newUserLocation(UserLocation ul) {
        newUserLocationIsCalled = true;
        return null;
    }
}
