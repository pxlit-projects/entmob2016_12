package be.regendans.spring.tests;

import be.regendans.spring.daos.mocks.HumidityDaoMock;
import be.regendans.spring.testconfig.TestConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Joren
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@DirtiesContext
public class TestHumidityDao {
    @Autowired
    HumidityDaoMock humidityDaoMock;
}
