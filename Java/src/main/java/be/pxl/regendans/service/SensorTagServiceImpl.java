package be.pxl.regendans.service;

import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Frank on 28-10-2016.
 */
@Service
public class SensorTagServiceImpl implements SensorTagService {

    @Autowired
    TemperatureRepository temperatureRepository;
    @Autowired
    HumidityRepository humidityRepository;
    @Autowired
    AirPressureRepository airPressureRepository;

    @Override
    public boolean doesItRain() {
        return false;
    }
}
