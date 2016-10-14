package be.regendans.spring.repositories;

import be.regendans.spring.daos.TemperatureDao;
import be.regendans.spring.entities.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 *  @author Joren
 */

@Repository("TemperatureRepository")
public class TemperatureRepository implements TemperatureDao{
    @Autowired
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Temperature getTemperatureById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Temperature t = em.find(Temperature.class, id);
        tx.commit();
        em.close();
        return t;
    }

    @Override
    public List<Temperature> getAllTemperatures() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q =  em.createQuery("SELECT t  FROM Temperature t");
        List<Temperature> ls = q.getResultList();
        tx.commit();
        em.close();
        return ls;
    }

    @Override
    public List<Temperature> getAllUserTemperatures(int userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q =  em.createQuery("SELECT t  FROM Temperature t WHERE t.userId = ?1").setParameter(1, userId);
        List<Temperature> ls = q.getResultList();
        tx.commit();
        em.close();
        return ls;
    }

    @Override
    public Temperature updateTemperature(Temperature t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(t);
        tx.commit();
        tx.begin();
        Temperature updated = em.find(Temperature.class,t.getUserId());
        tx.commit();
        em.close();
        return updated;
    }

    @Override
    public Temperature newTemperature(Temperature t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        tx.begin();
        Temperature updated = em.find(Temperature.class,t.getUserId());
        tx.commit();
        em.close();
        return updated;
    }

    @Override
    public String deltemperatureById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Temperature t = em.find(Temperature.class, id);
        em.remove(t);
        tx.commit();
        em.close();
        return "Temperature with Id " + id + " successfully deleted";
    }
}
