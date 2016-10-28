package be.pxl.regendans.service;

import be.pxl.regendans.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserService{
    User findUserById(int id);
}
