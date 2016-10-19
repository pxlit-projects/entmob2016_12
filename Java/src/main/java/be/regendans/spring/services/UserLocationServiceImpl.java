package be.regendans.spring.services;

import be.regendans.spring.daos.UserLocationDao;
import be.regendans.spring.entities.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bunyamin
 */

@Service("UserLocationServiceImpl")
public class UserLocationServiceImpl implements UserLocationService{

    @Autowired
    UserLocationDao dao;

    @Override
    public UserLocation getUserLocationById(int id) {return dao.getUserLocationById(id);}
    @Override
    public List<UserLocation> getAllUserLocations() {return dao.getAllUserLocations();}
    @Override
    public List<UserLocation> getUserLocationByUserId(int userId) {return dao.getUserLocationByUserId(userId);}
    @Override
    public String deleteUserLocationById(int id) {return dao.deleteUserLocationById(id);}
    @Override
    public UserLocation newUserLocation(UserLocation ul) {return dao.newUserLocation(ul);}
}
