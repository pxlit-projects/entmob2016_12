package be.regendans.spring.services;

import be.regendans.spring.daos.AirPressureDao;
import be.regendans.spring.entities.AirPressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Joren on 19/10/2016.
 */
@Service("AirPressureServiceImpl")
public class AirPressureServiceImpl implements AirPressureService{
    @Autowired
    AirPressureDao airPressureDao;

    @Override
    public AirPressure getAirPressureById(int id) {
        return airPressureDao.getAirPressureById(id);
    }

    @Override
    public List<AirPressure> getAllAirPressures() {
        return airPressureDao.getAllAirPressures();
    }

    @Override
    public List<AirPressure> getAllUserAirPressures(int userId) {
        return airPressureDao.getAllUserAirPressures(userId);
    }

    @Override
    public AirPressure newAirPressure(AirPressure a) {
        return airPressureDao.newAirPressure(a);
    }

    @Override
    public String delAirPressureById(int id) {
        return airPressureDao.delAirPressureById(id);
    }
}
