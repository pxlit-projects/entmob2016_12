package be.regendans.spring.services;

import be.regendans.spring.entities.User;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserService {

    public User getUserById(int id);
    public List<User> getAllUsers();
    public String deleteUserById(int id);
    public User updateUser(User u);
    public User newUser(User u);
}
