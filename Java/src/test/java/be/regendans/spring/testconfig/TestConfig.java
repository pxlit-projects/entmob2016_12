package be.regendans.spring.testconfig;

import be.regendans.spring.daos.mocks.*;
import be.regendans.spring.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bunyamin
 * @author Joren
 */

@Configuration
public class TestConfig {

    @Bean
    UserServiceImpl userServiceImplMock() { return new UserServiceImpl(); }
    @Bean
    UserDaoMock userDaoMock() { return new UserDaoMock(); }

    // TODO: add test for AirPressure later

    // TODO: add test for Humidity later

    @Bean
    TemperatureServiceImpl temperatureServiceImplMock(){ return  new TemperatureServiceImpl(); }
    @Bean
    TemperatureDaoMock temperatureDaoMock(){ return  new TemperatureDaoMock(); }

    @Bean
    UserLocationServiceImpl userLocationServiceImplMock() { return new UserLocationServiceImpl(); }
    @Bean
    UserLocationDaoMock userLocationDaoMock() { return new UserLocationDaoMock(); }
}
