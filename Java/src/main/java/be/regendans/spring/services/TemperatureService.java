package be.regendans.spring.services;

import be.regendans.spring.entities.Temperature;

import java.util.List;

/**
 * Created by Joren on 14/10/2016.
 */
public interface TemperatureService {
    Temperature getTemperatureById(int id);
    List<Temperature> getAllTemperatures();
    List<Temperature> getAllUserTemperatures(int userId);
    Temperature updateTemperature(Temperature t);
    Temperature newTemperature(Temperature t);
    String delTemperatureById(int id);
}
