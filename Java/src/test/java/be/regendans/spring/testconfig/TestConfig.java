package be.regendans.spring.testconfig;

import be.regendans.spring.daos.mocks.*;
import be.regendans.spring.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bunyamin
 */

@Configuration
public class TestConfig {

    @Bean
    UserServiceImpl userServiceImplMock() { return new UserServiceImpl(); }

    @Bean
    UserDaoMock userDaoMock() { return new UserDaoMock(); }

    // TODO: add test for AirPressure later
    // TODO: add test for Humidity later
    // TODO: add test for Temperature later
    // TODO: add test for UserLocation later
}
