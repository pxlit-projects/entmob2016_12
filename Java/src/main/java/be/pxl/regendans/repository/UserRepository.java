package be.pxl.regendans.repository;

import be.pxl.regendans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bunyamin
 */

public interface UserRepository extends CrudRepository<User,Integer>{
    User findUserById(int id);
}