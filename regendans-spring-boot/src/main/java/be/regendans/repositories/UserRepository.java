package be.regendans.repositories;

import be.regendans.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Bunyamin
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}