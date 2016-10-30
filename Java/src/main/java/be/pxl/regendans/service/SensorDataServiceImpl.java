package be.pxl.regendans.service;

import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * Created by Frank on 28-10-2016.
 */
@Service
public class SensorDataServiceImpl implements SensorDataService {

    @Autowired
    AirPressureRepository airPressureRepository;
    @Autowired
    HumidityRepository humidityRepository;
    @Autowired
    TemperatureRepository temperatureRepository;

    @Override
    public Temperature saveTemperature(double degrees,int userId) {
        Temperature temperature = new Temperature();
        temperature.setTemperature(degrees);
        temperature.setTimestamp(Timestamp.from(Instant.now()));
        temperature.setUserid(userId);
        return temperatureRepository.save(temperature);
    }

    @Override
    public Humidity saveHumidity(double moist,int userId) {
        Humidity humidity = new Humidity();
        humidity.setHumidity(moist);
        humidity.setTimestamp(Timestamp.from(Instant.now()));
        humidity.setUserId(userId);
        return humidityRepository.save(humidity);
    }

    @Override
    public AirPressure saveAirPressure(double pressure,int userId) {
        AirPressure airPressure = new AirPressure();
        airPressure.setPressure(pressure);
        airPressure.setUserid(userId);
        airPressure.setTimestamp(Timestamp.from(Instant.now()));
        return airPressureRepository.save(airPressure);
    }
}
