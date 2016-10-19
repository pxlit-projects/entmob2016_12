package be.regendans.spring.daos;

import be.regendans.spring.entities.AirPressure;

import java.util.List;

/**
 *
 */
public interface AirPressureDao {
    AirPressure getAirPressureById(int id);
    List<AirPressure> getAllAirPressures();
    List<AirPressure> getAllUserAirPressures(int userId);
    AirPressure newAirPressure(AirPressure a);
    String delAirPressureById(int id);
}
