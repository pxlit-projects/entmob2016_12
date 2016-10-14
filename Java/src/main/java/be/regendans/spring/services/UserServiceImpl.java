package be.regendans.spring.services;

import be.regendans.spring.daos.UserDao;
import be.regendans.spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bunyamin
 */

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public User getUserById(int id) { return dao.getUserById(id); }
    @Override
    public List<User> getAllUsers() { return dao.getAllUsers(); }
    @Override
    public String deleteUserById(int id) { return dao.deleteUserById(id); }
    @Override
    public User updateUser(User u) { return dao.updateUser(u); }
    @Override
    public User newUser(User u) { return dao.newUser(u); }
}
