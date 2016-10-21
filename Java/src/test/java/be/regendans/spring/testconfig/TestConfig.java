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
    @Bean
    HumidityServiceImpl humidityServiceImplMock(){return  new HumidityServiceImpl();}
    @Bean
    HumidityDaoMock humidityDaoMock(){return new HumidityDaoMock();}
    @Bean
    AirPressureServiceImpl airPressureServiceImplMock(){return new AirPressureServiceImpl();}
    @Bean
    AirPressureDaoMock airPressureDaoMock(){return new AirPressureDaoMock();}
    @Bean
    TemperatureServiceImpl temperatureServiceImplMock(){ return  new TemperatureServiceImpl(); }
    @Bean
    TemperatureDaoMock temperatureDaoMock(){ return  new TemperatureDaoMock(); }
    @Bean
    UserLocationServiceImpl userLocationServiceImplMock() { return new UserLocationServiceImpl(); }
    @Bean
    UserLocationDaoMock userLocationDaoMock() { return new UserLocationDaoMock(); }
}
