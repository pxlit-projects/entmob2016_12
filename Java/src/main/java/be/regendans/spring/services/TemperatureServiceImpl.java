package be.regendans.spring.services;

import be.regendans.spring.daos.TemperatureDao;
import be.regendans.spring.entities.Temperature;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Joren on 14/10/2016.
 */
public class TemperatureServiceImpl implements TemperatureService {
    @Autowired
    TemperatureDao temperatureDao;
    @Override
    public Temperature getTemperatureById(int id) {
        return temperatureDao.getTemperatureById(id);
    }

    @Override
    public List<Temperature> getAllTemperatures() {
        return temperatureDao.getAllTemperatures();
    }

    @Override
    public List<Temperature> getAllUserTemperatures(int userId) {
        return temperatureDao.getAllUserTemperatures(userId);
    }

    @Override
    public Temperature updateTemperature(Temperature t) {
        return temperatureDao.updateTemperature(t);
    }

    @Override
    public Temperature newTemperature(Temperature t) {
        return temperatureDao.newTemperature(t);
    }

    @Override
    public String deltemperatureById(int id) {
        return temperatureDao.deltemperatureById(id);
    }
}
