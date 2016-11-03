package be.pxl.regendans.service;

import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;

import java.util.List;

/**
 * Created by Frank on 28-10-2016.
 */
public interface SensorDataService{
    Temperature saveTemperature(Temperature temperature);
    Humidity saveHumidity(Humidity humidity);
    AirPressure saveAirPressure(AirPressure airPressure);
}
