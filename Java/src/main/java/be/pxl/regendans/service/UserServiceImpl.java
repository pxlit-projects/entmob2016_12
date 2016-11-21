package be.pxl.regendans.service;

import be.pxl.regendans.annotation.UserAccessLogger;
import be.pxl.regendans.entity.User;
import be.pxl.regendans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bunyamin
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

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

    @Override
    @UserAccessLogger(message = "Deleted a user")
    public User deleteUserById(int id) {
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
