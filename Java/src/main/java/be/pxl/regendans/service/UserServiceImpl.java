package be.pxl.regendans.service;

import be.pxl.regendans.entity.User;
import be.pxl.regendans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bunyamin
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserById(int id) { return userRepository.findUserById(id); }
}
