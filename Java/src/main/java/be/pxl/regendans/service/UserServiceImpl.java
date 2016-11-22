package be.pxl.regendans.service;

import be.pxl.regendans.annotation.UserAccessLogger;
import be.pxl.regendans.entity.User;
import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import be.pxl.regendans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bunyamin
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private HumidityRepository humidityRepository;
    @Autowired
    private AirPressureRepository airPressureRepository;
    @

    @Override
    @UserAccessLogger(message = "Searched for specific user")
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    @UserAccessLogger(message = "Retrieved list of all users")
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @UserAccessLogger(message = "Deleted a user")
    @Transactional()
    public User deleteUserById(int id) {
        humidityRepository.deleteHumidityByUserid(id);
        temperatureRepository.deleteTemperatureByUserid(id);
        airPressureRepository.deleteAirpressureByUserid(id);
        return userRepository.deleteUserById(id);
    }

    @UserAccessLogger(message = "Updated a user")
    public User updateUser(User u) {
        if(userRepository.findById(u.getId()) != null){
            return userRepository.save(u);
        }
        return null;
    }

    @UserAccessLogger(message = "Saved a user")
    public User save(User u) {
        return userRepository.save(u);
    }
}
