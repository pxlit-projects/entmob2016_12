package be.pxl.regendans.service;

import be.pxl.regendans.entity.User;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserService{
    User findUserById(int id);
    List<User> findAll();
    User deleteUserById(int id);
    User updateUser(User u);
}
