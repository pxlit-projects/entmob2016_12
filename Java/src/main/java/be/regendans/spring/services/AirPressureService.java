package be.regendans.spring.services;

import be.regendans.spring.entities.AirPressure;

import java.util.List;

/**
 * @author Joren
 */
public interface AirPressureService {
    AirPressure getAirPressureById(int id);
    List<AirPressure> getAllAirPressures();
    List<AirPressure> getAllUserAirPressures(int userId);
    AirPressure newAirPressure(AirPressure a);
    String delAirPressureById(int id);
}
