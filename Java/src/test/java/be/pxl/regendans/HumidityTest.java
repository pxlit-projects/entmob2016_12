package be.pxl.regendans;

import be.pxl.regendans.builders.HumidityBuilder;
import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.service.SensorTagService;
import org.assertj.core.api.AssertProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Frank on 22-11-2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class HumidityTest {
    @Autowired
    SensorTagService sensorTagService;

    @Test
    public void humdidityTest() throws Exception {
        Humidity humidity = mock(Humidity.class);

        when(humidity.getHumidity()).thenReturn(25.0);
        assertThat(humidity.moist()).isFalse();
    }
}
