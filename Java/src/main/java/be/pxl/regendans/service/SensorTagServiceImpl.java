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
public class SensorTagServiceImpl implements SensorTagService {

    @Autowired
    TemperatureRepository temperatureRepository;
    @Autowired
    HumidityRepository humidityRepository;
    @Autowired
    AirPressureRepository airPressureRepository;

    @Override
    public boolean doesItRain(int userId) {
        List<Temperature> temperatureList = temperatureRepository.findTemperatureByUserid(userId);
        List<Humidity> humidityList = humidityRepository.findHumidityByUserid(userId);
        List<AirPressure> airPressureList = airPressureRepository.findAirpressureByUserid(userId);

        long cold = temperatureList.stream()
                .sorted((temp1, temp2) -> Long.compare(temp1.getTimestamp().getTime(),temp2.getTimestamp().getTime()))
                .limit(5)
                .filter(Temperature::cold)
               .count();
        long moist = humidityList.stream()
                .sorted((humidity1, humidity2) -> Long.compare(humidity1.getTimestamp().getTime(),humidity2.getTimestamp().getTime()))
                .limit(5)
                .filter(Humidity::moist)
                .count();
        long highPressure = airPressureList.stream()
                .sorted((airPressure1, airPressure2) -> Long.compare(airPressure1.getTimestamp().getTime(),airPressure2.getTimestamp().getTime()))
                .limit(5)
                .filter(AirPressure::lowPressure)
                .count();

        return cold == 5 && moist == 5 && highPressure == 5;
    }
}
