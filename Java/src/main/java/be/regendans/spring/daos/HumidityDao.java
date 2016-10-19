package be.regendans.spring.daos;

import be.regendans.spring.entities.Humidity;

import java.util.List;

/**
 * Created by Joren on 19/10/2016.
 */
public interface HumidityDao {
    Humidity gethumidityById(int id);
    List<Humidity> getAllHumidities();
    List<Humidity> getAllUserHumidities(int userId);
    Humidity newHumidity(Humidity h);
    String delHumidityById(int id);
}
