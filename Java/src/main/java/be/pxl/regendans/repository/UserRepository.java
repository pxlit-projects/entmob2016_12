package be.pxl.regendans.repository;

import be.pxl.regendans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bunyamin
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);

    User findById(int id);

    User deleteUserById(int id);
}