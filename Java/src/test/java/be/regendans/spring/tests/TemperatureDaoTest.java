package be.regendans.spring.tests;

import be.regendans.spring.daos.mocks.TemperatureDaoMock;
import be.regendans.spring.testconfig.TestConfig;
import org.junit.Assert;
import org.junit.Test;
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
public class TemperatureDaoTest {

    @Autowired
    private TemperatureDaoMock temperatureDaoMock;

    @Test
    public void testGetTemperatureById(){
        temperatureDaoMock.getTemperatureById(0);
        Assert.assertTrue(temperatureDaoMock.isGetTemperatureByIdIsCalled());
    }

    @Test
    public void testGetAllTemperatures(){
        temperatureDaoMock.getAllTemperatures();
        Assert.assertTrue(temperatureDaoMock.isGetAllTemperaturesIsCalled());
    }

    @Test
    public void testDeleteTemperature(){
        temperatureDaoMock.deltemperatureById(0);
        Assert.assertTrue(temperatureDaoMock.isDeltemperatureByIdIsCalled());
    }

    @Test
    public void testUpdateTemperatureById(){
        temperatureDaoMock.updateTemperature(null);
        Assert.assertTrue(temperatureDaoMock.isUpdateTemperatureIsCalled());
    }

    @Test
    public void testNewTemperature(){
        temperatureDaoMock.newTemperature(null);
        Assert.assertTrue(temperatureDaoMock.isNewTemperatureIsCalled());
    }


}
