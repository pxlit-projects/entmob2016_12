package be.regendans.spring.repositories;

import be.regendans.spring.daos.UserDao;
import be.regendans.spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bunyamin on 14/10/2016.
 */

@Repository("UserRepository")
public class UserRepository implements UserDao {

    @Autowired
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) { this.emf = emf; }

    @Override
    public User getUserById(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User u = em.find(User.class, id);
        tx.commit();
        em.close();
        return u;
    }

    @Override
    public List<User> getAllUsers(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q = em.createQuery("SELECT u FROM User u");
        List<User> lu = q.getResultList();
        tx.commit();
        em.close();
        return lu;
    }

    @Override
    public String deleteUserById(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User u = em.find(User.class, id);
        em.remove(u);
        tx.commit();
        em.close();
        return "User with id " + id + " successfully deleted.";
    }

    @Override
    public User updateUser(User u){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(u);
        tx.commit();
        tx.begin();
        User updated = em.find(User.class, u.getId());
        tx.commit();
        em.close();
        return updated;
    }

    @Override
    public User newUser(User u){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u);
        tx.commit();
        tx.begin();
        User created = em.find(User.class, u.getId());
        tx.commit();
        em.close();
        return created;
    }
}
