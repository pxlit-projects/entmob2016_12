package be.regendans.spring.repositories;

import be.regendans.spring.daos.HumidityDao;
import be.regendans.spring.entities.Humidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Joren
 */
@Repository("HumidityRepository")
public class HumidityRepository implements HumidityDao{
    @Autowired
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Humidity gethumidityById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Humidity h = em.find(Humidity.class, id);
        tx.commit();
        em.close();
        return h;
    }

    @Override
    public List<Humidity> getAllHumidities() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q =  em.createQuery("SELECT h  FROM Humidity h");
        List<Humidity> lh = q.getResultList();
        tx.commit();
        em.close();
        return lh;
    }

    @Override
    public List<Humidity> getAllUserHumidities(int userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q =  em.createQuery("SELECT t  FROM Humidity h WHERE h.userId = ?1").setParameter(1, userId);
        List<Humidity> lh = q.getResultList();
        tx.commit();
        em.close();
        return lh;
    }

    @Override
    public Humidity newHumidity(Humidity h) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(h);
        tx.commit();
        tx.begin();
        Humidity updated = em.find(Humidity.class,h.getUserId());
        tx.commit();
        em.close();
        return updated;
    }

    @Override
    public String delHumidityById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Humidity h = em.find(Humidity.class, id);
        em.remove(h);
        tx.commit();
        em.close();
        return "Humidity with Id " + id + " successfully deleted";
    }
}
