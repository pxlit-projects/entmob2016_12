package be.pxl.regendans.service;

import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Temperature saveTemperature(float degrees) {
        Temperature temperature = new Temperature();
        return temperatureRepository.save(temperature);
    }

    @Override
    public Humidity saveHumidity(float moist) {
        Humidity humidity = new Humidity();
        return humidityRepository.save(humidity);
    }

    @Override
    public AirPressure saveAirPressure(float pressure) {
        AirPressure airPressure = new AirPressure();
        return airPressureRepository.save(airPressure);
    }
}
