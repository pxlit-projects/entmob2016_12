package be.pxl.regendans;

import be.pxl.regendans.controller.SensorDataController;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.entity.User;
import be.pxl.regendans.repository.AirPressureRepository;
import be.pxl.regendans.repository.HumidityRepository;
import be.pxl.regendans.repository.TemperatureRepository;
import be.pxl.regendans.repository.UserRepository;
import com.google.gson.*;
import org.assertj.core.internal.cglib.asm.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.pxl.regendans.builders.UserBuilder.user;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Frank on 28-10-2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class UserIntergrationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private HumidityRepository humidityRepository;
    @Autowired
    private AirPressureRepository airPressureRepository;
    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

        userRepository.deleteAll();
        temperatureRepository.deleteAll();
        humidityRepository.deleteAll();
        airPressureRepository.deleteAll();
    }

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {
        mappingJackson2HttpMessageConverter = asList(converters)
                .stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .get();

        assertThat(mappingJackson2HttpMessageConverter)
                .isNotNull()
                .describedAs("the JSON message converter must not be null");
    }

    @Test
    public void findUserById_ReturnsUserByGivenUsername() throws Exception {
        User userJan = user().setUsername("Jan").setPassword("P@ssword").build();
        userRepository.save(userJan);

        User goldenUser = userRepository.findByUsername("Jan");

        assertThat(goldenUser.getUsername()).isEqualTo("Jan");
    }

    @Test
    public void saveTemperatureTest() throws Exception {
        Map<String, Object> json = new HashMap<>();

        User userJan = user().setUsername("Jan").setPassword("P@ssword").build();
        userRepository.save(userJan);

        Double temperature = 25.0; // degrees
        Integer userId = 1; // Jan

        json.put("temperature", temperature);
        json.put("userid", userId);

        MvcResult result = mockMvc.perform(post(SensorDataController.SENSORDATA_BASE_URL + "/temperature")
                .content(asJson(json))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        Map jsonMap = new Gson().fromJson(result.getResponse().getContentAsString(), Map.class);

        assertThat(Double.parseDouble(jsonMap.get("temperature").toString())).isEqualTo(25.0);
    }

    @Test
    public void saveHumdityTest() throws Exception {
        Map<String, Object> json = new HashMap<>();

        User userJan = user().setUsername("Jan").setPassword("P@ssword").build();
        userRepository.save(userJan);

        Double humidity = 25.0; // degrees
        Integer userId = 1; // Jan

        json.put("humidity", humidity);
        json.put("userid", userId);

        MvcResult result = mockMvc.perform(post(SensorDataController.SENSORDATA_BASE_URL + "/humidity")
                .content(asJson(json))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        Map jsonMap = new Gson().fromJson(result.getResponse().getContentAsString(), Map.class);

        assertThat(Double.parseDouble(jsonMap.get("humidity").toString())).isEqualTo(25.0);
    }

    @Test
    public void saveAirPressureTest() throws Exception {
        Map<String, Object> json = new HashMap<>();

        User userJan = user().setUsername("Jan").setPassword("P@ssword").build();
        userRepository.save(userJan);

        Double airPressure = 25.0; // degrees
        Integer userId = 1; // Jan

        json.put("airpressure", airPressure);
        json.put("userid", userId);

        MvcResult result = mockMvc.perform(post(SensorDataController.SENSORDATA_BASE_URL + "/airpressure")
                .content(asJson(json))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        Map jsonMap = new Gson().fromJson(result.getResponse().getContentAsString(), Map.class);

        assertThat(Double.parseDouble(jsonMap.get("pressure").toString())).isEqualTo(25.0);
    }



    @SuppressWarnings("unchecked")
    protected String asJson(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
