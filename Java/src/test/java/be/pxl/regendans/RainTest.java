package be.pxl.regendans;

import be.pxl.regendans.builders.HumidityBuilder;
import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import be.pxl.regendans.service.SensorTagService;
import org.assertj.core.api.AssertProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Frank on 22-11-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class RainTest {

    @Autowired
    SensorTagService sensorTagService;
    @Autowired
    public TemperatureRepository temperatureRepository;
    @Autowired
    public HumidityRepository humidityRepository;
    @Autowired
    public AirPressureRepository airPressureRepository;

    @Test
    public void doesItRainTest() throws Exception {
        Humidity humidity = mock(Humidity.class);
        Temperature temperature = mock(Temperature.class);
        AirPressure airPressure = mock(AirPressure.class);
        humidityRepository = mock(HumidityRepository.class);
        temperatureRepository = mock(TemperatureRepository.class);
        airPressureRepository = mock(AirPressureRepository.class);

        when(humidity.getHumidity()).thenReturn(25.0);
        when(temperature.getTemperature()).thenReturn(25.0);
        when(airPressure.getPressure()).thenReturn(25.0);

        when(humidityRepository.findHumidityByUserid(1)).thenReturn(Arrays.asList(humidity));
        when(temperatureRepository.findTemperatureByUserid(1)).thenReturn(Arrays.asList(temperature));
        when(airPressureRepository.findAirpressureByUserid(1)).thenReturn(Arrays.asList(airPressure));

        assertThat(sensorTagService.doesItRain(1)).isFalse();
    }
}
