package be.pxl.regendans.service;

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
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    public User updateUser(User u) {
        if(userRepository.findUserById(u.getId()) != null){
            return userRepository.save(u);
        }

        return null;
    }

    public User save(User u) {
        return userRepository.save(u);
    }
}
