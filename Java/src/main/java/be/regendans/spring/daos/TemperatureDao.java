package be.regendans.spring.daos;

import be.regendans.spring.entities.Temperature;

import java.util.List;

/**
 * Created by Joren on 14/10/2016.
 */
public interface TemperatureDao {
    Temperature getTemperatureById(int id);
    List<Temperature> getAllTemperatures();
    List<Temperature> getAllUserTemperatures(int userId);
    Temperature updateTemperature(Temperature t);
    Temperature newTemperature(Temperature t);
    String deltemperatureById(int id);

}
