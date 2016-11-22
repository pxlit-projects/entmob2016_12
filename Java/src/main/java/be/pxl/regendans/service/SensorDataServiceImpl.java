package be.pxl.regendans.service;

import be.pxl.regendans.annotation.UserAccessLogger;
import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.entity.User;
import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Temperature saveTemperature( Temperature temperature) {
        temperature.setTimestamp(Timestamp.from(Instant.now()));
        return temperatureRepository.save(temperature);
    }

    @Override
    public Humidity saveHumidity(Humidity humidity) {
        humidity.setTimestamp(Timestamp.from(Instant.now()));
        return humidityRepository.save(humidity);
    }

    @Override
    public AirPressure saveAirPressure(AirPressure airPressure) {
        airPressure.setTimestamp(Timestamp.from(Instant.now()));
        return airPressureRepository.save(airPressure);
    }
}
