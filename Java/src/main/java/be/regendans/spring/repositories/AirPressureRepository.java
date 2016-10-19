package be.regendans.spring.repositories;

import be.regendans.spring.daos.AirPressureDao;
import be.regendans.spring.entities.AirPressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Joren
 */
@Repository("AirPressureRepository")
public class AirPressureRepository implements AirPressureDao {
    @Autowired
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public AirPressure getAirPressureById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        AirPressure ap = em.find(AirPressure.class, id);
        tx.commit();
        em.close();
        return ap;
    }

    @Override
    public List<AirPressure> getAllAirPressures() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q =  em.createQuery("SELECT a  FROM AirPressure a");
        List<AirPressure> lap = q.getResultList();
        tx.commit();
        em.close();
        return lap;
    }

    @Override
    public List<AirPressure> getAllUserAirPressures(int userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q =  em.createQuery("SELECT a  FROM AirPressure a WHERE a.userId = ?1").setParameter(1, userId);
        List<AirPressure> lap = q.getResultList();
        tx.commit();
        em.close();
        return lap;
    }

    @Override
    public AirPressure newAirPressure(AirPressure a) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        tx.commit();
        tx.begin();
        AirPressure updated = em.find(AirPressure.class,a.getUserId());
        tx.commit();
        em.close();
        return updated;
    }

    @Override
    public String delAirPressureById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        AirPressure ap = em.find(AirPressure.class, id);
        em.remove(ap);
        tx.commit();
        em.close();
        return "AirPressure with Id " + id + " successfully deleted";
    }
}
