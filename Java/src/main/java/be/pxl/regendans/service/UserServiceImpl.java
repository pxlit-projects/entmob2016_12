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
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User deleteUserById(int id) {
        return userRepository.deleteUserById(id);
    }

    public User updateUser(User u) {
        if(userRepository.findById(u.getId()) != null){
            return userRepository.save(u);
        }

        return null;
    }

    public User save(User u) {
        return userRepository.save(u);
    }
}
