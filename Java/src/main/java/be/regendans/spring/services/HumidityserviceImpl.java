package be.regendans.spring.services;

import be.regendans.spring.daos.HumidityDao;
import be.regendans.spring.entities.Humidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joren
 */
@Service("HumidityServiceImpl")
public class HumidityserviceImpl implements HumidityService {
    @Autowired
    HumidityDao humidityDao;
    @Override
    public Humidity gethumidityById(int id) {
        return humidityDao.gethumidityById(id);
    }

    @Override
    public List<Humidity> getAllHumidities() {
        return humidityDao.getAllHumidities();
    }

    @Override
    public List<Humidity> getAllUserHumidities(int userId) {
        return humidityDao.getAllUserHumidities(userId);
    }

    @Override
    public Humidity newHumidity(Humidity h) {
        return humidityDao.newHumidity(h);
    }

    @Override
    public String delHumidityById(int id) {
        return humidityDao.delHumidityById(id);
    }
}
