package be.regendans.spring.repositories;

import be.regendans.spring.daos.UserLocationDao;
import be.regendans.spring.entities.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bunyamin
 */

@Repository("UserLocationRepository")
public class UserLocationRepository implements UserLocationDao{

    @Autowired
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) { this.emf = emf; }

    @Override
    public UserLocation getUserLocationById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        UserLocation ul = em.find(UserLocation.class, id);
        tx.commit();
        em.close();
        return ul;
    }

    @Override
    public List<UserLocation> getAllUserLocations() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q = em.createQuery("SELECT ul FROM UserLocation ul");
        List<UserLocation> lu = q.getResultList();
        tx.commit();
        em.close();
        return lu;
    }

    @Override
    public List<UserLocation> getUserLocationByUserId(int userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q = em.createQuery("SELECT ul FROM UserLocation ul WHERE ul.userid = ?1").setParameter(1, userId);
        List<UserLocation> lu = q.getResultList();
        tx.commit();
        em.close();
        return lu;
    }

    @Override
    public String deleteUserLocationById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        UserLocation ul = em.find(UserLocation.class, id);
        em.remove(ul);
        tx.commit();
        em.close();
        return "User with id " + id + " successfully deleted.";
    }

    @Override
    public UserLocation newUserLocation(UserLocation ul) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ul);
        tx.commit();
        tx.begin();
        UserLocation created = em.find(UserLocation.class, ul.getId());
        tx.commit();
        em.close();
        return created;
    }

}