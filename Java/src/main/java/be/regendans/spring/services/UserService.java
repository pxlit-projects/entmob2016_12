package be.regendans.spring.services;

import be.regendans.spring.entities.User;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserService {

    User getUserById(int id);
    List<User> getAllUsers();
    String deleteUserById(int id);
    User updateUser(User u);
    User newUser(User u);
}
