package be.regendans.spring.daos;

import be.regendans.spring.entities.User;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserDao {

    public User getUserById(int id);
    public List<User> getAllUsers();
    public String deleteUserById(int id);
    public User updateUser(User u);
    public User newUser(User u);
}
