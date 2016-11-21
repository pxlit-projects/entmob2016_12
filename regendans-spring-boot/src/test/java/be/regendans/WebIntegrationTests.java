package be.regendans;

import be.regendans.entities.*;
import be.regendans.repositories.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Bunyamin
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class WebIntegrationTests {

    @Autowired
    private UserRepository userService;
    @Autowired
    private UserLocationRepository userLocationRepository;
    @Autowired
    private HumidityRepository humidityRepository;
    @Autowired
    private AirPressureRepository airPressureRepository;
    @Autowired
    private TemperatureRepository temperatureRepository;

    @Test
    public void getUserTest() {
        User u = userService.findOne(1);
        assertThat(u).isNotNull();
        assertThat(u.getId()).isEqualTo(1); /* lijkt dom om te testen op id maar als dit faalt weet je dat er iets
                                             scheelt met de database connection, zonder te hoeven weten welke data
                                             er in de database zit */
        assertThat(u.getUsername()).isEqualTo("dipshit");
    }

    @Test
    public void getUserLocationTest() {
        UserLocation ul = userLocationRepository.findOne(1);
        assertThat(ul).isNotNull();
        assertThat(ul.getId()).isEqualTo(1);
        assertThat(ul.getLatitude()).isEqualTo(50.9533f);
    }

    @Test
    public void getHumidityTest() {
        Humidity h = humidityRepository.findOne(1);
        assertThat(h).isNotNull();
        assertThat(h.getId()).isEqualTo(1);
        assertThat(h.getHumidity()).isEqualTo(60.2f);
    }

    @Test
    public void getAirPressureTest() {
        AirPressure ap = airPressureRepository.findOne(1);
        assertThat(ap).isNotNull();
        assertThat(ap.getId()).isEqualTo(1);
        assertThat(ap.getPressure()).isEqualTo(1.012f);
    }

    @Test
    public void getTemperatureTest() {
        Temperature t = temperatureRepository.findOne(1);
        assertThat(t).isNotNull();
        assertThat(t.getId()).isEqualTo(1);
        assertThat(t.getTemperature()).isEqualTo(15.6f);
    }
}
